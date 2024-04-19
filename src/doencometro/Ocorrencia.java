public class Ocorrencia {
    // por enquanto começa do 0, mas idealmente vai pegar do banco de dados
    static int idCounter = 0;
    private int id;
    @SuppressWarnings("unused")
    private String nomeRelator;
    @SuppressWarnings("unused")
    private Doenca doenca;

    private void novoId() {
        idCounter++;
        this.id = idCounter;
    }

    public Ocorrencia(String nomeRelator, Doenca doenca) {
        novoId();

        this.nomeRelator = nomeRelator;
        this.doenca = doenca;
    }

    public int obterId() {
        return this.id;
    }
    
    public int obterTotalOcorrencias() {
        return idCounter;
    }
}