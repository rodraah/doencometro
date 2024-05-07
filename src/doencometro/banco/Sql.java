package doencometro.banco;

public class Sql {
    
    public static void inserirNoBanco(String tabela, Object... valores){
        try{
            String texto = "INSERT INTO " + tabela + " VALUES(";
            boolean primeiroValor = true;

            for(Object i : valores){
                if (primeiroValor) {
                    texto += i; 
                    primeiroValor = false; 
                } else {
                    texto += ", " + i; 
                    }
                }
                
            texto += ")";
            System.out.println(texto);
            Conexao.obterConexao().createStatement().execute(texto);
           
    } catch (Exception e) {
            System.out.println("Error message: "+ e);
    }
}
}
