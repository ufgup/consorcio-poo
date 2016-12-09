package br.ufg.si.poo.consorcios.modelo;

public class Contemplacao {

	private Consorciado contemplado;
	private Double mensalidade;
	private Double totalContemplacao;

	/**
	 * @return the contemplado
	 */
	public Consorciado getContemplado() {
		return contemplado;
	}
	/**
	 * @param contemplado the contemplado to set
	 */
	public void setContemplado(Consorciado contemplado) {
		this.contemplado = contemplado;
	}
	/**
	 * @return the mensalidade
	 */
	public Double getMensalidade() {
		return mensalidade;
	}
	/**
	 * @param mensalidade the mensalidade to set
	 */
	public void setMensalidade(Double mensalidade) {
		this.mensalidade = mensalidade;
	}
	/**
	 * @return the totalContemplacao
	 */
	public Double getTotalContemplacao() {
		return totalContemplacao;
	}
	/**
	 * @param totalContemplacao the totalContemplacao to set
	 */
	public void setTotalContemplacao(Double totalContemplacao) {
		this.totalContemplacao = totalContemplacao;
	}

}
