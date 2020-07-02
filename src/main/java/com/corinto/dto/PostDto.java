package com.corinto.dto;

public class PostDto {

	private Long id;
    private String conteudo;
    private String titlo;
    private String nomeDoUsuario;
    
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getConteudo() {
		return conteudo;
	}
	public void setConteudo(String conteudo) {
		this.conteudo = conteudo;
	}
	public String getTitlo() {
		return titlo;
	}
	public void setTitlo(String titlo) {
		this.titlo = titlo;
	}
	public String getNomeDoUsuario() {
		return nomeDoUsuario;
	}
	public void setNomeDoUsuario(String nomeDoUsuario) {
		this.nomeDoUsuario = nomeDoUsuario;
	}
    
    
	
}
