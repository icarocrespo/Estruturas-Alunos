package estruturas.arvore;

import main.Estudante;

/**
 *
 * @author Ketrin | Jéssica | Marina
 */
public class Nodo{
    private Nodo esquerda;
    private Nodo direita;
    private Estudante estudante;

    public Nodo(Nodo esquerda, Nodo direita, Estudante estudante) {
        this.esquerda = esquerda;
        this.direita = direita;
        this.estudante = estudante;
    }
    
    public Nodo(){
    
    }

    public Nodo getEsquerda() {
        return esquerda;
    }

    public void setEsquerda(Nodo esquerda) {
        this.esquerda = esquerda;
    }

    public Nodo getDireita() {
        return direita;
    }

    public void setDireita(Nodo direita) {
        this.direita = direita;
    }

    public Estudante getEstudante() {
        return estudante;
    }

    public void setEstudante(Estudante estudante) {
        this.estudante = estudante;
    }
}
