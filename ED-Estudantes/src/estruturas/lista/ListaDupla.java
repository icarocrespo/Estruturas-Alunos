package estruturas.lista;

import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import main.Estudante;
import main.Mapa;

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
    private int nElementos;

    public ListaDupla(Nodo inicio) {
        this.inicio = inicio;
        this.nElementos = 0;
    }

    public ListaDupla(Mapa mapa) {
        this.nElementos = mapa.getQuantidade();
    }
    
    public ListaDupla(){
    
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
    public void inserir(Mapa mapa){
        long tempo = System.nanoTime();
        
        Collection<Estudante> col = mapa.getEstudantes().values();
        Iterator<Estudante> it = col.iterator();
        Nodo nodo;
        
        while(it.hasNext()){
            if(this.inicio == null){
                nodo = new Nodo();
                this.inicio.setEstudante(it.next());
                this.inicio.setProximo(nodo);
            }else{
            
            }
        }
        this.tempo_insercao = System.nanoTime() - tempo;
    }
    
    // Apresentar todos os estudantes em ordem crescente de número de matricula
    public void mostrarCrescente(){
        long tempo = System.nanoTime();
        
        this.tempo_ordem = System.nanoTime() - tempo;
    }
    
    // Verificar quantos estudantes realizam o curso Engenharia de Software
    public int contarES(){
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
    public void remocao(){
        long tempo = System.nanoTime();
        
        this.tempo_remocao = System.nanoTime() - tempo;
    }
}
