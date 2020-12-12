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

    public ListaDupla(Nodo inicio) {
        this.inicio = inicio;
        this.nElementos = 0;
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

//        Collection<Estudante> col = mapa.getEstudantes().values();
//        Iterator<Estudante> it = col.iterator();
//        Nodo nodo;
//        
//        while(it.hasNext()){
//            if(this.inicio == null){
//                nodo = new Nodo();
//                this.inicio.setEstudante(it.next());
//                this.inicio.setProximo(nodo);
//            }else{
//            
//            }
//        }
        this.tempo_insercao = System.nanoTime() - tempo;
    }

    // Apresentar todos os estudantes em ordem crescente de número de matricula
    public void mostrarCrescente() {
        long tempo = System.nanoTime();

        this.tempo_ordem = System.nanoTime() - tempo;
    }

    // Verificar quantos estudantes realizam o curso Engenharia de Software
    public int contarES() {
        long tempo = System.nanoTime();
        int count = 0;

        Nodo atual = this.inicio;
        while (atual.getProximo() != null) {
            if (atual.getEstudante().getCurso().equals("Engenharia de Software")) {
                count++;
            }
        }
        this.tempo_es = System.nanoTime() - tempo;
        return count;
    }

    // Remover todos os estudantes com número de matricula igual ou inferior a 202050000
    public void remocao() {
        long tempo = System.nanoTime();

        this.tempo_remocao = System.nanoTime() - tempo;
    }

    @Override
    public int size() {
        Nodo aux = this.inicio;
        int count = 0;

        while (aux.getProximo() != null) {
            aux = aux.getProximo();
            count++;
        }

        return count;
    }

    @Override
    public boolean isEmpty() {
        return this.inicio == null;
    }

    @Override
    public boolean containsKey(Object key) {
        Nodo aux = this.inicio;

        while (aux.getProximo() != null) {
            if (aux.getMatricula().equals(key)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean containsValue(Object value) {
        Nodo aux = this.inicio;

        while (aux.getProximo() != null) {
            if (aux.getEstudante().equals(value)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public Estudante get(Object key) {
        Nodo aux = this.inicio;

        while (aux.getProximo() != null) {
            if (aux.getMatricula().equals(key)) {
                return aux.getEstudante();
            }
        }
        return null;
    }

    @Override
    public Estudante put(Integer key, Estudante value) {
        Nodo nodo = new Nodo();
        Nodo aux = this.inicio;

        nodo.setMatricula(key);
        nodo.setEstudante(value);

        while (aux.getProximo() != null) {
            if (aux.getProximo() == null) {
                aux.setProximo(nodo);
                aux.getProximo().setAnterior(aux);
            }
        }
        return value;
    }

    @Override
    public Estudante remove(Object key) {
        Nodo aux = this.inicio;

        while (aux.getProximo() != null) {
            if (aux.getMatricula().equals(key)) {
                aux.getAnterior().setProximo(aux.getProximo());
                aux.getProximo().setAnterior(aux.getAnterior());
            }
        }
        return aux.getEstudante();
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
