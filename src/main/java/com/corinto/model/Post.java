package com.corinto.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import java.time.Instant;

@Entity
@Table
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    @Column
    private String titlo;
    @Lob
    @Column
    @NotEmpty
    private String conteudo;
    @Column
    private Instant criadoEm;
    @Column
    private Instant atualizadoEm;
    @Column
    @NotBlank
    private String nomeDoUsuario;
    
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTitlo() {
		return titlo;
	}
	public void setTitlo(String titlo) {
		this.titlo = titlo;
	}
	public String getConteudo() {
		return conteudo;
	}
	public void setConteudo(String conteudo) {
		this.conteudo = conteudo;
	}
	public Instant getCriadoEm() {
		return criadoEm;
	}
	public void setCriadoEm(Instant criadoEm) {
		this.criadoEm = criadoEm;
	}
	public Instant getAtualizadoEm() {
		return atualizadoEm;
	}
	public void setAtualizadoEm(Instant atualizadoEm) {
		this.atualizadoEm = atualizadoEm;
	}
	public String getNomeDoUsuario() {
		return nomeDoUsuario;
	}
	public void setNomeDoUsuario(String nomeDoUsuario) {
		this.nomeDoUsuario = nomeDoUsuario;
	}

}
