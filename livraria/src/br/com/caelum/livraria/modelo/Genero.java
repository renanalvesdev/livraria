package br.com.caelum.livraria.modelo;

public enum Genero {

	ROMANCE("Romance"),
	DRAMA("Drama"),
	ACAO("Ação");
	
	Genero(String descricao) {
		this.descricao = descricao;
	}
	
	private String descricao;
	
    public String getDescricao() {
        return descricao;
    }
	
}
