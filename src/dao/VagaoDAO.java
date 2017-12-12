package dao;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import entity.Vagao;
/**
* 
* @author Agnes Travalon, Ana Carolina Lopes, Giovanna Capel e Pedro de Souza Moraes
*
* Classe para pegar todas as informações sobre os vagões do banco de dados,
* implementando a interface IVagaoDAO
*/
public class VagaoDAO implements IVagaoDAO {

    private static final String SQL_INSERT =
            "insert into vagoestable (tipo, subtipo, bitola, proprietario, bitolametro, comprimento, pesomax) values (?,?,?,?,?,?,?)";

    private static final String SQL_UPDATE =
            "update vagoestable set tipo = ?, subtipo = ?, bitola = ?, proprietario=?, bitolametro=?, comprimento=?, pesomax=? where id = ?";

    private static final String SQL_REMOVE =
            "delete from vagoestable where ID = ?";

    private static final String SQL_FIND_ALL =
            "select * from vagoestable";
    /**Método para salvar o vagão instanciado
     * com conexão do banco de dados e tratamento de exceções
     */
public int save(Vagao vagao) {
    	
    	ArrayListVagao vagoesdisponiveis;
    	vagoesdisponiveis= ArrayListVagao.getInstance();
        Connection conn = Connect.getConnection();
        PreparedStatement pstm = null;
        int result = 0;
        try {
            pstm = conn.prepareStatement(SQL_INSERT);
            pstm.setString(1, vagao.getTipo());
            pstm.setString(2, vagao.getSubtipo());
            pstm.setString(3, vagao.getBitola());
            pstm.setString(4, vagao.getProprietario());
            pstm.setString(5, vagao.getBitolaMetro());
            pstm.setString(6, vagao.getComprimento());
            pstm.setString(7, vagao.getPesoMax());
            result = pstm.executeUpdate();
            vagoesdisponiveis.add(vagao);
            
        } catch (SQLException e) {
            try {
                if (conn != null) {
                    conn.rollback();
                }
            } catch (SQLException e1) {
                e1.printStackTrace();
            }  finally {
                Connect.close(conn, pstm, null);
            }
            e.printStackTrace();
        }
        return result;
    }
/**Método para atualizar o vagão instanciado
 * com conexão do banco de dados e tratamento de exceções
 */
    public int update(Vagao vagao) {
        Connection conn =  Connect.getConnection();
        PreparedStatement pstm = null;
        int result = 0;
        try {
            pstm = conn.prepareStatement(SQL_UPDATE);
            pstm.setString(1, vagao.getTipo());
            pstm.setString(2, vagao.getSubtipo());
            pstm.setString(3, vagao.getBitola());
            pstm.setString(4, vagao.getProprietario());
            pstm.setString(5, vagao.getBitolaMetro());
            pstm.setString(6, vagao.getComprimento());
            pstm.setString(7, vagao.getPesoMax());
            pstm.setLong(8, vagao.getId());
            result = pstm.executeUpdate();
        } catch (SQLException e) {
            try {
                if (conn != null) {
                    conn.rollback();
                }
            } catch (SQLException e1) {
                e1.printStackTrace();
            }  finally {
                Connect.close(conn, pstm, null);
            }
            e.printStackTrace();
        }
        return result;
    }
    /**Método para remover o vagão instanciado
     * com conexão do banco de dados e tratamento de exceções
     */
    public int remove(Long id) {
        Connection conn =  Connect.getConnection();
        PreparedStatement pstm = null;
        int result = 0;
        try {
            pstm = conn.prepareStatement(SQL_REMOVE);
            pstm.setLong(1, id);
            result = pstm.executeUpdate();
        } catch (SQLException e) {
            try {
                if (conn != null) {
                    conn.rollback();
                }
            } catch (SQLException e1) {
                e1.printStackTrace();
            }  finally {
                Connect.close(conn, pstm, null);
            }
            e.printStackTrace();
        }
        return result;
    }
    /**Método para achar todos os vagoes dentro da lista
     * utilizando um array, com conexão de banco de dados e tratamento de exceções
     */
    public List<Vagao> findAll() {
        Connection conn = Connect.getConnection();
        PreparedStatement pstm = null;
        List<Vagao> vagoes = new ArrayList<Vagao>();
        ResultSet rs = null;
        try {
            pstm = conn.prepareStatement(SQL_FIND_ALL);
            rs = pstm.executeQuery();
            while (rs.next()) {
                Vagao vagao = new Vagao();
                vagao.setId(rs.getLong("id"));
                vagao.setTipo(rs.getString("tipo"));
                vagao.setSubtipo(rs.getString("subtipo"));
                vagao.setBitola(rs.getString("bitola"));
                vagao.setBitolaMetro(rs.getString("bitolametro"));
                vagao.setComprimento(rs.getString("comprimento"));
                vagao.setProprietario(rs.getString("proprietario"));
                vagoes.add(vagao);
            }
        } catch (SQLException e) {
            try {
                if (conn != null) {
                    conn.rollback();
                }
            } catch (SQLException e1) {
                e1.printStackTrace();
            }  finally {
                Connect.close(conn, pstm, rs);
            }
            e.printStackTrace();
        }
      
        return vagoes;
        
    }
}

