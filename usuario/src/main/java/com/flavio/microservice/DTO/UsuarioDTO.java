package com.flavio.microservice.DTO;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.data.domain.Page;

import com.flavio.microservice.usuario.model.Usuario;

import jakarta.persistence.ElementCollection;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

public class UsuarioDTO {
	

	private Long id;
	private String nome;
	private String email;
	private LocalDateTime dataCriacao;
	private Boolean ativo;
	

	
	public UsuarioDTO() {
		
	}
	
	
	public UsuarioDTO(Usuario usuario) {
		this.id = usuario.getId() ;
		this.nome = usuario.getNome();
		this.email = usuario.getEmail();
		this.dataCriacao = usuario.getDataCriacao(); 
		this.ativo = usuario.getAtivo();
		
		
	}


	public Long getId() {
		return id;
	}


	public String getNome() {
		return nome;
	}


	public String getEmail() {
		return email;
	}





	public LocalDateTime getDataCriacao() {
		return dataCriacao;
	}


	public Boolean getAtivo() {
		return ativo;
	}


	public static Page<UsuarioDTO> converter(Page<Usuario> usuarios) {
		
		return usuarios.map(UsuarioDTO::new);
		
//		return usuarios.stream()
//				.map(UsuarioDTO :: new)
//				.collect(Collectors.toList());
	}


	
	
	

}
