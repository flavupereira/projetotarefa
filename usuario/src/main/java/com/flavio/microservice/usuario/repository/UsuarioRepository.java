package com.flavio.microservice.usuario.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.flavio.microservice.usuario.model.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

	Page<Usuario> findByNome(String nomeUsuario , Pageable paginacao);

	

}
