package com.flavio.microservice.usuario.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.flavio.microservice.usuario.DTO.UsuarioDTO;
import com.flavio.microservice.usuario.model.Usuario;
import com.flavio.microservice.usuario.repository.UsuarioRepository;

@Service
public class InfoServiceUser {
	
	private final UsuarioRepository usuarioRepository;

    public InfoServiceUser(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }
	
    public UsuarioDTO getUserId(Long id) {
        Usuario usuario = usuarioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));

        return new UsuarioDTO(usuario); 
    }

}
