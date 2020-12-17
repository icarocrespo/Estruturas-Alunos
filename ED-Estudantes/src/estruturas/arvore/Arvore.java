package estruturas.arvore;

import java.util.Collection;
import java.util.Map;
import java.util.Set;
import main.Estudante;

/**
 *
 * @author Ketrin | Jéssica | Marina Classe Arvore com o atributo raiz do tipo
 * Nodo tempo_insercao -> Tempo para inserção de 100.000 estudantes tempo_ordem
 * -> Tempo para ordenamento crescente, por número de matrícula, dos estudantes
 * tempo_es -> Tempo para verificar o quantitativo de estudantes de Engenharia
 * de Software tempo_remocao -> Tempo para remoção de estudantes com matrícula
 * <= 20205000
 */
public class Arvore implements Map<Integer, Estudante> {

    // Atributo que define a raiz da Estrutura de Dados
    private Nodo raiz;
    private long tempo_insercao;
    private long tempo_mostrar;
    private long tempo_es;
    private long tempo_remocao;
    private int nElementos;
    private int estudantesES = 0;

    public Arvore(Nodo raiz, int nElementos) {
        this.raiz = raiz;
        this.nElementos = nElementos;
    }

    public Arvore(int nElementos) {
        this.nElementos = nElementos;
    }

    public Arvore() {
        this.raiz = null;
        this.nElementos = 0;
    }

// Getters e Setters
    public Nodo getRaiz() {
        return raiz;
    }

    public void setRaiz(Nodo raiz) {
        this.raiz = raiz;
    }

    public int getnElementos() {
        return nElementos;
    }

    public void setnElementos(int nElementos) {
        this.nElementos = nElementos;
    }

    public int getEstudantesES() {
        return estudantesES;
    }

    public void setEstudantesES(int estudantesES) {
        this.estudantesES = estudantesES;
    }

    public long getTempo_insercao() {
        return tempo_insercao;
    }

    public void setTempo_insercao(long tempo_insercao) {
        this.tempo_insercao = tempo_insercao;
    }

    public long getTempo_mostrar() {
        return tempo_mostrar;
    }

    public void setTempo_mostrar(long tempo_mostrar) {
        this.tempo_mostrar = tempo_mostrar;
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

// Métodos aos requisitos
    // Inserir 100.000 (cem mil) estudantes
    public void inserir() {
        long tempo = System.nanoTime();
        for (int i = 0; i < this.nElementos; i++) {
            Estudante estudante = new Estudante();
            put(estudante.getMatricula(), estudante);
        }
        this.tempo_insercao = System.nanoTime() - tempo;
    }

    // Apresentar todos os estudantes em ordem crescente de número de matricula
    public void mostrarCrescente() {
        long tempo = System.nanoTime();
        mostrar(this.raiz);
        this.tempo_mostrar = System.nanoTime() - tempo;
    }

    public void contarES() {
        long tempo = System.nanoTime();
        contar(this.raiz);
        this.tempo_es = System.nanoTime() - tempo;
    }

    // Verificar quantos estudantes realizam o curso Engenharia de Software
    public int contar(Nodo nodo) {
        if (nodo == null) {
            return 0;
        }
        if (nodo.getEstudante().isCursoES()) {
            this.estudantesES++;
        }

        contar(nodo.getEsquerda());
        contar(nodo.getDireita());

        return this.estudantesES;
    }

    // Remover todos os estudantes com número de matricula igual ou inferior a 202050000
    public void remocao() {
        long tempo = System.nanoTime();

        for (int i = 0; i < 100000; i++) {
            
            remove(menor202050000(this.raiz).getMatricula());
        }

        this.tempo_remocao = System.nanoTime() - tempo;
    }

    // Mostrar o Nodo
    public void mostrar(Nodo nodo) {
        if (nodo != null) {
            System.out.println("Matrícula: " + nodo.getEstudante().getMatricula()
                    + " | Curso: " + nodo.getEstudante().getCurso());
            mostrar(nodo.getEsquerda());
            mostrar(nodo.getDireita());
        }
    }

    public Nodo menor202050000(Nodo nodo) {
        if (nodo.getMatricula() < 202050000) {
            return nodo;
        } else if (nodo.getMatricula() > 202050000) {
            return menor202050000(nodo.getEsquerda());
        } else {
            return menor202050000(nodo.getDireita());
        }
    }

    // Método recursivo para calcular o tamanho
    public int size(Nodo nodo) {
        if (nodo == null) {
            return 0;
        } else {
            return size(nodo.getEsquerda()) + 1 + size(nodo.getDireita());
        }
    }

    @Override
    public int size() {
        return size(this.raiz);
    }

    @Override
    public boolean isEmpty() {
        return raiz.getEsquerda() == null && raiz.getDireita() == null;
    }

    // Método recursivo para informar se há uma determinada matrícula (chave)
    public boolean containsKey(Nodo nodo, Integer matricula) {
        if (nodo.getMatricula().equals(matricula)) {
            return true;
        } else if (nodo.getMatricula() > matricula) {
            return containsKey(nodo.getEsquerda(), matricula);
        } else {
            return containsKey(nodo.getDireita(), matricula);
        }
    }

    @Override
    public boolean containsKey(Object key) {
        return containsKey(this.raiz, (Integer) key);
    }

    // Método recursivo para informar se há um determinado estudante
    public boolean containsValue(Nodo nodo, Estudante estudante) {
        if (nodo.getEstudante().equals(estudante)) {
            return true;
        } else if (nodo.getMatricula() > estudante.getMatricula()) {
            return containsValue(nodo.getEsquerda(), estudante);
        } else {
            return containsValue(nodo.getDireita(), estudante);
        }
    }

    @Override
    public boolean containsValue(Object value) {
        return containsValue(this.raiz, (Estudante) value);
    }

    // Método recursivo para pegar um estudante
    public Estudante get(Nodo nodo, Integer matricula) {
        if (nodo == null || nodo.getMatricula().equals(matricula)) {
            return nodo.getEstudante();
        } else if (nodo.getMatricula() > matricula) {
            return get(nodo.getEsquerda(), matricula);
        } else {
            return get(nodo.getDireita(), matricula);
        }
    }

    @Override
    public Estudante get(Object key) {
        return get(this.raiz, (Integer) key);
    }

    public Nodo put(Nodo nodo, Integer matricula, Estudante estudante) {
        if (nodo == null) {
            Nodo aux = new Nodo(null, null, matricula, estudante);
            if (this.raiz == null) {
                this.raiz = aux;
            }
            return aux;
        }
        if (matricula < nodo.getMatricula()) {
            nodo.setEsquerda(put(nodo.getEsquerda(), matricula, estudante));
        } else if (matricula > nodo.getMatricula()) {
            nodo.setDireita(put(nodo.getDireita(), matricula, estudante));
        }
        return nodo;
    }

    @Override
    public Estudante put(Integer key, Estudante value) {
        return put(this.raiz, key, value).getEstudante();
    }

    public Nodo remove(Nodo nodo, Integer matricula) {
        if (nodo == null) {
            return nodo;
        }

        if (matricula < nodo.getMatricula()) {
            nodo.setEsquerda(remove(nodo.getEsquerda(), matricula));
        } else if (matricula > nodo.getMatricula()) {
            nodo.setDireita(remove(nodo.getDireita(), matricula));

        } else {

            if (nodo.getEsquerda() == null) {
                return nodo.getDireita();
            } else if (nodo.getDireita() == null) {
                return nodo.getEsquerda();
            }

            matricula = valorMenor(nodo.getDireita());
            nodo.setDireita(remove(nodo.getDireita(), matricula));
        }
        return nodo;
    }

    public int valorMenor(Nodo nodo) {
        int menor = this.raiz.getMatricula();
        while (nodo.getEsquerda() != null) {
            menor = nodo.getEsquerda().getMatricula();
            nodo = nodo.getEsquerda();
        }
        return menor;
    }

    @Override
    public Estudante remove(Object key) {
        return remove(this.raiz, (Integer) key).getEstudante();
    }

    @Override
    public void putAll(Map<? extends Integer, ? extends Estudante> m) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void clear() {
        this.raiz = null;
    }

    @Override
    public Set<Integer> keySet() {
        Set<Integer> keys = null;

        keys.add(percorrer(raiz).getMatricula());

        return keys;
    }

    public Nodo percorrer(Nodo nodo) {
        if (nodo != null) {
            return null;
        }
        percorrer(nodo.getEsquerda());
        percorrer(nodo.getDireita());
        return nodo;
    }

    @Override
    public Collection<Estudante> values() {
        Collection<Estudante> collectionEstudantes = null;

        collectionEstudantes.add(percorrer(this.raiz).getEstudante());
        return collectionEstudantes;
    }

    @Override
    public Set<Entry<Integer, Estudante>> entrySet() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
