package doencometro.Ocorrencia;

import doencometro.banco.Sql;

public class AdicionarOcorrencia {
    public static Ocorrencia adicionarOcorrencia() {
       // int id = ObterInputsAddOcorrencia.obterId();
        String data = ObterInputsAddOcorrencia.obterData();
        String estado = ObterInputsAddOcorrencia.obterEstado();
        int idCidade = ObterInputsAddOcorrencia.obterIdCidade();
        int idDoenca = ObterInputsAddOcorrencia.obterIdDoenca();
        return new Ocorrencia(data, estado, idCidade, idDoenca);
    }

    public static Ocorrencia adicionarOcorrencia(String data, String estado, Integer idCidade, Integer idDoenca){
        Sql.inserirNoBanco("Ocorrencias", data, estado, idCidade, idDoenca);
        return new Ocorrencia(data, estado, idCidade, idDoenca);
    }
}