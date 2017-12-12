package entity;

import java.util.ArrayList;

/**
 *
 * @author Agnes Travalon, Ana Carolina Lopes, Giovanna Capel e Pedro de Souza
 * Moraes
 *
 * Classe para trabalhar com as composições
 */
public class Composicao {

    //Componentes da classe
    private String codigo, descricao, comprimento, bitola, pesoMax;
    protected ArrayList<Locomotiva> locomotivasselecionadas = new ArrayList<Locomotiva>();
    protected ArrayList<Vagao> vagoesselecionados = new ArrayList<Vagao>();
    private static final int MAXLOCOMOTIVA = 3;

    //Construtor parametrizado
    public Composicao(ArrayList locomotivasselecionadas, ArrayList vagoesselecionados) {
        this.locomotivasselecionadas = locomotivasselecionadas;
        this.vagoesselecionados = vagoesselecionados;
    }

    //Obtém código
    public String getCodigo() {
        return codigo;
    }
    
    //Insere código
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }
    
    //Obtém descrição
    public String getDescricao() {
        return descricao;
    }
    
    //Insere descrição
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    
    //Obtém comprimento
    public String getComprimento() {
        return comprimento;
    }
    
    //Insere comprimento
    public void setComprimento(String comprimento) {
        this.comprimento = comprimento;
    }
    
    //Obtém bitola
    public String getBitola() {
        return bitola;
    }
    
    //Insere bitola
    public void setBitola(String bitola) {
        this.bitola = bitola;
    }
    
    //Obtém peso maximo
    public String getPesoMax() {
        return pesoMax;
    }
    
    //Insere peso maximo
    public void setPesoMax(String pesoMax) {
        this.pesoMax = pesoMax;
    }
    
    //Obtém as locomotivas selecionadas de dentro do array
    public ArrayList<Locomotiva> getLocomotivasselecionadas() {
        return locomotivasselecionadas;
    }
    
    //Insere as locomotivas selecionadas de dentro do array
    public void setLocomotivasselecionadas(ArrayList<Locomotiva> locomotivasselecionadas) {
        this.locomotivasselecionadas = locomotivasselecionadas;
    }
    
    //Obtém os vagões selecionados de dentro do array
    public ArrayList<Vagao> getVagoesselecionados() {
        return vagoesselecionados;
    }
    
    //Insere os vagões selecionados de dentro do array
    public void setVagoesselecionados(ArrayList<Vagao> vagoesselecionados) {
        this.vagoesselecionados = vagoesselecionados;
    }
    
    //Obtém o peso maximo permitido na locomotiva
    public static int getMaxlocomotiva() {
        return MAXLOCOMOTIVA;
    }

}
