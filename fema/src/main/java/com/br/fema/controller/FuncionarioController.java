package com.br.fema.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.br.fema.model.Funcionario;
import com.br.fema.service.FuncionarioService;

@RestController
@RequestMapping(value = "funcionario")
public class FuncionarioController {
	
	@Autowired
	private FuncionarioService funcionarioService;
	
	@CrossOrigin
	@GetMapping("/listar")
	public List<Funcionario> listarFuncionario() {
		return funcionarioService.listarFuncionario();
	}
	
	@CrossOrigin
	@GetMapping("/id")
	public Funcionario buscarFuncionarioPorId(@RequestParam(name = "id") Integer id) {
		return funcionarioService.buscarFuncionarioPorId(id);
	}
	
	@CrossOrigin
	@GetMapping("/nome")
	public List<Funcionario> buscarFuncionariosPorNome(@RequestParam(name = "nome") String nome) {
		return funcionarioService.buscarFuncionariosPorNome(nome);
	}
	
	@CrossOrigin
	@PostMapping("/salvar")
	public Funcionario salvarFuncionario(@RequestBody Funcionario funcionario) {
		return funcionarioService.salvarFuncionario(funcionario);
	}
	
	@CrossOrigin
	@DeleteMapping("/delete")
	public ResponseEntity<?> deleteFuncionario(@RequestParam(name = "id") Integer id) {
		return funcionarioService.deleteFuncionarioePorId(id);
	}
	
}
