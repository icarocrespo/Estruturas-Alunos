package estruturas.lista;

import main.Estudante;

/**
 *
 * @author Ketrin | Jéssica | Marina
 */
public class Nodo {
    private Nodo anterior;
    private Nodo proximo;
    private Integer matricula;
    private Estudante estudante;

    public Nodo(Nodo anterior, Nodo proximo, Integer matricula, Estudante estudante) {
        this.anterior = anterior;
        this.proximo = proximo;
        this.matricula = matricula;
        this.estudante = estudante;
    }
    
    public Nodo(){
    
    }

    public Nodo getAnterior() {
        return anterior;
    }

    public void setAnterior(Nodo anterior) {
        this.anterior = anterior;
    }

    public Nodo getProximo() {
        return proximo;
    }

    public void setProximo(Nodo proximo) {
        this.proximo = proximo;
    }

    public Integer getMatricula() {
        return matricula;
    }

    public void setMatricula(Integer matricula) {
        this.matricula = matricula;
    }

    public Estudante getEstudante() {
        return estudante;
    }

    public void setEstudante(Estudante estudante) {
        this.estudante = estudante;
    }
    
}
