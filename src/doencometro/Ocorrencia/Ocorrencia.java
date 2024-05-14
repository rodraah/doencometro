package doencometro.Ocorrencia;

import java.util.ArrayList;


public class Ocorrencia {
    // por enquanto começa do 0, mas idealmente vai pegar do banco de dados
    protected static int idCounter = 0;
    protected static ArrayList<Ocorrencia> todasAsOcorrencias = new ArrayList<Ocorrencia>();
    public static final String[] ESTADOS = {"Vivo", "Internado", "Contaminado", "Óbito"};
    public static final String[] DOENCAS = {"Gripe", "Covid-19"};
    private int idCidade, idDoenca, qtdeCasos, id;
    private String data, estado;

    public Ocorrencia( int id, int qtdeCasos, String data, String estado, int idCidade, int idDoenca ) {
        this.id = id;
        this.qtdeCasos = qtdeCasos;
        this.data = data;
        this.estado = estado;
        this.idCidade = idCidade;
        this.idDoenca = idDoenca;
        idCounter += 1;
        todasAsOcorrencias.add(this);
    }

    public static int obterIdCounter(){
        return idCounter;
    }
}