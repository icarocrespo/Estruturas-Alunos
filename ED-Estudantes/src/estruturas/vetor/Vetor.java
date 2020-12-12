package estruturas.vetor;

import java.util.Collection;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import main.Estudante;

/**
 *
 * @author Ketrin | Jéssica | Marina Classe Vetor tempo_insercao -> Tempo para
 * inserção de 100.000 estudantes tempo_ordem -> Tempo para ordenamento
 * crescente, por número de matrícula, dos estudantes tempo_es -> Tempo para
 * verificar o quantitativo de estudantes de Engenharia de Software
 * tempo_remocao -> Tempo para remoção de estudantes com matrícula <= 20205000
 */
public class Vetor implements Map<Integer, Estudante> {

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

    public Vetor() {

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
    public void inserir() {
        long tempo = System.nanoTime();

        int posicao = 0;
        Nodo nodo;

//        for (Estudante estudante : cl) {
//            nodo = new Nodo();
//            nodo.setMatricula(estudante.getMatricula());
//            nodo.setEstudante(estudante);
//
//            this.vetor[posicao] = nodo;
//            posicao++;
//        }
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

    @Override
    public int size() {
        return this.tamanho;
    }

    @Override
    public boolean isEmpty() {
        return this.tamanho == 0;
    }

    @Override
    public boolean containsKey(Object key) {
        for (Nodo nodo : this.vetor) {
            if (nodo.getMatricula().equals(key)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean containsValue(Object value) {
        for (Nodo nodo : this.vetor) {
            if (nodo.getEstudante().equals(value)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public Estudante get(Object key) {
        for (Nodo nodo : this.vetor) {
            if (nodo.getMatricula().equals(key)) {
                return nodo.getEstudante();
            }
        }
        return null;
    }

    @Override
    public Estudante put(Integer key, Estudante value) {
        Nodo nodo = new Nodo();

        nodo.setMatricula(key);
        nodo.setEstudante(value);
        this.vetor[this.tamanho] = nodo;
        tamanho++;
        return value;
    }

    @Override
    public Estudante remove(Object key) {
        Estudante estudante = null;
        int i;

        // procura e captura o estudante
        for (i = 0; i < this.vetor.length; i++) {
            if (this.vetor[i].getMatricula().equals(key)) {
                estudante = this.vetor[i].getEstudante();
            }
        }

        // suprime estudante removido
        while (i < this.vetor.length) {
            this.vetor[i] = this.vetor[i + 1];
            i++;
        }

        return estudante;
    }

    @Override
    public void putAll(Map<? extends Integer, ? extends Estudante> m) {
        
        Collection<Estudante> collectionEstudante = (Collection<Estudante>) m.values();
        Nodo nodo;
        
        while(collectionEstudante.iterator().hasNext()){
            nodo = new Nodo();
            nodo.setEstudante(collectionEstudante.iterator().next());
            nodo.setMatricula(nodo.getEstudante().getMatricula());
            
            this.vetor[tamanho] = nodo;
        }
        // TODO
    }

    @Override
    public void clear() {
        for (int i = 0; i < this.vetor.length; i++) {
            this.vetor[i] = null;
        }
    }

    @Override
    public Set<Integer> keySet() {
        Set<Integer> keys = new HashSet<>();
        
        for (int i = 0; i < this.vetor.length; i++) {
            keys.add(vetor[i].getMatricula());
        }
        return keys;
    }

    @Override
    public Collection<Estudante> values() {
        Collection<Estudante> collectionEstudantes = null;
        
        for (int i = 0; i < this.vetor.length; i++) {
            collectionEstudantes.add(vetor[i].getEstudante());
        }
        return collectionEstudantes;
    }

    @Override
    public Set<Entry<Integer, Estudante>> entrySet() {
        Set<Entry<Integer, Estudante>> setEstudantes = null;
       
        //setEstudantes.addAll(this.values());

        return setEstudantes;
    }
}
