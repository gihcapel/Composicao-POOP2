package facade;

import java.util.List;

import dao.ILocomotivaDAO;
import dao.LocomotivaDAO;
import entity.Locomotiva;

/**
 * 
 * @author Agnes Travalon, Ana Carolina Lopes, Giovanna Capel e Pedro de Souza Moraes
 *
 * Classe com o padr�o de projeto Facade (fachada) implementado para locomotivas
 */
public class LocomotivaFacade {

    private ILocomotivaDAO dao;

    //Construtor n�o parametrizado instancia LocomotivaDAO
    public LocomotivaFacade() {
        this.dao = new LocomotivaDAO();
    }

    //M�todo para salvar a locomotiva instanciada
    public int save(Locomotiva locomotiva) {
        return dao.save(locomotiva);
    }

    //M�todo para atualizar a locomotiva instanciada
    public int update(Locomotiva locomotiva) {
        return dao.update(locomotiva);
    }

    //M�todo para remover a locomotiva instanciada
    public int remove(Long id) {
        return dao.remove(id);
    }

    //M�todo para achar todas as locomotivas dentro da lista
    public List<Locomotiva> findAll() {
        return dao.findAll();
    }
}