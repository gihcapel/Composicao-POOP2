package controller;

import java.util.List;

import entity.Vagao;
import facade.VagaoFacade;


public class VagaoController {

    private VagaoFacade facade;

    public VagaoController() {
        this.facade = new VagaoFacade();
    }

    public int addVagao(Vagao vagao) {
        return facade.save(vagao);
    }

    public int alterarVagao(Vagao vagao) {
        return facade.update(vagao);
    }

    public int excluirVagao(Long id) {
        return facade.remove(id);
    }

    public List<Vagao> findvagoes() {
        return facade.findAll();
    }
}
