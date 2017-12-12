package dao;

import java.util.ArrayList;

import entity.Vagao;

/**
 *
 * @author Agnes Travalon, Ana Carolina Lopes, Giovanna Capel e Pedro de Souza
 * Moraes
 *
 * Classe para trabalhar a lista de arrays de vagões
 */
public final class ArrayListVagao {

    //Componentes da classe
    static ArrayList<Vagao> vagoesdisponiveis;
    private static ArrayListVagao instance = null;

    private ArrayListVagao(ArrayList<Vagao> vagoes) {
    }

    //Método que obtém a instância e verifica se é nula
    //Se for nula, instancia um ArrayListVagao
    public static ArrayListVagao getInstance() {
        if (instance == null) {

            instance = new ArrayListVagao(vagoesdisponiveis);
        }
        return instance;
    }

    //Obtém os vagões disponíveis
    public static ArrayList<Vagao> getVagoesdisponiveis() {
        return vagoesdisponiveis;
    }

    //Insere os vagões disponíveis
    public static void setVagoesdisponiveis(ArrayList<Vagao> vagoesdisponiveis) {
        ArrayListVagao.vagoesdisponiveis = vagoesdisponiveis;
    }

    //Insere a instância
    public static void setInstance(ArrayListVagao instance) {
        ArrayListVagao.instance = instance;
    }

    //Método que adiciona um novo vagão nos disponíveis
    public void add(Vagao vagao) {
        vagoesdisponiveis.add(vagao);

    }

}
