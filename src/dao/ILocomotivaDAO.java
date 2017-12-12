package dao;

import java.util.List;

import entity.Locomotiva;

/**
 * 
 * @author Agnes Travalon, Ana Carolina Lopes, Giovanna Capel e Pedro de Souza Moraes
 *
 * Interface para abstrair o acesso aos dados das locomotivas, encapsulando os
 * mesmos
 */
public interface ILocomotivaDAO {

    //Salva a locomotiva instanciada
    int save(Locomotiva locomotiva);

    //Atualiza a locomotiva instanciada
    int update(Locomotiva locomotiva);

    //Remove a locomotiva
    int remove(Long id);

    //Acha todas as locomotivas inseridas na lista
    List<Locomotiva> findAll();
}
