package br.unisul.pweb.diego.exercicio.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.unisul.pweb.diego.exercicio.domain.Atleta;
import br.unisul.pweb.diego.exercicio.dtos.AtletaDTO;
import br.unisul.pweb.diego.exercicio.services.AtletaService;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value="/atletas")
public class AtletaResource {

    @Autowired
    private AtletaService atletaService;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Atleta> findById(@PathVariable Integer id) {
        Atleta atleta = atletaService.findById(id);
        return ResponseEntity.ok().body(atleta);
    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<AtletaDTO>> findAll() {
        List<Atleta> competicoes = atletaService.findAll();
        List<AtletaDTO> competicaoDTO = competicoes.stream().map(atleta -> new AtletaDTO(atleta)).collect(Collectors.toList());
        return ResponseEntity.ok().body(competicaoDTO);
    }

    @RequestMapping(method=RequestMethod.POST)
    public ResponseEntity<Void>insert(@RequestBody Atleta atleta){
        atleta = atletaService.insert(atleta);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().
                path("/{id}").buildAndExpand(atleta.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @RequestMapping(value="/{id}", method=RequestMethod.PUT)
    public ResponseEntity<Void> update(@RequestBody Atleta atleta, @PathVariable Integer id){
        atleta.setId(id);
        atleta = atletaService.update(atleta);
        return ResponseEntity.noContent().build();
    }

    @RequestMapping(value="/{id}", method=RequestMethod.DELETE)
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        atletaService.deleteById(id);
        return ResponseEntity.noContent().build();
    }


}
