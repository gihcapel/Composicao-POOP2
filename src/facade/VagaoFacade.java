package facade;



import java.util.List;

import dao.IVagaoDAO;
import dao.VagaoDAO;
import entity.Vagao;

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
