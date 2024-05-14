package doencometro;

public class Autenticacao {
    private static String[] usuarios = {"admin", "upa", "dba"};
    private static String[] senhas   = {"admin", "upa", "dba"};

    public static String logar(String usuario, String senha) {
        String resultado;
        resultado = "";

        for (int i=0; i<3;i++) {
            if (!usuarios[i].equals(usuario))
                continue;
            
            if (senhas[i].equals(senha))
                resultado = usuarios[i];
        }

        return resultado;
    }
}