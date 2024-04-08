package Methods;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import Conexao.Conexao;

public class Select {
	
	private String campo;
	private String tabela;
	Connection conexao;
	
	Conexao conn = new Conexao();
	
	public Select() {
		select();
	}
	
	public void select() {
		
		try {
			ResultSet rsCliente = conexao.createStatement().executeQuery("SELECT * FROM clientes");
			while(rsCliente.next()) {
				System.out.println("Nome: " + rsCliente.getString("nome"));
				System.out.println("email: " + rsCliente.getString("email"));
				System.out.println("telefone: " + rsCliente.getString("telefone"));
				System.out.println("---------------------------");
			}
				
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		
	}
}
