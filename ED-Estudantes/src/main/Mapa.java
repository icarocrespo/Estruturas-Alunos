package main;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Ketrin | Jéssica | Marina
 * Possui a matrícula do aluno como chave e Curso como valor
 */
public class Mapa {

    private Map<Integer, Estudante> estudantes;
    
    public Mapa() {
        estudantes = new HashMap<>();
    }

    public Map<Integer, Estudante> getEstudantes() {
        return estudantes;
    }

    public void setEstudantes(Map<Integer, Estudante> estudantes) {
        this.estudantes = estudantes;
    }

    /*
     * adição de estudantes ao Mapa
     */
    public void popularMapa() {
        Estudante estudante;

        for (int i = 0; i < 100; i++) {
            estudante = new Estudante();
            this.estudantes.put(estudante.getMatricula(), estudante);
        }
    }   
}