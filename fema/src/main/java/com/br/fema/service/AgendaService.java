package com.br.fema.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.br.fema.model.Agenda;
import com.br.fema.model.Cliente;
import com.br.fema.model.Funcionario;
import com.br.fema.model.dto.AgendaDTO;
import com.br.fema.repository.AgendaRepository;

@Service
public class AgendaService {

	@Autowired private AgendaRepository agendaRepository;
	
	@Autowired private ClienteService clienteService;
	
	@Autowired private FuncionarioService funcionarioService;
	
	public List<AgendaDTO> listarAgenda(){
		List<Agenda> listaAgenda = agendaRepository.findAll();
		List<AgendaDTO> listaAgendaDTO = new ArrayList<>();
		
		
		for(Agenda agenda: listaAgenda) {
			AgendaDTO agendaDTO = new AgendaDTO();
			System.out.println("Agenda descricao: " + agenda.getDescricao());
			
			Cliente cliente = clienteService.buscarClientePorId(agenda.getClienteId());
			
			Funcionario funcionario = funcionarioService.buscarFuncionarioPorId(agenda.getClienteId());
			
			agendaDTO.setClienteNome(cliente.getNome());
			agendaDTO.setFuncionarioNome(funcionario.getNome());
			agendaDTO.setDataHora(agenda.getDataHora());
			agendaDTO.setDescricao(agenda.getDescricao());
			agendaDTO.setPreco(agenda.getPreco());
			
			listaAgendaDTO.add(agendaDTO);
		}
		
		return listaAgendaDTO;
	}

	public Agenda salvarAgenda(Agenda agenda) {
		
		Cliente cliente = clienteService.buscarClientePorId(agenda.getClienteId());
		Funcionario funcionario = funcionarioService.buscarFuncionarioPorId(agenda.getClienteId());
		
		if(cliente == null) {
			System.out.println("Deu erro ao buscar o cliente");
			return null;
		}

		if(funcionario == null) {
			System.out.println("Deu erro ao buscar o funcionario");
			return null;
		}
		
		return agendaRepository.save(agenda);
	}
	
}
