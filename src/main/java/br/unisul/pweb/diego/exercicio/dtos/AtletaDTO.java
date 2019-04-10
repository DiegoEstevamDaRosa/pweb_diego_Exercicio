package br.unisul.pweb.diego.exercicio.dtos;

import java.io.Serializable;
import br.unisul.pweb.diego.exercicio.domain.Atleta;

public class AtletaDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer id;
    private String nome;

    public AtletaDTO() {
        
    }
    public AtletaDTO(Atleta atl) {
		id = atl.getId();
		nome = atl.getNome();
	}
	public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
	
}