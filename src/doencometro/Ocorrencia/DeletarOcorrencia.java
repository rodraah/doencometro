package doencometro.Ocorrencia;

import doencometro.Banco.Sql;

public class DeletarOcorrencia {
    
    public static void deletarUltimaOcorrencia(){
        if (!Ocorrencia.todasAsOcorrencias.isEmpty()) {
            Ocorrencia.todasAsOcorrencias.remove(Ocorrencia.todasAsOcorrencias.size() - 1);
            Sql.deletarUltimaOcorrencia();
            Ocorrencia.idCounter--;
        }
    }
}
