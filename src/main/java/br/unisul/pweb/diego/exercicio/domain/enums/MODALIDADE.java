package br.unisul.pweb.diego.exercicio.domain.enums;

public enum MODALIDADE {

	FUTEBOL(1, "Futebol"),
	VOLEI(2, "Volei"),
	BASQUETE(3, "Basquete"),
	CORRIDA(4, "Corrida"),
	NATACAO(5,	"Natação");
	
	private int cod;
	private String descricao;
	
	private MODALIDADE(int cod, String descricao) {
		this.cod = cod;
		this.descricao = descricao;
	}
	public int getCod() {
		return cod;
	}
	public void setCod(int cod) {
		this.cod = cod;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public static MODALIDADE toEnum(Integer cod) {

		if (cod == null) {
			return null;
		}

		for (MODALIDADE x : MODALIDADE.values()) {
			if (cod.equals(x.getCod())) {
				return x;
			}
		}

		throw new IllegalArgumentException("Id inválido: " + cod);
	}
	
}
