package dao;

import java.util.List;

import entity.Vagao;

/**
 * 
 * @author Agnes Travalon, Ana Carolina Lopes, Giovanna Capel e Pedro de Souza Moraes
 *
 * Interface para abstrair o acesso aos dados dos vag�es, encapsulando os mesmos
 */
public interface IVagaoDAO {

    //Salva o vag�o instanciado
    int save(Vagao vagao);

    //Atualiza o vag�o instanciado
    int update(Vagao vagao);

    //Remove o vag�o
    int remove(Long id);

    //Acha todos os vag�es inseridos na lista
    List<Vagao> findAll();
}