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
    private long tempo_ordem;
    private long tempo_es;
    private long tempo_remocao;

    public Arvore(Nodo raiz) {
        this.raiz = raiz;
    }

    public Arvore() {

    }

// Getters e Setters
    public Nodo getRaiz() {
        return raiz;
    }

    public void setRaiz(Nodo raiz) {
        this.raiz = raiz;
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

// Métodos aos requisitos
    // Inserir 100.000 (cem mil) estudantes
    public void inserir() {
        long tempo = System.nanoTime();
        for (int i = 0; i < 100000; i++) {
            Estudante estudante = new Estudante();
            put(estudante.getMatricula(), estudante);
        }
        this.tempo_insercao = System.nanoTime() - tempo;
    }

    // Apresentar todos os estudantes em ordem crescente de número de matricula
    public void mostrarCrescente() {
        long tempo = System.nanoTime();
        mostrar(this.raiz);
        this.tempo_ordem = System.nanoTime() - tempo;
    }

    public void contarES() {
        long tempo = System.nanoTime();
        int count = 0;
        System.out.println(contar(this.raiz, count));
        this.tempo_es = System.nanoTime() - tempo;
    }

    // Verificar quantos estudantes realizam o curso Engenharia de Software
    public int contar(Nodo nodo, int count) {
        if (nodo == null) {
            return 0; 
        }
        if(nodo.getEstudante().isCursoES()){
            count++;
        }
        
        contar(nodo.getEsquerda(), count);
        contar(nodo.getDireita(), count);
        
        return count;
    }

    // Remover todos os estudantes com número de matricula igual ou inferior a 202050000
    public void remocao() {
        long tempo = System.nanoTime();

        while (remove(get(202050000)) != null) {

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

    public Estudante remove(Nodo nodo, Integer matricula) {
        if (nodo == null) {
            return nodo.getEstudante();
        }

        if (matricula < nodo.getMatricula()) {
            nodo.getEsquerda().setEstudante(remove(nodo.getEsquerda(), matricula));
            nodo.getDireita().setMatricula(matricula);
        } else if (matricula > nodo.getMatricula()) {
            nodo.getDireita().setMatricula(matricula);
            nodo.getDireita().setEstudante(remove(nodo.getDireita(), matricula));
        } else {

            if (nodo.getEsquerda() == null) {
                return nodo.getDireita().getEstudante();
            } else if (nodo.getDireita().getEstudante() == null) {
                return nodo.getEsquerda().getEstudante();
            }

            nodo.setMatricula(valorMenor(nodo.getDireita()).getMatricula());
            nodo.getDireita().setEstudante(nodo.getEstudante());
        }
        return nodo.getEstudante();
    }

    public Nodo valorMenor(Nodo nodo) {
        Nodo menor = this.raiz;
        while (menor.getEsquerda() != null) {
            menor = nodo.getEsquerda();
            nodo = nodo.getEsquerda();
        }
        return nodo;
    }

    @Override
    public Estudante remove(Object key) {
        return remove(this.raiz, (Integer) key);
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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Nodo percorrer(Nodo nodo) {
        if (nodo != null) {
            return nodo;
        }
        percorrer(nodo.getEsquerda());
        percorrer(nodo.getDireita());
        return null;
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
