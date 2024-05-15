package doencometro.Banco;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {
	private final static String nomeBanco = "banco-dados";
	private final static String url = "jdbc:sqlite:" + nomeBanco + ".sqlite3";
	private static Connection conexao = null;
	
	public static Connection CriarConexao() {
		try {
			//SQLite driver
			Class.forName("org.sqlite.JDBC");

			conexao = DriverManager.getConnection(url);
		} catch (ClassNotFoundException e) {
			System.out.println("Driver SQLite não encontrado: " + e);
		} catch (SQLException e) {
			System.out.println(e);
		}
		return conexao;
	}

	public static boolean estaVazia(){
		boolean result = false;
		try {
			conexao.createStatement().
				executeQuery("SELECT * FROM Cidades");
			return result;
		} catch (SQLException e) {
			return true;
		}
		
	}
	public static Connection obterConexao() {
		return conexao;
	}
}
