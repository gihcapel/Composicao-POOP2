package facade;



import java.util.List;

import dao.ILocomotivaDAO;
import dao.LocomotivaDAO;
import entity.Locomotiva;


public class LocomotivaFacade {

    private ILocomotivaDAO dao;

    public LocomotivaFacade() {
        this.dao = new LocomotivaDAO();
    }

    public int save(Locomotiva locomotiva) {
        return dao.save(locomotiva);
    }

    public int update(Locomotiva locomotiva) {
        return dao.update(locomotiva);
    }

    public int remove(Long id) {
        return dao.remove(id);
    }

    public List<Locomotiva> findAll() {
        return dao.findAll();
    }
}
