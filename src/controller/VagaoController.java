package controller;

import java.util.List;

import entity.Vagao;
import facade.VagaoFacade;

/**
 * 
 * @author Agnes Travalon, Ana Carolina Lopes, Giovanna Capel e Pedro de Souza Moraes
 *
 * Classe com o padrão de projeto MVC implementado para vagões
 */
public class VagaoController {

    private VagaoFacade facade;

    //Construtor não parametrizado instancia VagaoFacade
    public VagaoController() {
        this.facade = new VagaoFacade();
    }

    //Método para adicionar o vagão instanciado
    public int addVagao(Vagao vagao) {
        return facade.save(vagao);
    }

    //Método para alterar o vagão instanciado
    public int alterarVagao(Vagao vagao) {
        return facade.update(vagao);
    }

    //Método para excluir o vagão
    public int excluirVagao(Long id) {
        return facade.remove(id);
    }

    //Método para achar todos os vagões dentro da lista
    public List<Vagao> findvagoes() {
        return facade.findAll();
    }
}
