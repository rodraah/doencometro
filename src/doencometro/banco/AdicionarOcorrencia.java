package doencometro.banco;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import doencometro.Cidade;
import doencometro.Doenca;

public class AdicionarOcorrencia {
    
    public static void adicionarOcorrencia(String data, String obito, Cidade cidade, Doenca doenca) throws Exception {
        Connection conexao = Conexao.obterConexao();
        int idCidade = cidade.obterId();

        int idDoenca = doenca.obterId();
	
    	try {
    		String sqlLastId = "SELECT MAX(id_ocorrencia) FROM Ocorrencias";
            ResultSet rs = conexao.createStatement().executeQuery(sqlLastId);

            int ultimoId = 0;
            if (rs.next()) {
                ultimoId = rs.getInt(1);
            }
            // Incrementando o último ID
            int novoId = ultimoId + 1;
            
    		String sql = "INSERT INTO Ocorrencias (id_ocorrencia, Data, Estado, id_cidade, id_doenca) " +
    	             "VALUES ('" 
    				 + novoId + "', '" 
    				 + data + "', '" 
    	             + obito + "', '" 
    				 + idCidade + "', '" 
    	             + idDoenca + "')";
    		conexao.createStatement().execute(sql);
    		 rs.close();
    	} catch (SQLException e) {
            e.printStackTrace();
    	}
    }
}