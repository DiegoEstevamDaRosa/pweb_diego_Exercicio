package br.unisul.pweb.diego.exercicio.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.unisul.pweb.diego.exercicio.domain.Atleta;

@Repository
public interface AtletaRepository extends JpaRepository<Atleta, Integer>{

}
