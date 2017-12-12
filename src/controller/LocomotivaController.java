package controller;

import java.util.List;

import entity.Locomotiva;
import facade.LocomotivaFacade;

/**
 * 
 * @author Agnes Travalon, Ana Carolina Lopes, Giovanna Capel e Pedro de Souza Moraes
 *
 * Classe com o padrão de projeto MVC implementado para locomotivas
 */
public class LocomotivaController {

    private LocomotivaFacade facade;

    //Construtor não parametrizado instancia LocomotivaFacade
    public LocomotivaController() {
        this.facade = new LocomotivaFacade();
    }

    //Método para adicionar a locomotiva instanciada
    public int addLocomotiva(Locomotiva locomotiva) {
        return facade.save(locomotiva);
    }

    //Método para alterar a locomotiva instanciada
    public int alterarLocomotiva(Locomotiva locomotiva) {
        return facade.update(locomotiva);
    }

    //Método para excluir a locomotiva
    public int excluirLocomotiva(Long id) {
        return facade.remove(id);
    }

    //Método para achar todas as locomotivas dentro da lista
    public List<Locomotiva> findlocomotivas() {
        return facade.findAll();
    }
}
