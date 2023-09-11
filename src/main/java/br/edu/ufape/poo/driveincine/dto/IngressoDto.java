package br.edu.ufape.poo.driveincine.dto;

import java.util.List;

public class IngressoDto {
	private int[] vagas;
	private int sessao;
	
	public int[] getVagas() {
		return vagas;
	}
	public void setVagas(int[] vagas) {
		this.vagas = vagas;
	}
	public int getSessao() {
		return sessao;
	}
	public void setSessao(int sessao) {
		this.sessao = sessao;
	}
}