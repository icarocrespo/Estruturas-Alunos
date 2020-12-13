package main;

import estruturas.vetor.Vetor;
import estruturas.arvore.Arvore;
import estruturas.lista.ListaDupla;

/**
 *
 * @author Ketrin | Jéssica | Marina
 */
public class Main {

    public static void main(String[] args) {
        // Chamada do método que exibe os dados referentes ao Vetor
        //vetor();
        
        // Chamada do método que exibe os dados referentes ao Lista Duplamente Encadeada
        lista();
        
        // Chamada do método que exibe os dados referentes ao Árvore Binária
        //arvore();
    }

    /*
     * Método de análise de inserção na ED Vetor
     */
    public static void vetor() {
        System.out.println("VETOR");
        Vetor vetor = new Vetor(100000);
        vetor.inserir();
        System.out.println("Tempo decorrido para inserção de 100.000 estudantes: " + vetor.getTempo_insercao() + "ms");
        vetor.mostrarCrescente();
        System.out.println("Tempo decorrido para ordenação crescente: " + vetor.getTempo_ordem() + "ms");
        vetor.contarES();
        System.out.println("Tempo decorrido para contagem dos estudantes de Engenharia de Software: " + vetor.getTempo_es() + "ms");
        vetor.remocaoNovo();
        System.out.println("Tempo decorrido para remoção dos estudantes com matrícula <= 20205000: " + vetor.getTempo_remocao() + "ms");
        System.out.println("--- || ---");
    }

    /*
     * Método de análise de inserção na ED Árvore Binária
     */
    public static void arvore() {
        System.out.println("ÁRVORE BINÁRIA");
        Arvore arvore = new Arvore();
        arvore.inserir();
        System.out.println("Tempo decorrido para inserção de 100.000 estudantes: " + arvore.getTempo_insercao() + "ms");
        arvore.mostrarCrescente();
        System.out.println("Tempo decorrido para ordenação crescente: " + arvore.getTempo_ordem() + "ms");
        arvore.contarES();
        System.out.println("Tempo decorrido para contagem dos estudantes de Engenharia de Software: " + arvore.getTempo_es() + "ms");
        arvore.remocao();
        System.out.println("Tempo decorrido para remoção dos estudantes com matrícula <= 20205000: " + arvore.getTempo_remocao() + "ms");
        System.out.println("--- || ---");
    }

    /*
     * Método de análise de inserção na ED Lista Duplamente Encadeada
     */
    public static void lista() {
        System.out.println("LISTA DUPLAMENTE ENCADEADA");
        ListaDupla lista = new ListaDupla(100000);
        lista.inserir();
        System.out.println("Tempo decorrido para inserção de 100.000 estudantes: " + lista.getTempo_insercao() + "ms");
        lista.mostrarCrescente();
        System.out.println("Tempo decorrido para ordenação crescente: " + lista.getTempo_ordem() + "ms");
        lista.contarES();
        System.out.println("Tempo decorrido para contagem dos estudantes de Engenharia de Software: " + lista.getTempo_es() + "ms");
        lista.remocao();
        System.out.println("Tempo decorrido para remoção dos estudantes com matrícula <= 20205000: " + lista.getTempo_remocao() + "ms");
        System.out.println("--- || ---");
    }
    
    public static double segundos(long tempo){
        return (double) tempo/1_000_000_000.0;
    }
}
