package entity;

import java.util.ArrayList;

public class Composicao {
	private String codigo, descricao, comprimento, bitola, pesoMax;
	protected ArrayList<Locomotiva> locomotivasselecionadas = new ArrayList<Locomotiva>();
	protected ArrayList<Vagao> vagoesselecionados = new ArrayList<Vagao>();
	private static final int MAXLOCOMOTIVA  = 3;
	public Composicao(ArrayList locomotivasselecionadas, ArrayList vagoesselecionados) {
		this.locomotivasselecionadas = locomotivasselecionadas;
		this.vagoesselecionados = vagoesselecionados;
	}
	
	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getComprimento() {
		return comprimento;
	}

	public void setComprimento(String comprimento) {
		this.comprimento = comprimento;
	}

	public String getBitola() {
		return bitola;
	}

	public void setBitola(String bitola) {
		this.bitola = bitola;
	}

	public String getPesoMax() {
		return pesoMax;
	}

	public void setPesoMax(String pesoMax) {
		this.pesoMax = pesoMax;
	}

	public ArrayList<Locomotiva> getLocomotivasselecionadas() {
		return locomotivasselecionadas;
	}

	public void setLocomotivasselecionadas(ArrayList<Locomotiva> locomotivasselecionadas) {
		this.locomotivasselecionadas = locomotivasselecionadas;
	}

	public ArrayList<Vagao> getVagoesselecionados() {
		return vagoesselecionados;
	}

	public void setVagoesselecionados(ArrayList<Vagao> vagoesselecionados) {
		this.vagoesselecionados = vagoesselecionados;
	}

	public static int getMaxlocomotiva() {
		return MAXLOCOMOTIVA;
	}

	@Override
	public String toString() {
		return "Composicao [codigo=" + codigo + ", descricao=" + descricao + ", comprimento=" + comprimento
				+ ", bitola=" + bitola + ", pesoMax=" + pesoMax + ", locomotivascomposicao=" + locomotivasselecionadas
				+ ", vagoescomposicao=" + vagoesselecionados + "]";
	}
	
	
}