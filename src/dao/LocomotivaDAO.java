package dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entity.Locomotiva;

public class LocomotivaDAO implements ILocomotivaDAO {

    private static final String SQL_INSERT =
            "insert into locomotivas (EDITORA, TITULO, ISBN) values (?,?,?)";

    private static final String SQL_UPDATE =
            "update locomotivas set EDITORA = ?, TITULO = ?, ISBN = ? where ID = ?";

    private static final String SQL_REMOVE =
            "delete from locomotivas where ID = ?";

    private static final String SQL_FIND_ALL =
            "select * from locomotivas";


    public int save(Locomotiva locomotiva) {
        Connection conn = Connect.getConnection();
        PreparedStatement pstm = null;
        int result = 0;
        try {
            pstm = conn.prepareStatement(SQL_INSERT);
            pstm.setString(1, locomotiva.getEditora());
            pstm.setString(2, locomotiva.getTitulo());
            pstm.setString(3, locomotiva.getIsbn());
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

    public int update(Locomotiva locomotiva) {
        Connection conn =  Connect.getConnection();
        PreparedStatement pstm = null;
        int result = 0;
        try {
            pstm = conn.prepareStatement(SQL_UPDATE);
            pstm.setString(1, locomotiva.getEditora());
            pstm.setString(2, locomotiva.getTitulo());
            pstm.setString(3, locomotiva.getIsbn());
            pstm.setLong(4, locomotiva.getId());
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
                locomotiva.setId(rs.getLong("ID"));
                locomotiva.setEditora(rs.getString("EDITORA"));
                locomotiva.setTitulo(rs.getString("TITULO"));
                locomotiva.setIsbn(rs.getString("ISBN"));

                locomotivas.add(locomotiva);
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
        return locomotivas;
    }
}

