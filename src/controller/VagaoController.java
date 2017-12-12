package controller;

import java.util.List;

import entity.Vagao;
import facade.VagaoFacade;

/**
 * 
 * @author Agnes Travalon, Ana Carolina Lopes, Giovanna Capel e Pedro de Souza Moraes
 *
 * Classe com o padr�o de projeto MVC implementado para vag�es
 */
public class VagaoController {

    private VagaoFacade facade;

    //Construtor n�o parametrizado instancia VagaoFacade
    public VagaoController() {
        this.facade = new VagaoFacade();
    }

    //M�todo para adicionar o vag�o instanciado
    public int addVagao(Vagao vagao) {
        return facade.save(vagao);
    }

    //M�todo para alterar o vag�o instanciado
    public int alterarVagao(Vagao vagao) {
        return facade.update(vagao);
    }

    //M�todo para excluir o vag�o
    public int excluirVagao(Long id) {
        return facade.remove(id);
    }

    //M�todo para achar todos os vag�es dentro da lista
    public List<Vagao> findvagoes() {
        return facade.findAll();
    }
}