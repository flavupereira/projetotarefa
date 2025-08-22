package com.flavio.microservice.usuario.DTO;

import com.flavio.microservice.usuario.model.Usuario;
import com.flavio.microservice.usuario.repository.UsuarioRepository;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;



public class AtualizacaoUsuarioForm {

	@NotBlank
	@Size(min = 5)
	private String nome;
	@NotBlank
	@Size(min = 8)
	private String email;

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

	public Usuario atualizar(Long id, UsuarioRepository usuarioRepository) {
		Usuario usuario = usuarioRepository.findById(id)
				.orElseThrow(()-> new RuntimeException("Usuário não encontrado"));
		usuario.setNome(this.nome);
		usuario.setEmail(this.email);
		return usuario;
		
		
	}

}
