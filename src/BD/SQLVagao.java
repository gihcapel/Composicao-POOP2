package BD;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import Principais.Vagao;

public class SQLVagao {
	private Vagao connectVagao;

	public SQLVagao(Vagao connectVagao) {
		this.connectVagao = connectVagao;
		Connection con = new Connect().getConnection();
		String sql =  "insert into vagao(tipo,subtipo, bitola, comprimento, nome)VALUES(?,?,?,?,?)";        
		try {     
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1, connectVagao.getTipo());        
			stmt.setInt(2, (char)connectVagao.getSubtipo());    
			stmt.setInt(3, (char)connectVagao.getBitola());
			stmt.setFloat(4, (float) connectVagao.getComprimento());
			stmt.setString(5, connectVagao.getProprietario());
			stmt.execute();     
			stmt.close();        
		} catch (SQLException u) {        
			throw new RuntimeException(u);        
		}    	
	}                            
}



