package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entity.Locomotiva;

/**
 * 
 * @author Agnes Travalon, Ana Carolina Lopes, Giovanna Capel e Pedro de Souza Moraes
 *
 * Classe para pegar todas as informações sobre as locomotivas do banco de
 * dados, implementando a interface ILocomotivaDAO
 */
public class LocomotivaDAO implements ILocomotivaDAO {

    private static final String SQL_INSERT
            = "insert into locomotivas (classe, descricao, pesomaxreboc, pesomaxloc, bitola, comprimento) values (?,?,?,?,?,?)";

    private static final String SQL_UPDATE
            = "update locomotivas set classe = ?, descricao = ?, pesomaxreboc = ?, pesomaxloc =?, bitolaloc=?, comprimentoloc=? where ID = ?";

    private static final String SQL_REMOVE
            = "delete from locomotivas where ID = ?";

    private static final String SQL_FIND_ALL
            = "select * from locomotivas";

    //Método para salvar a locomotiva instanciada
    //com conexão do banco de dados e tratamento de exceções
    public int save(Locomotiva locomotiva) {
        Connection conn = Connect.getConnection();
        PreparedStatement pstm = null;
        int result = 0;
        try {
            pstm = conn.prepareStatement(SQL_INSERT);
            pstm.setString(1, locomotiva.getClasse());
            pstm.setString(2, locomotiva.getDescricao());
            pstm.setString(3, locomotiva.getPesoMaxRebocavel());
            pstm.setString(4, locomotiva.getPesoMaxLoc());
            pstm.setString(5, locomotiva.getBitolaLoc());
            pstm.setString(6, locomotiva.getComprimentoLoc());
            result = pstm.executeUpdate();
        } catch (SQLException e) {
            try {
                if (conn != null) {
                    conn.rollback();
                }
            } catch (SQLException e1) {
                e1.printStackTrace();
            } finally {
                Connect.close(conn, pstm, null);
            }
            e.printStackTrace();
        }
        return result;
    }

    //Método para atualizar a locomotiva instanciada
    //com conexão do banco de dados e tratamento de exceções
    public int update(Locomotiva locomotiva) {
        Connection conn = Connect.getConnection();
        PreparedStatement pstm = null;
        int result = 0;
        try {
            pstm = conn.prepareStatement(SQL_UPDATE);
            pstm.setString(1, locomotiva.getClasse());
            pstm.setString(2, locomotiva.getDescricao());
            pstm.setString(3, locomotiva.getPesoMaxRebocavel());
            pstm.setString(4, locomotiva.getPesoMaxLoc());
            pstm.setString(5, locomotiva.getBitolaLoc());
            pstm.setString(6, locomotiva.getComprimentoLoc());
            pstm.setLong(7, locomotiva.getId());
            result = pstm.executeUpdate();
        } catch (SQLException e) {
            try {
                if (conn != null) {
                    conn.rollback();
                }
            } catch (SQLException e1) {
                e1.printStackTrace();
            } finally {
                Connect.close(conn, pstm, null);
            }
            e.printStackTrace();
        }
        return result;
    }

    //Método para remover a locomotiva instanciada
    //com conexão do banco de dados e tratamento de exceções
    public int remove(Long id) {
        Connection conn = Connect.getConnection();
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
            } finally {
                Connect.close(conn, pstm, null);
            }
            e.printStackTrace();
        }
        return result;
    }

    //Método para achar todas as locomotivas dentro da lista
    //utilizando um array, com conexão de banco de dados e tratamento de exceções
    public List<Locomotiva> findAll() {
        Connection conn = Connect.getConnection();
        PreparedStatement pstm = null;
        List<Locomotiva> locomotivas = new ArrayList<Locomotiva>();
        ResultSet rs = null;
        try {
            pstm = conn.prepareStatement(SQL_FIND_ALL);
            rs = pstm.executeQuery();
            while (rs.next()) {
                Locomotiva locomotiva = new Locomotiva();
                locomotiva.setId(rs.getLong("id"));
                locomotiva.setClasse(rs.getString("classe"));
                locomotiva.setDescricao(rs.getString("descricao"));
                locomotiva.setPesoMaxRebocavel(rs.getString("pesomaxreboc"));
                locomotiva.setPesoMaxLoc(rs.getString("pesomaxloc"));
                locomotiva.setBitolaLoc(rs.getString("bitola"));
                locomotiva.setComprimentoLoc(rs.getString("comprimento"));
                locomotivas.add(locomotiva);
            }
        } catch (SQLException e) {
            try {
                if (conn != null) {
                    conn.rollback();
                }
            } catch (SQLException e1) {
                e1.printStackTrace();
            } finally {
                Connect.close(conn, pstm, rs);
            }
            e.printStackTrace();
        }
        return locomotivas;
    }
}


