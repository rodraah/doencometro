// Tema
import com.formdev.flatlaf.FlatDarculaLaf;

public class Main {
    public static void print(Object texto) {
        System.out.println(texto);
    }

    public static void printf(String format, Object... strings){
        System.out.println(String.format(format, strings));
    }

    public static void main(String args[]) throws Exception {
        banco.PrimeiroUso.CriarBancoEConexao();
        banco.PrimeiroUso.InserirDados();

        // Configura o tema FlatLaf
        FlatDarculaLaf.setup();
        
        // Interface.relatorioOcorrencia();
    }
}