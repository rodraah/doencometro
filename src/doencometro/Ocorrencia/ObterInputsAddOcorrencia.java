package doencometro.Ocorrencia;

import java.util.Scanner;

public class ObterInputsAddOcorrencia {
    private static final Scanner sc = new Scanner(System.in);

   /*  public static int obterId() {
        System.out.print("Digite o id: ");
        return sc.nextInt();
    }*/

    public static String obterData() {
        System.out.print("Digite a data: ");
        return sc.next();
    }

    public static String obterEstado() {
        System.out.print("Digite o estado: ");
        return sc.next();
    }

    public static int obterIdCidade() {
        System.out.print("Digite o idCidade: ");
        return sc.nextInt();
    }

    public static int obterIdDoenca() {
        System.out.print("Digite o idDoenca: ");
        return sc.nextInt();
    }
}
