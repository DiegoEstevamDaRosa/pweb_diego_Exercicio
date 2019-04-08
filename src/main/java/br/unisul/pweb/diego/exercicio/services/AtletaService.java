package br.unisul.pweb.diego.exercicio.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.unisul.pweb.diego.exercicio.domain.Atleta;
import br.unisul.pweb.diego.exercicio.repositories.AtletaRepository;

import java.util.List;
import java.util.Optional;

@Service
public class AtletaService {

    @Autowired
    private AtletaRepository atletaRepository;

    public Atleta findById(Integer id) {
        Optional<Atleta> athlete = atletaRepository.findById(id);
        return athlete.orElse(null);
    }
    public List<Atleta> findAll(){
        return atletaRepository.findAll();
    }
    public  Atleta insert(Atleta atleta) {
        atleta.setId(null);
        return  atletaRepository.save(atleta);
    }
    public Atleta update(Atleta atleta) {
        findById(atleta.getId());
        return atletaRepository.save(atleta);
    }
    public void deleteById(Integer id) {
        atletaRepository.deleteById(id);
    }

}
