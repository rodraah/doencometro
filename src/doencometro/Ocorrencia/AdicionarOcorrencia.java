package doencometro.Ocorrencia;

import doencometro.banco.Sql;

public class AdicionarOcorrencia {
   /*-  public static Ocorrencia adicionarOcorrencia() {
       // int id = ObterInputsAddOcorrencia.obterId();
        String data = ObterInputsAddOcorrencia.obterData();
        String estado = ObterInputsAddOcorrencia.obterEstado();
        int idCidade = ObterInputsAddOcorrencia.obterIdCidade();
        int idDoenca = ObterInputsAddOcorrencia.obterIdDoenca();
        return new Ocorrencia(data, estado, idCidade, idDoenca);
    }*/

    public static Ocorrencia adicionarOcorrencia(int qtdeCasos, String data, String estado, Integer idCidade, Integer idDoenca){
        int id = Ocorrencia.idCounter + 1;
        Sql.inserirNoBanco("Ocorrencias", id, qtdeCasos, data, estado, idCidade, idDoenca);
        return new Ocorrencia(id, qtdeCasos, data, estado, idCidade, idDoenca);
    }
}