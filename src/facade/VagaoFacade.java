package facade;



import java.util.List;

import dao.IVagaoDAO;
import dao.VagaoDAO;
import entity.Vagao;

/**
 * Created by IntelliJ IDEA.
 * User: Marcio Ballem
 * Date: 31/03/13
 * Time: 01:41
 * http://www.mballem.com/
 */
public class VagaoFacade {

    private IVagaoDAO dao;

    public VagaoFacade() {
        this.dao = new VagaoDAO();
    }

    public int save(Vagao vagao) {
        return dao.save(vagao);
    }

    public int update(Vagao vagao) {
        return dao.update(vagao);
    }

    public int remove(Long id) {
        return dao.remove(id);
    }

    public List<Vagao> findAll() {
        return dao.findAll();
    }
}
