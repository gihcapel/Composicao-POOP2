package facade;

import java.util.List;

import dao.ILocomotivaDAO;
import dao.LocomotivaDAO;
import entity.Locomotiva;

/**
 * 
 * @author Agnes Travalon, Ana Carolina Lopes, Giovanna Capel e Pedro de Souza Moraes
 *
 * Classe com o padrão de projeto Facade (fachada) implementado para locomotivas
 */
public class LocomotivaFacade {

    private ILocomotivaDAO dao;

    //Construtor não parametrizado instancia LocomotivaDAO
    public LocomotivaFacade() {
        this.dao = new LocomotivaDAO();
    }

    //Método para salvar a locomotiva instanciada
    public int save(Locomotiva locomotiva) {
        return dao.save(locomotiva);
    }

    //Método para atualizar a locomotiva instanciada
    public int update(Locomotiva locomotiva) {
        return dao.update(locomotiva);
    }

    //Método para remover a locomotiva instanciada
    public int remove(Long id) {
        return dao.remove(id);
    }

    //Método para achar todas as locomotivas dentro da lista
    public List<Locomotiva> findAll() {
        return dao.findAll();
    }
}