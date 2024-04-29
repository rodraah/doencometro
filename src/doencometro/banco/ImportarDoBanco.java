package doencometro.banco;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import doencometro.Cidade;
import doencometro.Doenca;

public class ImportarDoBanco { 
    public static void importar(Connection conexao) throws Exception {
        Statement stconexao = conexao.createStatement();

        ResultSet cidades = stconexao.executeQuery("SELECT * FROM Cidades");
        while (cidades.next()) {
            int id = cidades.getInt("id_cidade");
            String nome = cidades.getString("nome");
            new Cidade(id, nome);
        }

        ResultSet doencas = stconexao.executeQuery("SELECT * FROM Doencas");
        while (doencas.next()) {
            int id = doencas.getInt("id_doenca");
            String nome = doencas.getString("nome");
            new Doenca(id, nome);
        }

       /*  ResultSet ocorrencias = stconexao.executeQuery("SELECT * FROM Ocorrencias");
        while (ocorrencias.next()) {
            int id = ocorrencias.getInt("id_ocorrencia");
            String data = ocorrencias.getString("data");
            String estado = ocorrencias.getString("estado");
            int idCidade = ocorrencias.getInt("id_cidade");
            int idDoenca = ocorrencias.getInt("id_doenca");
            new Ocorrencia(id, data, estado, idCidade, idDoenca);
        }*/
    }
}