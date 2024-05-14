package doencometro;

import java.util.ArrayList;

public class Doenca {
    static ArrayList<Doenca> todasAsDoencas = new ArrayList<Doenca>();
    private int id;
    private String nome;
    
    public Doenca(int id, String nome) {
        this.id         = id;
        this.nome       = nome;
        todasAsDoencas.add(this);
    }

    public static Doenca acharDoencaPorNome(String nome) {
        for (Doenca doenca: todasAsDoencas) {
            if (doenca.obterNome().equals(nome)) {
                return doenca;
            } 
        }
        return null;
    }

    public int obterId() {
        return this.id;
    }
    public String obterNome() {
        return this.nome;
    }

    // static ArrayList<Doenca> obterTodasAsDoencas() {
    //     return todasAsDoencas;
    // }
}