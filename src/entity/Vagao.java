package entity;
/**
 * 
 * @author Agnes Travalon, Ana Carolina Lopes, Giovanna Capel e Pedro de Souza Moraes
 *
 * Classe para trabalhar com vagões
 */
public class Vagao {
	//Componentes da classe vagão
	String tipo, subtipo, bitola, proprietario;
	private Long id;
	//Obtém Id
	public Long getId() {
		return id;
	}
	//Insere Id
	public void setId(Long id) {
		this.id = id;
	}
	private String pesoMax;
	String comprimento;
	String bitolaMetro;
	//Método que lista todos os tipos de vagões que podem existir
	public enum ListaTipos {
		G, P, T, F, I, H, A, C;
	} 

	//Insere o subtipo
	public void setSubtipo(String subtipo) {
		this.subtipo=subtipo;
	}

	//Obtém o tipo
	public String getTipo() {
		return tipo;
	}
	//Insere o tipo
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	//Obtém a bitola
	public String getBitola() {
		return bitola;
	}
	//Insere a bitola
	public void setBitola(String bitola) {
		this.bitola = bitola;
	}
	//Obtém peso máximo
	public String getPesoMax() {
		return pesoMax;
	}
	//Insere peso máximo
	public void setPesoMax(String pesoMax) {
		this.pesoMax = pesoMax;
	}
	//Obtém tamanho da bitola
	public String getBitolaMetro() {
		return bitolaMetro;
	}
	//Insere tamanho da bitola
	public void setBitolaMetro(String bitolaMetro) {
		this.bitolaMetro = bitolaMetro;
	}
	//Obtém comprimento
	public String getComprimento() {
		return comprimento;
	}
	//Insere comprimento
	public void setComprimento(String comprimento) {
		this.comprimento = comprimento;
	}

	//Obtém subtipo
	public String getSubtipo() {
		return subtipo;
	}

	//Construtor vazio e não parametrizado
	public Vagao() {
	}
	//Obtém proprietário
	public String getProprietario() {
		return proprietario;
	}
	//Insere proprietário
	public void setProprietario(String proprietario) {
		this.proprietario = proprietario;
	}
	@Override
	//Imprime componentes da classe
	public String toString() {
		return "Vagao [tipo=" + tipo + ", subtipo=" + subtipo + ", bitola=" + bitola + ", proprietario="
				+ proprietario + ", id=" + id + ", pesoMax=" + pesoMax + ", bitolaMetro=" + bitolaMetro
				+ ", comprimento=" + comprimento + "]";
	}



}
