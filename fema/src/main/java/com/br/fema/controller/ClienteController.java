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

import com.br.fema.model.Cliente;
import com.br.fema.service.ClienteService;

@RestController
@RequestMapping(value = "/cliente")
public class ClienteController {

	@Autowired private ClienteService clienteService;
	
	@CrossOrigin
	@GetMapping("/listar")
	public List<Cliente> listarCliente() {
		return clienteService.listarCliente();
	}
	
	@CrossOrigin
	@GetMapping("/id")
	public Cliente buscarClientePorId(@RequestParam(name = "id") Integer id) {
		return clienteService.buscarClientePorId(id);
	}
	
	@CrossOrigin
	@GetMapping("/nome")
	public List<Cliente> buscarClientesPorNome(@RequestParam(name = "nome") String nome) {
		return clienteService.buscarClientesPorNome(nome);
	}
	
	@CrossOrigin
	@PostMapping("/salvar")
	public Cliente salvarCliente(@RequestBody Cliente cliente) {
		return clienteService.salvarCliente(cliente);
	}
	
	@CrossOrigin
	@DeleteMapping("/delete")
	public ResponseEntity<?> deleteCliente(@RequestParam(name = "id") Integer id) {
		return clienteService.deleteClientePorId(id);
	}
	
}
