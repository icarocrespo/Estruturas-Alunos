package estruturas.lista;

import java.util.Collection;
import java.util.Map;
import java.util.Set;
import main.Estudante;

/**
 *
 * @author Ketrin | Jéssica | Marina Classe ListaDupla com atributo início do
 * tipo Nodo tempo_insercao -> Tempo para inserção de 100.000 estudantes
 * tempo_ordem -> Tempo para ordenamento crescente, por número de matrícula, dos
 * estudantes tempo_es -> Tempo para verificar o quantitativo de estudantes de
 * Engenharia de Software tempo_remocao -> Tempo para remoção de estudantes com
 * matrícula <= 20205000
 */
public class ListaDupla implements Map<Integer, Estudante> {

    // Atributo de início/fim da lista duplamente encadeada
    private Nodo inicio;
    private long tempo_insercao;
    private long tempo_ordem;
    private long tempo_es;
    private long tempo_remocao;
    private int nElementos;

    public ListaDupla(Nodo inicio, int nElementos) {
        this.inicio = inicio;
        this.nElementos = nElementos;
    }

    public ListaDupla(int nElementos) {
        this.inicio = null;
        this.nElementos = nElementos;
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

    public int getnElementos() {
        return nElementos;
    }

    public void setnElementos(int nElementos) {
        this.nElementos = nElementos;
    }

// Métodos aos requisitos
    // Inserir 100.000 (cem mil) estudantes
    public void inserir() {
        long tempo = System.nanoTime();
        Estudante estudante;

        for (int i = 0; i < this.nElementos; i++) {
            estudante = new Estudante();
            put(estudante.getMatricula(), estudante);
        }
        this.tempo_insercao = System.nanoTime() - tempo;
    }

    // Apresentar todos os estudantes em ordem crescente de número de matricula
    public void mostrarCrescente() {
        long tempo = System.nanoTime();

        Nodo aux = this.inicio;
        Nodo aux2 = aux.getProximo();

        

        do {
            aux = aux.getAnterior();
        } while (aux.getAnterior() != null);

        mostrar(aux);
        this.tempo_ordem = System.nanoTime() - tempo;
    }

    // Verificar quantos estudantes realizam o curso Engenharia de Software
    public int contarES() {
        long tempo = System.nanoTime();
        int count = 0;

        Nodo aux = this.inicio;
        while (aux != null) {
            if (aux.getEstudante().getCurso().equals("Engenharia de Software")) {
                count++;
            }
            aux = aux.getProximo();
        }
        this.tempo_es = System.nanoTime() - tempo;
        return count;
    }

    // Remover todos os estudantes com número de matricula igual ou inferior a 202050000
    public void remocao() {
        long tempo = System.nanoTime();

        remove(202050000);

        this.tempo_remocao = System.nanoTime() - tempo;
    }

    // Mostrar a lita
    public void mostrar(Nodo nodo) {
        System.out.println("Mostrando registros da ED Lista duplamente encadeada:");
        int i = 0;
        Nodo aux = nodo;

        while (aux != null) {
            System.out.println("Posição " + i + ": Matrícula: "
                    + aux.getEstudante().getMatricula() + " | Curso: " + aux.getEstudante().getCurso());
            aux = aux.getProximo();
            i++;
        }
        System.out.println("--- Fim da exibição ---");
    }

    @Override
    public int size() {
        if (isEmpty()) {
            return 0;
        } else if (this.inicio.getProximo() == null) {
            return 1;
        } else {
            Nodo aux = this.inicio;
            int count = 0;

            while (aux.getProximo() != null) {
                aux = aux.getProximo();
                count++;
            }
            return count;
        }
    }

    @Override
    public boolean isEmpty() {
        return this.inicio == null;
    }

    @Override
    public boolean containsKey(Object key) {

        if (this.inicio.getMatricula().equals(key)) {
            return true;
        } else {
            Nodo aux = this.inicio;

            while (aux.getProximo() != null) {
                if (aux.getMatricula().equals(key)) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public boolean containsValue(Object value) {

        if (this.inicio.getEstudante().equals(value)) {
            return true;
        } else {
            Nodo aux = this.inicio;

            while (aux.getProximo() != null) {
                if (aux.getEstudante().equals(value)) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public Estudante get(Object key) {

        if (this.inicio.getMatricula().equals(key)) {
            return this.inicio.getEstudante();
        } else {
            Nodo aux = this.inicio;

            while (aux.getProximo() != null) {
                if (aux.getMatricula().equals(key)) {
                    return aux.getEstudante();
                }
            }
        }
        return null;
    }

    @Override
    public Estudante put(Integer key, Estudante value) {
        Nodo nodo = new Nodo();

        nodo.setMatricula(key);
        nodo.setEstudante(value);

        if (this.inicio == null) {
            this.inicio = nodo;
        } else {
            Nodo aux = this.inicio;

            do {
                if (aux.getProximo() == null) {
                    aux.setProximo(nodo);
                    nodo.setAnterior(aux);
                    nodo.setProximo(null);
                    break;
                }
                aux = aux.getProximo();

            } while (aux != null);
        }
        return value;
    }

    @Override
    public Estudante remove(Object key) {
        Nodo aux = this.inicio;

        do {
            if (aux.getMatricula() <= Integer.parseInt(key.toString()) && aux == this.inicio) {
                this.inicio = aux.getProximo();
            } else if (aux.getMatricula() < Integer.parseInt(key.toString())) {
                aux.getAnterior().setProximo(aux.getProximo());
                aux.getProximo().setAnterior(aux.getAnterior());
            }
            aux = aux.getProximo();
        } while (aux != null);
        return null;

    }

    @Override
    public void putAll(Map<? extends Integer, ? extends Estudante> m) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void clear() {
        this.inicio = null;
        this.inicio.setProximo(null);
    }

    @Override
    public Set<Integer> keySet() {
        Set<Integer> keys = null;

        Nodo aux = this.inicio;
        while (aux.getProximo() != null) {
            keys.add(aux.getMatricula());
        }

        return keys;
    }

    @Override
    public Collection<Estudante> values() {
        Collection<Estudante> collectionEstudantes = null;
        Nodo aux = this.inicio;

        while (aux.getProximo() != null) {
            collectionEstudantes.add(aux.getEstudante());

        }
        return collectionEstudantes;
    }

    @Override
    public Set<Entry<Integer, Estudante>> entrySet() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
