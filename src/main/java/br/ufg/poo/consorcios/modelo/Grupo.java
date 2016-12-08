package br.ufg.poo.consorcios.modelo;

import java.util.List;

/**
 * Classe de modelo que representa a entidade Grupo
 *
 */
public class Grupo {

	private Consorciado responsavel;
	private Double mensalidadeInicial;
	private Double incrementoMensal;
	private Integer diaPagamentoMensalidade;
	private Integer diaPagamentoContemplacao;
	private List<Consorciado> participantes;

	/**
	 * @return the responsavel
	 */
	public Consorciado getResponsavel() {
		return responsavel;
	}
	/**
	 * @param responsavel the responsavel to set
	 */
	public void setResponsavel(Consorciado responsavel) {
		this.responsavel = responsavel;
	}
	/**
	 * @return the mensalidadeInicial
	 */
	public Double getMensalidadeInicial() {
		return mensalidadeInicial;
	}
	/**
	 * @param mensalidadeInicial the mensalidadeInicial to set
	 */
	public void setMensalidadeInicial(Double mensalidadeInicial) {
		this.mensalidadeInicial = mensalidadeInicial;
	}
	/**
	 * @return the incrementoMensal
	 */
	public Double getIncrementoMensal() {
		return incrementoMensal;
	}
	/**
	 * @param incrementoMensal the incrementoMensal to set
	 */
	public void setIncrementoMensal(Double incrementoMensal) {
		this.incrementoMensal = incrementoMensal;
	}
	/**
	 * @return the diaPagamentoMensalidade
	 */
	public Integer getDiaPagamentoMensalidade() {
		return diaPagamentoMensalidade;
	}
	/**
	 * @param diaPagamentoMensalidade the diaPagamentoMensalidade to set
	 */
	public void setDiaPagamentoMensalidade(Integer diaPagamentoMensalidade) {
		this.diaPagamentoMensalidade = diaPagamentoMensalidade;
	}
	/**
	 * @return the diaPagamentoContemplacao
	 */
	public Integer getDiaPagamentoContemplacao() {
		return diaPagamentoContemplacao;
	}
	/**
	 * @param diaPagamentoContemplacao the diaPagamentoContemplacao to set
	 */
	public void setDiaPagamentoContemplacao(Integer diaPagamentoContemplacao) {
		this.diaPagamentoContemplacao = diaPagamentoContemplacao;
	}
	/**
	 * @return the participantes
	 */
	public List<Consorciado> getParticipantes() {
		return participantes;
	}
	/**
	 * @param participantes the participantes to set
	 */
	public void setParticipantes(List<Consorciado> participantes) {
		this.participantes = participantes;
	}

}
