package com.flavio.microservice.DTO;

import java.time.LocalDateTime;
import java.util.Set;

import com.flavio.microservice.usuario.model.Usuario;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class UsuarioForm {

	@NotBlank @Size(min = 5)
	private String nome;
	@NotBlank @Size(min = 8)
	private String email;
	@NotBlank @Size(min = 5)
	private Boolean ativo;
	

	

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

	

	public Boolean getAtivo() {
		return ativo;
	}

	public void setAtivo(Boolean ativo) {
		this.ativo = ativo;
	}

	
	public Usuario converte() {
		
		return new Usuario(nome,email,ativo);
	}

}
