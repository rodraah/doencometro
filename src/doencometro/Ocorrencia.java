package doencometro;

import java.util.ArrayList;

public class Ocorrencia {
    // por enquanto começa do 0, mas idealmente vai pegar do banco de dados
    static int idCounter = 0;
    static ArrayList<Ocorrencia> todasAsOcorrencias = new ArrayList<Ocorrencia>();

    private int id, idCidade, idDoenca;
    private String data, estado;

    // private void novoId() {
    //     idCounter++;
    //     this.id = idCounter;
    // }

    public Ocorrencia(int id, String data, String estado, int idCidade, int idDoenca) {
        this.id = id;
        this.data = data;
        this.estado = estado;
        this.idCidade = idCidade;
        this.idDoenca = idDoenca;

        todasAsOcorrencias.add(this);
    }

    public int obterId() {
        return this.id;
    }
    public String obterData() {
        return this.data;
    }
    
    public int obterTotalOcorrencias() {
        return idCounter;
    }
}