package estruturas.lista;

/**
 *
 * @author Ketrin | Jéssica | Marina
 * Classe ListaDupla com atributo início do tipo Nodo
 */
public class ListaDupla {

    // Atributo de início/fim da lista duplamente encadeada
    private Nodo inicio;

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

}
