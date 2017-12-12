package entity;
/**
 * 
 * @author Agnes Travalon, Ana Carolina Lopes, Giovanna Capel e Pedro de Souza Moraes
 *
 * Classe para trabalhar com vag�es
 */
public class Vagao {
	//Componentes da classe vag�o
	String tipo, subtipo, bitola, proprietario;
	private Long id;
	//Obt�m Id
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
	//M�todo que lista todos os tipos de vag�es que podem existir
	public enum ListaTipos {
		G, P, T, F, I, H, A, C;
	} 

	//Insere o subtipo
	public void setSubtipo(String subtipo) {
		this.subtipo=subtipo;
	}

	//Obt�m o tipo
	public String getTipo() {
		return tipo;
	}
	//Insere o tipo
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	//Obt�m a bitola
	public String getBitola() {
		return bitola;
	}
	//Insere a bitola
	public void setBitola(String bitola) {
		this.bitola = bitola;
	}
	//Obt�m peso m�ximo
	public String getPesoMax() {
		return pesoMax;
	}
	//Insere peso m�ximo
	public void setPesoMax(String pesoMax) {
		this.pesoMax = pesoMax;
	}
	//Obt�m tamanho da bitola
	public String getBitolaMetro() {
		return bitolaMetro;
	}
	//Insere tamanho da bitola
	public void setBitolaMetro(String bitolaMetro) {
		this.bitolaMetro = bitolaMetro;
	}
	//Obt�m comprimento
	public String getComprimento() {
		return comprimento;
	}
	//Insere comprimento
	public void setComprimento(String comprimento) {
		this.comprimento = comprimento;
	}

	//Obt�m subtipo
	public String getSubtipo() {
		return subtipo;
	}

	//Construtor vazio e n�o parametrizado
	public Vagao() {
	}
	//Obt�m propriet�rio
	public String getProprietario() {
		return proprietario;
	}
	//Insere propriet�rio
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
