package com.br.fema.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.br.fema.model.Agenda;
import com.br.fema.model.dto.AgendaDTO;
import com.br.fema.service.AgendaService;

@RestController
@RequestMapping(value = "/agenda")
public class AgendaController {

	@Autowired private AgendaService agendaService;
	
	@CrossOrigin
	@GetMapping("/listar")
	public List<AgendaDTO> listarAgenda() {
		return agendaService.listarAgenda();
	}
	
	@CrossOrigin
	@PostMapping("/salvar")
	public Agenda salvarAgenda(@RequestBody Agenda agenda) {
		return agendaService.salvarAgenda(agenda);
	}
	
}
