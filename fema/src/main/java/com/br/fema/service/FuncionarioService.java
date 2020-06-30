package com.br.fema.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.br.fema.model.Funcionario;
import com.br.fema.repository.FuncionarioRepository;

@Service
public class FuncionarioService {

	@Autowired private FuncionarioRepository funcionarioRepository;
	
	public List<Funcionario> listarFuncionario(){
		return funcionarioRepository.findAll();
	}
	
	public Funcionario buscarFuncionarioPorId(Integer id) {
		return funcionarioRepository.findById(id).orElse(null);
	}
	
	public List<Funcionario> buscarFuncionariosPorNome(String nome) {
		return funcionarioRepository.findByNomeContains(nome);
	}

	public Funcionario salvarFuncionario(Funcionario funcionario) {
		return funcionarioRepository.save(funcionario);
	}

	public ResponseEntity<?> deleteFuncionarioePorId(Integer id) {
		try {
			funcionarioRepository.deleteById(id);
			return ResponseEntity.ok().build();
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.badRequest().build();
		}
		
	}
	
	
}
