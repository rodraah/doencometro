package doencometro.banco;

import java.sql.ResultSet;
import java.sql.SQLException;

import doencometro.Ocorrencia.Ocorrencia;

public class Sql {
    
    public static void inserirNoBanco(String tabela, Object... valores){
        try{
            String texto = "INSERT INTO " + tabela + " VALUES(";
            boolean primeiroValor = true;

            for(Object i : valores){
                String tipo = i.getClass().getName();
                if( tipo.equals("java.lang.String") ){
                    i = "\"" + i + "\"";
                }

                if (primeiroValor) {
                    texto += i; 
                    primeiroValor = false;
                } else {
                    texto += ", " + i; 
                    }
                }
           
            texto += ")";
            System.out.println(texto);
            Conexao.obterConexao().createStatement().execute(texto);
           
    } catch (Exception e) {
            System.out.println("Error message: "+ e);
    }
}
    public static int obterQuantidadeDeCasos(String nomeCidade){
        //Select * from tabela
        try {
            String texto = "SELECT sum(QuantidadeCasos) FROM Ocorrencias INNER JOIN Cidades ON Ocorrencias.id_cidade = Cidades.id_cidade WHERE Cidades.nome = "
            + "\"" + nomeCidade + "\"";
            ResultSet i = Conexao.obterConexao().createStatement().executeQuery(texto);
            int numeroLegal = i.getInt(1);
            return numeroLegal;

        } catch (Exception e) {
            System.out.println("Error Message: " + e);

        }
        return 0;
    }

    public static Boolean deletarUltimaOcorrencia(){
        int ultimaOco = Ocorrencia.obterIdCounter();
        String texto = "DELETE FROM OCORRENCIAS WHERE ID_OCORRENCIA = " + ultimaOco;
        try {
            Conexao.obterConexao().createStatement().execute(texto);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }
}
