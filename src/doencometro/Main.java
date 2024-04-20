// Tema
package doencometro;

import com.formdev.flatlaf.FlatDarculaLaf;
import doencometro.banco.PrimeiroUso;

public class Main {
    public static void print(Object texto) {
        System.out.println(texto);
    }

    public static void printf(String format, Object... strings){
        System.out.println(String.format(format, strings));
    }

    public static void main(String args[]) throws Exception {
        PrimeiroUso.CriarBancoEConexao();
        PrimeiroUso.InserirDados();
        
        // Mostra as cidades:
        for (Cidade i:Cidade.todasAsCidades) {
            System.out.printf("%s: %s\n", i.obterId(), i.obterNome());
        }

        // Configura o tema FlatLaf
        FlatDarculaLaf.setup();
        
        // Interface.relatorioOcorrencia();
    }
}