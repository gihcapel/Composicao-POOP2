package dao;

import java.util.List;

import entity.Vagao;

/**
 * 
 * @author Agnes Travalon, Ana Carolina Lopes, Giovanna Capel e Pedro de Souza Moraes
 *
 * Interface para abstrair o acesso aos dados dos vagões, encapsulando os mesmos
 */
public interface IVagaoDAO {

    //Salva o vagão instanciado
    int save(Vagao vagao);

    //Atualiza o vagão instanciado
    int update(Vagao vagao);

    //Remove o vagão
    int remove(Long id);

    //Acha todos os vagões inseridos na lista
    List<Vagao> findAll();
}