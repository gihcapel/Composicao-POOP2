package dao;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import entity.Vagao;

public class VagaoDAO implements IVagaoDAO {

    private static final String SQL_INSERT =
            "insert into vagoestable (tipo, subtipo, bitola, proprietario, bitolametro, comprimento, pesomax) values (?,?,?,?,?,?,?)";

    private static final String SQL_UPDATE =
            "update vagoestable set tipo = ?, subtipo = ?, bitola = ?, proprietario=?, bitolametro=?, comprimento=?, pesomax=? where id = ?";

    private static final String SQL_REMOVE =
            "delete from vagoestable where ID = ?";

    private static final String SQL_FIND_ALL =
            "select * from vagoestable";


    public int save(Vagao vagao) {
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

