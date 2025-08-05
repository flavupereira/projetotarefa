//package com.flavio.microservice.usuario.service;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import com.flavio.microservice.DTO.UsuarioForm;
//import com.flavio.microservice.usuario.model.Usuario;
//import com.flavio.microservice.usuario.repository.UsuarioRepository;
//
//@Service
//public class UsuarioService {
//
//	@Autowired
//	UsuarioRepository usuariorepository;
//	
//	public  void addUsuario(UsuarioForm usuariodto) {
//		Usuario usuario = usuariodto.criaUsuarioDTO(new Usuario());
//		
//		usuariorepository.save(usuario);		
//	}
//
//}
