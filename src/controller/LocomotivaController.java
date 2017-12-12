package controller;

import java.util.List;

import entity.Locomotiva;
import facade.LocomotivaFacade;

/**
 * Created by IntelliJ IDEA.
 * User: Marcio Ballem
 * Date: 31/03/13
 * Time: 01:44
 * http://www.mballem.com/
 */
public class LocomotivaController {

    private LocomotivaFacade facade;

    public LocomotivaController() {
        this.facade = new LocomotivaFacade();
    }

    public int addLocomotiva(Locomotiva locomotiva) {
        return facade.save(locomotiva);
    }

    public int alterarLocomotiva(Locomotiva locomotiva) {
        return facade.update(locomotiva);
    }

    public int excluirLocomotiva(Long id) {
        return facade.remove(id);
    }

    public List<Locomotiva> findlocomotivas() {
        return facade.findAll();
    }
}
