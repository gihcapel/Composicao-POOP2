package dao;
import java.sql.*;

public class Connect {

    private static final String URL_MYSQL = "jdbc:mysql://localhost/cdcol";
    private static final String DRIVER_CLASS_MYSQL = "com.mysql.jdbc.Driver";
    private static final String USER = "root";
    private static final String PASS = "";

    public static Connection getConnection() {
        System.out.println("Conectando ao Banco de Dados");
        try {
            Class.forName(DRIVER_CLASS_MYSQL);
            return DriverManager.getConnection(URL_MYSQL, USER, PASS);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    public static void close(Connection conn, PreparedStatement stmt, ResultSet rs) {
        try {
            if (conn != null) {
                conn.close();
            }

            if (stmt != null) {
                stmt.close();
            }

            if (rs != null) {
                rs.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void createTable() {
        Connection connection = getConnection();
        PreparedStatement stmt = null;
        String sql = "CREATE TABLE IF NOT EXISTS `vagoestable` (\n" +
                "  `id` bigint(20) NOT NULL AUTO_INCREMENT,\n" +
                "  `tipo` varchar(50) NOT NULL,\n" +
                "  `subtipo` varchar(50) NOT NULL,\n" +
                "  `bitola` varchar(50) NOT NULL,\n" +
                "  `proprietario` varchar(50) NOT NULL,\n" +
                "  `bitolametro` varchar(50) NOT NULL,\n" +
                "  `comprimento` varchar(50) NOT NULL,\n" +
                "  `pesomax` varchar(50) NOT NULL,\n" +
                "  PRIMARY KEY (`ID`)\n" +
                ")";
        String sql2= "CREATE TABLE IF NOT EXISTS `locomotivas` (\n" +
                "  `id` bigint(20) NOT NULL AUTO_INCREMENT,\n" +
                "  `classe` varchar(50) NOT NULL,\n" +
                "  `descricao` varchar(50) NOT NULL,\n" +
                "  `pesomaxreboc` varchar(50) NOT NULL,\n" +
                "  `pesomaxloc` varchar(50) NOT NULL,\n" +
                "  `bitola` varchar(50) NOT NULL,\n" +
                "  `comprimento` varchar(50) NOT NULL,\n" +
                "  PRIMARY KEY (`id`)\n" +
                ")";
        try {
            stmt = connection.prepareStatement(sql);
            stmt.execute();
            System.out.println("Create Table 1 Ok!");
            stmt = connection.prepareStatement(sql2);
            stmt.execute();
            System.out.println("Create Table 2 Ok!");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(connection, stmt, null);
        }
    }
}

