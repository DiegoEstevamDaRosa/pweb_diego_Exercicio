package br.unisul.pweb.diego.exercicio.services;

import java.text.ParseException;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.unisul.pweb.diego.exercicio.domain.Atleta;
import br.unisul.pweb.diego.exercicio.domain.Competicao;
import br.unisul.pweb.diego.exercicio.domain.enums.MODALIDADE;
import br.unisul.pweb.diego.exercicio.repositories.AtletaRepository;
import br.unisul.pweb.diego.exercicio.repositories.CompeticaoRepository;

@Service
public class DbService {

	@Autowired
	private AtletaRepository atleRep;
	
	@Autowired
	private CompeticaoRepository compRep;
	
	public void inicializaBancoDeDados() throws ParseException{
		
		Competicao comp1 = new Competicao(null, "Competição 1", "07/04/2019");
		Competicao comp2 = new Competicao(null, "Competição 2", "08/05/2019");
		Competicao comp3 = new Competicao(null, "Competição 3", "09/06/2019");		
		compRep.saveAll(Arrays.asList(comp1,comp2, comp3));
		
		Atleta atleta1 = new Atleta(null, "Diego Estevam", MODALIDADE.FUTEBOL);
		Atleta atleta2 = new Atleta(null, "Kayki Estevam", MODALIDADE.BASQUETE);

		atleta1.getCompeticoes().addAll(Arrays.asList(comp1, comp3));
		atleta2.getCompeticoes().addAll(Arrays.asList(comp2, comp3));
		atleRep.saveAll(Arrays.asList(atleta1,atleta2));
	}

}
