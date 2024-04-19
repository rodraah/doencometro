package banco;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.ResultSet;

public class PrimeiroUso {
    private static Connection conexao = null;
    private static Statement stconexao = null;

    public static Connection CriarBancoEConexao() throws Exception {
        conexao = banco.Conexao.CriarConexao();
        stconexao = conexao.createStatement();
        stconexao.execute("DROP TABLE IF EXISTS Doencas");
        stconexao.execute("DROP TABLE IF EXISTS Sintomas");
        stconexao.execute("DROP TABLE IF EXISTS Ocorrencias");
        stconexao.execute("DROP TABLE IF EXISTS Cidades");
        stconexao.execute("CREATE TABLE Doencas(id_doenca int(2), Nome char, id_sintomas int(2))");
        stconexao.execute("CREATE TABLE Sintomas(id_sintomas int(2), Nome char)");
        stconexao.execute("CREATE TABLE Ocorrencias(id_ocorrencia int(2), Data char, Estado char, id_cidade int(2), id_doenca int(2))");
        stconexao.execute("CREATE TABLE Cidades(id_cidade int(2), nome char)");
        return conexao;
    }

    public static Connection InserirDados() throws Exception {
        stconexao.execute("INSERT INTO Cidades VALUES(1, \"São Bernardo\")");
        stconexao.execute("INSERT INTO Cidades VALUES(2, \"São Caetano\")");
        stconexao.execute("INSERT INTO Cidades VALUES(3, \"Santo André\")");
        stconexao.execute("INSERT INTO Cidades VALUES(4, \"São Paulo\")");

        ResultSet cidades = stconexao.executeQuery("SELECT * FROM Cidades");
        while (cidades.next()) {
            System.out.println(cidades.getString("Nome") + ": " + cidades.getString("id_cidade"));
        }
        return conexao;
    }
}