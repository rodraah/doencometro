package src.doencometro;

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
        // Criação de doença
        Doenca gripe = new Doenca("Gripe");
        gripe.novosSintomas(
            "Corisa", "Dor no corpo", "Morte lenta", "Olho azul");

        Doenca lol = new Doenca("Jogador de LOL");
        lol.novosSintomas(
            "Feiura crônica", "Odor de Cheetos", "Sem namorada");
        
        // Configura o tema FlatLaf
        FlatDarculaLaf.setup();
        
        Interface.relatorioOcorrencia();
    }
}