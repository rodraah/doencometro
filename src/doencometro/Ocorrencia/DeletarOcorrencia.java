package doencometro.Ocorrencia;

public class DeletarOcorrencia {
    
    public static void deletarUltimaOcorrencia(){
        if (!Ocorrencia.todasAsOcorrencias.isEmpty()) {
            Ocorrencia.todasAsOcorrencias.remove(Ocorrencia.todasAsOcorrencias.size() - 1);
            Ocorrencia.idCounter--;
        }
    }
}
