package estruturas.lista;

/**
 *
 * @author Ketrin | Jéssica | Marina Classe ListaDupla com atributo início do tipo Nodo
 * tempo_insercao -> Tempo para inserção de 100.000 estudantes
 * tempo_ordem -> Tempo para ordenamento crescente, por número de matrícula, dos estudantes
 * tempo_es -> Tempo para verificar o quantitativo de estudantes de Engenharia de Software
 * tempo_remocao -> Tempo para remoção de estudantes com matrícula <= 20205000
 */
public class ListaDupla {

    // Atributo de início/fim da lista duplamente encadeada
    private Nodo inicio;
    private long tempo_insercao;
    private long tempo_ordem;
    private long tempo_es;
    private long tempo_remocao;

    public ListaDupla(Nodo inicio) {
        this.inicio = inicio;
    }

    public ListaDupla() {

    }

// Getters e Setters
    public Nodo getInicio() {
        return inicio;
    }

    public void setInicio(Nodo inicio) {
        this.inicio = inicio;
    }

    public long getTempo_insercao() {
        return tempo_insercao;
    }

    public void setTempo_insercao(long tempo_insercao) {
        this.tempo_insercao = tempo_insercao;
    }

    public long getTempo_ordem() {
        return tempo_ordem;
    }

    public void setTempo_ordem(long tempo_ordem) {
        this.tempo_ordem = tempo_ordem;
    }

    public long getTempo_es() {
        return tempo_es;
    }

    public void setTempo_es(long tempo_es) {
        this.tempo_es = tempo_es;
    }

    public long getTempo_remocao() {
        return tempo_remocao;
    }

    public void setTempo_remocao(long tempo_remocao) {
        this.tempo_remocao = tempo_remocao;
    }
}
