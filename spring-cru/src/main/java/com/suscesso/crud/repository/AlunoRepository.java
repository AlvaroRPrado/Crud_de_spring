package com.suscesso.crud.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.suscesso.crud.model.Aluno;

@Repository
public interface AlunoRepository extends JpaRepository<Aluno,  Long> {

} 
