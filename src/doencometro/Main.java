package doencometro;

// Tema
import com.formdev.flatlaf.FlatLightLaf;

import java.sql.Connection;

import doencometro.Interfaces.TelaLogin;
import doencometro.banco.Conexao;
import doencometro.banco.PrimeiroUso;
import doencometro.banco.ImportarDoBanco;

public class Main {
    public static void main(String args[]) throws Exception {
        Connection conexao = Conexao.CriarConexao();

        if (Conexao.estaVazia()) {
            PrimeiroUso.criarTabelas(conexao);
            PrimeiroUso.obterDadosIniciais(conexao);
        }

        ImportarDoBanco.importar(conexao);

        // Tema claro
        FlatLightLaf.setup();

        TelaLogin.chamarInterface();
    }
}