package com.suscesso.crud.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.suscesso.crud.model.Aluno;
import com.suscesso.crud.repository.AlunoRepository;

@Service
public class AlunoServiceImpl implements AlunoService {

	@Autowired
	private AlunoRepository alunoRepository;

	@Override
	public List<Aluno> geAllAluno() {
		return alunoRepository.findAll();
	}

	@Override
	public void salvarAluno(Aluno aluno) {
		this.alunoRepository.save(aluno);

	}

	@Override
	public Aluno getAlunoById(long id) {
		Optional<Aluno> optional = alunoRepository.findById(id);
		Aluno aluno = null;
		if (optional.isPresent()) {
			aluno = optional.get();
		} else {
			throw new RuntimeException("Aluno não encontrado por id ::" + id);
		}
		return aluno;
	}

	@Override
	public void deletarAlunoById(long id) {
		this.alunoRepository.deleteById(id);
	}

}
