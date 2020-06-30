package com.br.fema.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.br.fema.model.Cliente;
import com.br.fema.repository.ClienteRepository;

@Service
public class ClienteService {

	@Autowired private ClienteRepository clienteRepository;
	
	public List<Cliente> listarCliente(){
		return clienteRepository.findAll();
	}
	
	public Cliente buscarClientePorId(Integer id) {
		return clienteRepository.findById(id).orElse(null);
	}
	
	public List<Cliente> buscarClientesPorNome(String nome) {
		return clienteRepository.findByNomeContains(nome);
	}

	public Cliente salvarCliente(Cliente cliente) {
		return clienteRepository.save(cliente);
	}

	public ResponseEntity<?> deleteClientePorId(Integer id) {
		try {
			clienteRepository.deleteById(id);
			return ResponseEntity.ok().build();
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.badRequest().build();
		}
		
	}
	
}
