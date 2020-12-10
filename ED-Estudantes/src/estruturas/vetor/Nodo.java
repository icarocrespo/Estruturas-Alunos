package estruturas.vetor;

import main.Estudante;

/**
 *
 * @author Ketrin | Jéssica | Marina Classe Vetor
 */
public class Nodo {
    
    private Integer matricula;
    private Estudante estudante;

   
    public Nodo(){
    
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
