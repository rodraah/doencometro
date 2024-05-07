package doencometro;

// Tema
//import com.formdev.flatlaf.FlatDarculaLaf;

import java.sql.Connection;

import doencometro.Interfaces.TelaLogin;
import doencometro.banco.Conexao;
import doencometro.banco.PrimeiroUso;
import doencometro.banco.ImportarDoBanco;

public class Main {
    public static void print(Object texto) {
        System.out.println(texto);
    }

    public static void printf(String format, Object... strings){
        System.out.println(String.format(format, strings));
    }

    public static void main(String args[]) throws Exception {
        Connection conexao = Conexao.CriarConexao();
        
        if (Conexao.estaVazia()) {
            PrimeiroUso.criarTabelas(conexao);
            PrimeiroUso.inserirDados(conexao);
        }

        ImportarDoBanco.importar(conexao);
        
        // Mostra as cidades:
        /*for (Cidade i:Cidade.todasAsCidades) {
            System.out.printf("%s: %s\n", i.obterId(), i.obterNome());
        }
        
        // Mostra as doencas:
        for (Doenca i:Doenca.todasAsDoencas) {
            System.out.printf("%s: %s\n", i.obterId(), i.obterNome());
        }*/

        TelaLogin.chamarInterface();
    }
}