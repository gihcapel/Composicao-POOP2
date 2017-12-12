package facade;

import java.util.List;

import dao.IVagaoDAO;
import dao.VagaoDAO;
import entity.Vagao;

/**
 * 
 * @author Agnes Travalon, Ana Carolina Lopes, Giovanna Capel e Pedro de Souza Moraes
 *
 * Classe com o padrão de projeto Facade (fachada) implementado para vagões
 */
public class VagaoFacade {

    private IVagaoDAO dao;

    //Construtor não parametrizado instancia VagaoDAO
    public VagaoFacade() {
        this.dao = new VagaoDAO();
    }

    //Método para salvar o vagão instanciado
    public int save(Vagao vagao) {
        return dao.save(vagao);
    }

    //Método para atualizar o vagão instanciado
    public int update(Vagao vagao) {
        return dao.update(vagao);
    }

    //Método para remover o vagão 
    public int remove(Long id) {
        return dao.remove(id);
    }

    //Método para achar todos os vagões dentro da lista
    public List<Vagao> findAll() {
        return dao.findAll();
    }
}