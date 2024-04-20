package doencometro.banco;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.ResultSet;

import doencometro.Arquivo;
import doencometro.Cidade;

public class PrimeiroUso {
    private static Connection conexao = null;
    private static Statement stconexao = null;

    public static Connection CriarBancoEConexao() throws Exception {
        conexao = Conexao.CriarConexao();
        stconexao = conexao.createStatement();
        stconexao.execute("DROP TABLE IF EXISTS Doencas");
        stconexao.execute("DROP TABLE IF EXISTS Sintomas");
        stconexao.execute("DROP TABLE IF EXISTS Ocorrencias");
        stconexao.execute("DROP TABLE IF EXISTS Cidades");
        stconexao.execute(
            "CREATE TABLE Doencas(id_doenca int(2) not null, Nome char, id_sintomas int(2), PRIMARY KEY(id_doenca))");
        stconexao.execute(
            "CREATE TABLE Sintomas(id_sintomas int(2) not null, Nome char, PRIMARY KEY(id_sintomas))");
        stconexao.execute(
            "CREATE TABLE Ocorrencias(id_ocorrencia int(2) not null, Data char, Estado char, id_cidade int(2), id_doenca int(2), PRIMARY KEY(id_ocorrencia))");
        stconexao.execute(
            "CREATE TABLE Cidades(id_cidade int(2) not null, nome char, PRIMARY KEY(id_cidade))");
        return conexao;
    }

    public static Connection InserirDados() throws Exception {
        String dadosIniciais = Arquivo.ler("dados iniciais.sql");
        stconexao.execute(dadosIniciais);

        ResultSet cidades = stconexao.executeQuery("SELECT * FROM Cidades");
        while (cidades.next()) {
            int id = cidades.getInt("id_cidade");
            String nome = cidades.getString("nome");
            new Cidade(id, nome);
        }

        return conexao;
    }
}