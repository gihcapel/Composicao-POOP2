package BD;
import java.sql.*;

public class Connect
{
	public Connection getConnection() {
		try {
			String userName = "root";
			String password = "";
			String url = "jdbc:mysql://localhost/cdcol";
			Connection conn = DriverManager.getConnection (url, userName, password);
			System.out.println ("Conexão com o BD estabelecida!");
			return conn;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
}
