package com.suscesso.crud.service;

import java.util.List;

import com.suscesso.crud.model.Aluno;

public interface AlunoService {
	
	List<Aluno> geAllAluno();
	
	void salvarAluno(Aluno aluno);
	
	Aluno getAlunoById(long id);
	 
	void deletarAlunoById(long id);
	}


