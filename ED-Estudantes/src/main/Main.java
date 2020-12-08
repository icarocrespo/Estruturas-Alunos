package main;

/**
 *
 * @author Ketrin | Jéssica | Marina
 */
public class Main {

    public static void main(String[] args) {
        Mapa mapa = new Mapa();
        mapa.popularMapa();
        
        
    }
    
    /*
     * Método de análise de inserção na ED Vetor
    */
    public void vetor10000(){
        System.out.println("Inserção de 10000 registros em Vetor");
    }
    
    /*
     * Método de análise de inserção na ED Árvore Binária
    */
    public void arvore10000(){
        System.out.println("Inserção de 10000 registros em Árvore Binária");
    }
    
    /*
     * Método de análise de inserção na ED Lista Duplamente Encadeada
    */
    public void lista10000(){
        System.out.println("Inserção de 10000 registros em Lista Duplamente Encadeada");
    }
}
