package br.unisul.pweb.diego.exercicio.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.unisul.pweb.diego.exercicio.domain.Competicao;
import br.unisul.pweb.diego.exercicio.repositories.CompeticaoRepository;

import java.util.List;
import java.util.Optional;

@Service
public class CompeticaoService {

    @Autowired
    private CompeticaoRepository competicaoRepository;

    public Competicao findById(Integer id) {
        Optional<Competicao> competicao = competicaoRepository.findById(id);
        return competicao.orElse(null);
    }
    public List<Competicao> findAll() {
        return competicaoRepository.findAll();
    }
    public Competicao insert(Competicao competicao) {
        competicao.setId(null);
        return competicaoRepository.save(competicao);
    }
    public Competicao update(Competicao competicao) {
        findById(competicao.getId());
        return competicaoRepository.save(competicao);
    }
    public void deleteById(Integer id) {
        competicaoRepository.deleteById(id);
    }

}
