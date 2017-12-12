package dao;

import java.util.ArrayList;

import entity.Locomotiva;

/**
 *
 * @author Agnes Travalon, Ana Carolina Lopes, Giovanna Capel e Pedro de Souza
 * Moraes
 *
 * Classe para trabalhar a lista de arrays de locomotivas
 */
public final class ArrayListLocomotiva {
    //Componentes da classe

    static ArrayList<Locomotiva> locomotivasdisponiveis;
    private static ArrayListLocomotiva instance = null;

    private ArrayListLocomotiva(ArrayList<Locomotiva> locomotivas) {
    }

    //Método que obtém a instância e verifica se é nula
    //Se for nula, instancia um ArrayListLocomotiva
    public static ArrayListLocomotiva getInstance() {
        if (instance == null) {

            instance = new ArrayListLocomotiva(locomotivasdisponiveis);
        }
        return instance;
    }

    //Obtém as locomotivas disponíveis
    public static ArrayList<Locomotiva> getLocomotivasdisponiveis() {
        return locomotivasdisponiveis;
    }

    //Insere as locomotivas disponíveis
    public static void setLocomotivasdisponiveis(ArrayList<Locomotiva> locomotivasdisponiveis) {
        ArrayListLocomotiva.locomotivasdisponiveis = locomotivasdisponiveis;
    }

    //Insere a instância
    public static void setInstance(ArrayListLocomotiva instance) {
        ArrayListLocomotiva.instance = instance;
    }

    //Método que adiciona uma nova locomotiva nas disponíveis
    public void add(Locomotiva locomotiva) {
        locomotivasdisponiveis.add(locomotiva);

    }

}
