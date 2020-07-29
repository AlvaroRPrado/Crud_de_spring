package com.suscesso.crud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.suscesso.crud.model.Aluno;
import com.suscesso.crud.service.AlunoService;

@Controller
public class AlunosController {

	@Autowired
	private AlunoService alunoService;

	@GetMapping("/")
	public String homeAluno(Model model) {
		model.addAttribute("listAlunos", alunoService.geAllAluno());
		return "index";
	}

	@GetMapping("/novoAluno")
	public String NovoAluno(Model model) {

		Aluno aluno = new Aluno();
		model.addAttribute("aluno", aluno);
		return "CadastrarAluno";

	}

	// @RequestMapping(value = "/", method = RequestMethod.POST)
	@PostMapping("/salvarAluno")
	public String salvarAluno(@ModelAttribute("aluno") Aluno aluno) {
		alunoService.salvarAluno(aluno);
		return  "redirect:/";
	}

	@GetMapping("/alterarAluno/{id}")
	public String alterarAluno(@PathVariable(value = "id") long id, Model model) {

		Aluno aluno = alunoService.getAlunoById(id);

		model.addAttribute("aluno", aluno);
		return "AlterarCadastro";
	}

	@GetMapping("/deletarAluno/{id}")
	public String deletarAluno(@PathVariable(value = "id") long id) {
		this.alunoService.deletarAlunoById(id);
		return "redirect:/";
	}

}
