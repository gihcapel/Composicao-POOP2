package dao;

import java.util.List;

import entity.Vagao;


public interface IVagaoDAO {

    int save(Vagao vagao);

    int update(Vagao vagao);

    int remove(Long id);

    List<Vagao> findAll();
}
