package Conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Conexao {
			private final String driver = "com.mysql.cj.jdbc.Driver";
			private final String url = "jdbc:mysql://localhost/TESTE";
			private final String user = "root";
			Connection conexao = null;
			
			public Conexao(){
				Connection();
			}
			
			
			public void Connection() {
				//Try-catch for error handling (it's required)
				
				try {
					//MySQL driver
					Class.forName(driver);
					//connection with data base through a url(path), user(user) and password
					conexao = DriverManager.getConnection(url, user, "mysql");
					
				} catch (ClassNotFoundException e) {
					System.out.println("O driver não foi localizadoKKKKK");
					
				} catch (SQLException ex) {
					System.out.println("Deu nao vey kkkk" + ex.getMessage());
				} 
			}
				
			
			
}
