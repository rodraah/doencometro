package doencometro;

// Tema
import com.formdev.flatlaf.FlatLightLaf;

import java.sql.Connection;

import doencometro.Banco.Conexao;
import doencometro.Banco.PrimeiroUso;
import doencometro.Interface.TelaLogin;
import doencometro.Banco.ImportarDoBanco;

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