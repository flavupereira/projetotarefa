package com.flavio.microservice.usuario.DTO;

import java.time.LocalDateTime;
import java.util.Set;

import com.flavio.microservice.usuario.model.Usuario;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class UsuarioForm {

	@NotBlank(message = "O nome é obrigatório")
    @Size(min = 5, message = "O nome deve ter pelo menos 5 caracteres")
	private String nome;
	
	@NotBlank(message = "O email é obrigatório") 
    @Size(min = 8, message = "O email deve ter pelo menos 8 caracteres")
	private String email;
	
	@NotNull(message = "O campo ativo não pode ser nulo")
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
