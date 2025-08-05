package com.flavio.microservice.usuario.model;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "usuario")
public class Usuario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nome;
	private String email;
	private LocalDateTime dataCriacao = LocalDateTime.now();
	private Boolean ativo;

//	@ElementCollection(fetch = FetchType.EAGER)
//	private Set<String> roles = Set.of("USER");

	public Usuario() {

	}

	public Usuario(String nome, String email, Boolean ativo) {
       this.nome = nome;
       this.email = email;
       this.dataCriacao = dataCriacao;
       this.ativo = ativo;
      
	}

	public Long getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	

	public LocalDateTime getDataCriacao() {
		return dataCriacao;
	}

	public void setDataCriacao(LocalDateTime dataCriacao) {
		this.dataCriacao = dataCriacao;
	}

	public Boolean getAtivo() {
		return ativo;
	}

	public void setAtivo(Boolean ativo) {
		this.ativo = ativo;
	}

	

}
