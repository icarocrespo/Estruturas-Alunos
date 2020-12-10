package estruturas.vetor;

import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import main.Estudante;
import main.Mapa;

/**
 *
 * @author Ketrin | Jéssica | Marina Classe Vetor tempo_insercao -> Tempo para
 * inserção de 100.000 estudantes tempo_ordem -> Tempo para ordenamento
 * crescente, por número de matrícula, dos estudantes tempo_es -> Tempo para
 * verificar o quantitativo de estudantes de Engenharia de Software
 * tempo_remocao -> Tempo para remoção de estudantes com matrícula <= 20205000
 */
public class Vetor {

    private long tempo_insercao;
    private long tempo_ordem;
    private long tempo_es;
    private long tempo_remocao;
    private Nodo[] vetor;
    private int tamanho;

    public Vetor(int tamanho) {
        this.tamanho = tamanho;
        this.vetor = new Nodo[this.tamanho];
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

    public Nodo[] getVetor() {
        return vetor;
    }

    public void setVetor(Nodo[] vetor) {
        this.vetor = vetor;
    }

    public int getTamanho() {
        return tamanho;
    }

    public void setTamanho(int tamanho) {
        this.tamanho = tamanho;
    }

// Métodos aos requisitos
    // Inserir 100.000 (cem mil) estudantes
    public void inserir(Mapa mapa) {
        long tempo = System.nanoTime();
        Collection<Estudante> cl = mapa.getEstudantes().values();
        int posicao = 0;
        Nodo nodo;
        
        for (Estudante estudante : cl){
            nodo = new Nodo();
            nodo.setMatricula(estudante.getMatricula());
            nodo.setEstudante(estudante);
            
            this.vetor[posicao] = nodo;
            posicao++;
        }
        
        this.tempo_insercao = System.nanoTime() - tempo;
    }

    // Apresentar todos os estudantes em ordem crescente de número de matricula
    public void mostrarCrescente() {
        long tempo = System.nanoTime();
        Nodo[] vetor_crescente = new Nodo[this.tamanho];

        for (int i = 0; i < vetor.length; i++) {
            for (int j = 0; j < vetor.length; j++) {
                if (vetor[j].getMatricula() < vetor[i].getMatricula()) {
                    vetor_crescente[i] = vetor[i];
                }
            }
        }
        mostrar(vetor_crescente);
        this.tempo_ordem = System.nanoTime() - tempo;
    }

    // Verificar quantos estudantes realizam o curso Engenharia de Software
    public int contarES() {
        long tempo = System.nanoTime();
        int count = 0;
        for (int i = 0; i < this.tamanho; i++) {
            if (this.vetor[i].getEstudante().getCurso().equals("Engenharia de Software")) {
                count++;
            }
            this.tempo_es = System.nanoTime() - tempo;
        }
        return count;
    }

    // Remover todos os estudantes com número de matricula igual ou inferior a 202050000 (com novo vetor)
    public Nodo[] remocaoNovo() {
        long tempo = System.nanoTime();
        Nodo[] vetor_removidos = new Nodo[this.vetor.length];
        int posicao = 0;

        for (int i = 0; i < vetor_removidos.length; i++) {
            if (vetor[i].getMatricula() >= 202050000) {
                vetor_removidos[posicao] = vetor[i];
            }
            posicao++;
        }
        this.tempo_remocao = System.nanoTime() - tempo;

        return vetor_removidos;
    }

    // Remover todos os estudantes com número de matricula igual ou inferior a 202050000 (no próprio vetor)
    public void remocao() {
        long tempo = System.nanoTime();

        this.tempo_remocao = System.nanoTime() - tempo;
    }

    // Mostrar o vetor
    public void mostrar(Nodo[] vetor) {
        System.out.println("Mostrando registros da ED Vetor:");
        for (int i = 0; i < vetor.length; i++) {
            System.out.println("Posição " + i + ": Matrícula: "
                    + vetor[i].getEstudante().getMatricula() + " | Curso: " + vetor[i].getEstudante().getCurso());
        }
        System.out.println("--- FIM ---");
    }
}
