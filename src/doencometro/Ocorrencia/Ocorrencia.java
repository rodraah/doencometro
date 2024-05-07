package doencometro.Ocorrencia;

import java.util.ArrayList;


public class Ocorrencia {
    // por enquanto começa do 0, mas idealmente vai pegar do banco de dados
    protected static int idCounter = 0;
    protected static ArrayList<Ocorrencia> todasAsOcorrencias = new ArrayList<Ocorrencia>();
    private int idCidade, idDoenca;
    private String data, estado;
    // private void novoId() {
    //     idCounter++;
    //     this.id = idCounter;
    // }

    public Ocorrencia( String data, String estado, int idCidade, int idDoenca) {
        this.data = data;
        this.estado = estado;
        this.idCidade = idCidade;
        this.idDoenca = idDoenca;
        todasAsOcorrencias.add(this);
    }

    /*public int obterId() {
        return this.id;
    }*/
    public String obterData() {
        return this.data;
    }

    public String obterEstado() {
        return this.estado;
    }

    public int obterIdCidade() {
        return this.idCidade;
    }

    public int obterIdDoenca() {
        return this.idDoenca;
    }
    
    public int obterTotalOcorrencias() {
        idCounter += 1;
        return idCounter;
    }
}