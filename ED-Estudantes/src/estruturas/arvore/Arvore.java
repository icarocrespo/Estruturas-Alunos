package estruturas.arvore;

/**
 *
 * @author Ketrin | Jéssica | Marina
 * Classe Arvore com o atributo raiz do tipo Nodo 
 */
public class Arvore {
    // Atributo que define a raiz da Estrutura de Dados
    private Nodo raiz;

    public Arvore(Nodo raiz) {
        this.raiz = raiz;
    }
    
    public Arvore(){
    
    }
    
// Getters e Setters
    public Nodo getRaiz() {
        return raiz;
    }

    public void setRaiz(Nodo raiz) {
        this.raiz = raiz;
    }
    
    
}
