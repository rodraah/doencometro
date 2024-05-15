package doencometro.Ocorrencia;

import doencometro.Banco.Sql;

public class AdicionarOcorrencia {
    public static Ocorrencia adicionar(int qtdeCasos, String data, String estado, Integer idCidade, Integer idDoenca){
        int id = Ocorrencia.idCounter + 1;
        Sql.inserirNoBanco("Ocorrencias", id, qtdeCasos, data, estado, idCidade, idDoenca);
        return new Ocorrencia(id, qtdeCasos, data, estado, idCidade, idDoenca);
    }
}