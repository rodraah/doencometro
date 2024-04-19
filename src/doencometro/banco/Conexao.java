package banco;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {
	private final static String url = "jdbc:sqlite:dados.db";
	private static Connection conexao = null;
	
	public static Connection CriarConexao() {
		try {
			//SQLite driver
			Class.forName("org.sqlite.JDBC");

			//connection with data base through a url(path), user(user) and password
			conexao = DriverManager.getConnection(url);
		} catch (ClassNotFoundException e) {
			System.out.println("Driver SQLite não encontrado: " + e);
		} catch (SQLException e) {
			System.out.println();
		}
		return conexao;
	}
}
