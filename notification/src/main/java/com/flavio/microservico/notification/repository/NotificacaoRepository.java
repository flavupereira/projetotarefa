package com.flavio.microservico.notification.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.flavio.microservico.notification.model.Notaficacao;

public interface NotificacaoRepository extends JpaRepository<Notaficacao, Long>{

}
