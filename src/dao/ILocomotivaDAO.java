package dao;

import java.util.List;

import entity.Locomotiva;


public interface ILocomotivaDAO {

    int save(Locomotiva locomotiva);

    int update(Locomotiva locomotiva);

    int remove(Long id);

    List<Locomotiva> findAll();
}
