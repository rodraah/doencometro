package doencometro;

import java.io.File;
import java.util.Scanner;

public class Arquivo {
    public static String ler(String caminho) throws Exception {
        File arquivo = new File(caminho);
        Scanner scanner = new Scanner(arquivo);
        String dados = "";

        while (scanner.hasNextLine()) {
            dados += scanner.nextLine();
        }
        scanner.close();
        return dados;
    }
}
