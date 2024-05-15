package doencometro.Banco;

import java.sql.ResultSet;
import java.sql.SQLException;

import doencometro.Ocorrencia.Ocorrencia;

public class Sql {
    private static String aspas = "\"";
    
    public static void inserirNoBanco(String tabela, Object... valores){
        try{
            String texto = "INSERT INTO " + tabela + " VALUES(";
            boolean primeiroValor = true;

            for(Object i : valores){
                // Guarda o tipo do valor atual
                String tipo = i.getClass().getName();
                // Se o tipo for uma string, rodeia ela de aspas
                if( tipo.equals("java.lang.String") ){
                    i = aspas + i + aspas;
                }

                // Se não for o primeiro valor, coloca uma vírgula antes
                if (primeiroValor) {
                    texto += i; 
                    primeiroValor = false;
                } else {
                    texto += ", " + i; 
                }
            }
           
            texto += ")";
            Conexao.obterConexao().createStatement().execute(texto);
           
        } catch (Exception e) {
            System.out.println("Error message: "+ e);
        }
    }

    public static int obterQuantidadeDeCasos(String nomeCidade){
        try {
            String texto = "SELECT sum(QuantidadeCasos) FROM Ocorrencias INNER JOIN Cidades ON Ocorrencias.id_cidade = Cidades.id_cidade WHERE Cidades.nome = "
            + aspas + nomeCidade + aspas;
            ResultSet i = Conexao.obterConexao().createStatement().executeQuery(texto);
            int numeroLegal = i.getInt(1);
            return numeroLegal;

        } catch (Exception e) {
            System.out.println("Error Message: " + e);

        }
        return 0;
    }

    // Obtém quantidade de casos em um estado específicado
    public static int obterQuantidadeDeCasos(String nomeCidade, String estado){
        try {
            String texto = "SELECT sum(QuantidadeCasos) FROM Ocorrencias INNER JOIN Cidades ON Ocorrencias.id_cidade = Cidades.id_cidade " + 
            "WHERE Cidades.nome = \"" + nomeCidade + aspas + " AND Estado = \"" + estado + aspas;
            ResultSet i = Conexao.obterConexao().createStatement().executeQuery(texto);
            int numeroLegal = i.getInt(1);
            return numeroLegal;

        } catch (Exception e) {
            System.out.println("Error Message: " + e);

        }
        return 0;
    }

    public static Boolean deletarUltimaOcorrencia(){
        int ultimaOcorrencia = Ocorrencia.obterIdCounter();
        String texto = "DELETE FROM OCORRENCIAS WHERE ID_OCORRENCIA = " + ultimaOcorrencia;
        try {
            Conexao.obterConexao().createStatement().execute(texto);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
