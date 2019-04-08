package br.unisul.pweb.diego.exercicio.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.unisul.pweb.diego.exercicio.domain.Competicao;
import br.unisul.pweb.diego.exercicio.dtos.CompeticaoDTO;
import br.unisul.pweb.diego.exercicio.services.CompeticaoService;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value="/competicoes")
public class CompeticaoResource {

    @Autowired
    private CompeticaoService competicaoService;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Competicao> findById(@PathVariable Integer id) {
        Competicao competicao = competicaoService.findById(id);
        return ResponseEntity.ok().body(competicao);
    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<CompeticaoDTO>> findAll() {
        List<Competicao> competicoes = competicaoService.findAll();
        List<CompeticaoDTO> competicaoDTO = competicoes.stream().map(competicao -> new CompeticaoDTO(competicao)).collect(Collectors.toList());
        return ResponseEntity.ok().body(competicaoDTO);
    }

    @RequestMapping(method=RequestMethod.POST)
    public ResponseEntity<Void>insert(@RequestBody Competicao competicao){
        competicao = competicaoService.insert(competicao);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().
                path("/{id}").buildAndExpand(competicao.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @RequestMapping(value="/{id}", method=RequestMethod.PUT)
    public ResponseEntity<Void> update(@RequestBody Competicao obj, @PathVariable Integer id){
        obj.setId(id);
        obj = competicaoService.update(obj);
        return ResponseEntity.noContent().build();
    }

    @RequestMapping(value="/{id}", method=RequestMethod.DELETE)
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        competicaoService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

}