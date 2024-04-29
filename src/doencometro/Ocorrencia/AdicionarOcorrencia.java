package doencometro.Ocorrencia;

public class AdicionarOcorrencia {
    public static Ocorrencia adicionarOcorrencia() {
       // int id = ObterInputsAddOcorrencia.obterId();
        String data = ObterInputsAddOcorrencia.obterData();
        String estado = ObterInputsAddOcorrencia.obterEstado();
        int idCidade = ObterInputsAddOcorrencia.obterIdCidade();
        int idDoenca = ObterInputsAddOcorrencia.obterIdDoenca();
        return new Ocorrencia(data, estado, idCidade, idDoenca);
    }
}