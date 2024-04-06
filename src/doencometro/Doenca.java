package src.doencometro;

import java.util.ArrayList;

public class Doenca {
    private static ArrayList<Doenca> todasAsDoencas = new ArrayList<Doenca>();
    private String nome;
    private ArrayList<String> sintomas = new ArrayList<String>();
    
    public Doenca(String nome) {
        this.nome = nome;
        todasAsDoencas.add(this);
    }

    public void novoSintoma(String sintoma) {
        sintomas.add(sintoma);
    }

    public void novosSintomas(String... sintomas) {
        for (String sintoma : sintomas) {
            this.sintomas.add(sintoma);
        }
    }

    static Doenca acharDoencaPorNome(String nome) {
        for (Doenca doenca: todasAsDoencas) {
            if (doenca.obterNome().equals(nome)) {
                return doenca;
            } 
        }
        return null;
    }

    public String obterNome() {
        return this.nome;
    }

    public ArrayList<String> obterSintomas() {
        return sintomas;
    }
    
    static ArrayList<Doenca> obterTodasAsDoencas() {
        return todasAsDoencas;
    }
}