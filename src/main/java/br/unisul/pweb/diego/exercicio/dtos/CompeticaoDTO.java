package br.unisul.pweb.diego.exercicio.dtos;

import java.io.Serializable;

import br.unisul.pweb.diego.exercicio.domain.Competicao;

public class CompeticaoDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer id;
    private String descricao;
    private String data;

    public CompeticaoDTO() {
    	
    }
    public CompeticaoDTO (Competicao cpt) {
       id = cpt.getId();
       descricao = cpt.getDescricao();
       data = cpt.getData();
    }
    public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
}