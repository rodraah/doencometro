package doencometro.Ocorrencia;

public class PrintarOcorrencia {
    
    public static void printarOcorrencia(){
        for (Ocorrencia i:Ocorrencia.todasAsOcorrencias) {
            System.out.printf("%s:\n %s:\n %s:\n %s:\n %s:\n", /*i.obterId(),*/ i.obterData(), i.obterEstado(), i.obterIdCidade(), i.obterIdDoenca());
        }
    }
}
