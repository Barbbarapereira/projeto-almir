package com.br.fema.model.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class AgendaDTO {

	private String clienteNome;
	private String funcionarioNome;
	private String descricao;
	private LocalDateTime dataHora;
	private BigDecimal preco;
	
	public String getClienteNome() {
		return clienteNome;
	}
	public void setClienteNome(String clienteNome) {
		this.clienteNome = clienteNome;
	}
	public String getFuncionarioNome() {
		return funcionarioNome;
	}
	public void setFuncionarioNome(String funcionarioNome) {
		this.funcionarioNome = funcionarioNome;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public LocalDateTime getDataHora() {
		return dataHora;
	}
	public void setDataHora(LocalDateTime dataHora) {
		this.dataHora = dataHora;
	}
	public BigDecimal getPreco() {
		return preco;
	}
	public void setPreco(BigDecimal preco) {
		this.preco = preco;
	}
	
}
