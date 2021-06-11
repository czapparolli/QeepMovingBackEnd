package qeep.moving.backend.cidade.factory;

import java.sql.*;

public class ConnectionFactory {
	
	public Connection getConnection() {
		
		try {
		return DriverManager.getConnection("jdbc:postgresql://localhost:5432/qeepmovingbackendcidade",
				"postgres", "Panda104455!");
		}
		catch (SQLException e) {
			
			throw new RuntimeException(e);
		}
		
		
	}
	
}
