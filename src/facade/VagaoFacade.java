package facade;

import java.util.List;

import dao.IVagaoDAO;
import dao.VagaoDAO;
import entity.Vagao;

/**
 * 
 * @author Agnes Travalon, Ana Carolina Lopes, Giovanna Capel e Pedro de Souza Moraes
 *
 * Classe com o padr�o de projeto Facade (fachada) implementado para vag�es
 */
public class VagaoFacade {

    private IVagaoDAO dao;

    //Construtor n�o parametrizado instancia VagaoDAO
    public VagaoFacade() {
        this.dao = new VagaoDAO();
    }

    //M�todo para salvar o vag�o instanciado
    public int save(Vagao vagao) {
        return dao.save(vagao);
    }

    //M�todo para atualizar o vag�o instanciado
    public int update(Vagao vagao) {
        return dao.update(vagao);
    }

    //M�todo para remover o vag�o 
    public int remove(Long id) {
        return dao.remove(id);
    }

    //M�todo para achar todos os vag�es dentro da lista
    public List<Vagao> findAll() {
        return dao.findAll();
    }
}