package doencometro;

import java.util.ArrayList;

public class Cidade {
    private int id;
    private String nome;
    public static ArrayList<Cidade> todasAsCidades = new ArrayList<Cidade>();

    public Cidade(int id,String nome) {
        this.id = id;
        this.nome = nome;
        todasAsCidades.add(this);
    }

    public static Cidade acharCidade(String nome) {
        for (Cidade i: todasAsCidades ) {
            if (i.obterNome().equals(nome)) {
                return i;
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
}
