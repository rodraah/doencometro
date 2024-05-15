package doencometro.Banco;

import java.sql.Statement;
import java.sql.Connection;

import doencometro.Arquivo;

public class PrimeiroUso {
    public static Connection criarTabelas(Connection conexao) throws Exception {
        Statement stconexao = conexao.createStatement();
        stconexao.execute(
            "CREATE TABLE Doencas(id_doenca int(2) not null, Nome char, PRIMARY KEY(id_doenca))");
        stconexao.execute(
            "CREATE TABLE Cidades(id_cidade int(2) not null, nome char, PRIMARY KEY(id_cidade))");
        stconexao.execute(
            "CREATE TABLE Ocorrencias(id_ocorrencia int(2) not null, QuantidadeCasos int(2), Data char, Estado char, id_cidade int(2), id_doenca int(2), PRIMARY KEY(id_ocorrencia))");
        return conexao;
    }

    public static Connection obterDadosIniciais(Connection conexao) throws Exception {
        Statement stconexao = conexao.createStatement();
        String dadosIniciais = Arquivo.ler("dados iniciais.sql");
        for (String i : dadosIniciais.split("\n")) {
            stconexao.executeUpdate(i);
        }
        return conexao;
    }
}