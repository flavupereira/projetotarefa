package com.flavio.microservice.tarefa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.flavio.microservice.tarefa.DTO.TarefaForm;
import com.flavio.microservice.tarefa.model.Tarefa;
@Repository
public interface TarefaRepository extends JpaRepository<Tarefa, Long>{

	
}
