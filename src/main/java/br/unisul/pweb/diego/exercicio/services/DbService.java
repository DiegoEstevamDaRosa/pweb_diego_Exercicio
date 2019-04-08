package br.unisul.pweb.diego.exercicio.services;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;

import br.unisul.pweb.diego.exercicio.domain.Atleta;
import br.unisul.pweb.diego.exercicio.domain.Competicao;
import br.unisul.pweb.diego.exercicio.repositories.AtletaRepository;
import br.unisul.pweb.diego.exercicio.repositories.CompeticaoRepository;

public class DbService {

	@Autowired
	private AtletaRepository atleRep;
	
	@Autowired
	private CompeticaoRepository compRep;
	
	public void inicializaBancoDeDados() {
		
		Atleta atleta1 = new Atleta(null, "Diego Estevam", "Futebol");
		Atleta atleta2 = new Atleta(null, "Kayki ER", "Natação");
		
		Competicao comp1 = new Competicao(null, "Competição 1", "07/04", null);
		Competicao comp2 = new Competicao(null, "Competição 2", "08/04", null);
		
		atleta1.getCompeticoes().addAll(Arrays.asList(comp1));
		atleta2.getCompeticoes().addAll(Arrays.asList(comp2));
		
		comp1.getAtletas().addAll(Arrays.asList(atleta1));
		comp2.getAtletas().addAll(Arrays.asList(atleta2));
		
		atleRep.saveAll(Arrays.asList(atleta1, atleta2));
		compRep.saveAll(Arrays.asList(comp1, comp2));
	
	}

}
