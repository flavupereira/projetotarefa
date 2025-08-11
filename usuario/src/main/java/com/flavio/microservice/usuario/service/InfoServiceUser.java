package com.flavio.microservice.usuario.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.flavio.microservice.usuario.model.Usuario;
import com.flavio.microservice.usuario.repository.UsuarioRepository;

@Service
public class InfoServiceUser {
	
    @Autowired
	private UsuarioRepository usuarioRepository;
	
	public Optional<Usuario> getUserId(Long id){
		
		return usuarioRepository.findById(id);
		
	}

}
