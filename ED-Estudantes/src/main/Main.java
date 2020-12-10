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

        // Chamada do método que exibe os dados referentes ao Árvore Binária
        //arvore(mapa);
        // Chamada do método que exibe os dados referentes ao Lista Duplamente Encadeada
        //lista(mapa);
    }

    /*
     * Método de análise de inserção na ED Vetor
     */
    public static void vetor() {
        System.out.println("VETOR");
        Vetor vetor = new Vetor();
        
        System.out.println("Tempo decorrido para inserção de 100.000 registros em Lista Duplamente Encadeada: " + vetor.getTempo_insercao() + "ms");
        //vetor.mostrarCrescente();
        System.out.println("Tempo decorrido para ordenação da Lista Duplamente Encadeada: " + vetor.getTempo_ordem() + "ms");
        vetor.contarES();
        System.out.println("Tempo decorrido para contagem dos estudandantes de Engenharia de Software: " + vetor.getTempo_es() + "ms");
        //vetor.remocaoNovo();
        System.out.println("Tempo decorrido para remoção dos estudantes com matrícula <= 20205000: " + vetor.getTempo_remocao() + "ms");
    }

    /*
     * Método de análise de inserção na ED Árvore Binária
     */
    public static void arvore() {
        Arvore arvore = new Arvore();
        System.out.println("Tempo decorrido para inserção de 100.000 registros na Árvore Binária: " + arvore.getTempo_insercao() + "ms");

        System.out.println("Tempo decorrido para ordenação da Árvore Binária: " + arvore.getTempo_ordem() + "ms");

        System.out.println("Tempo decorrido para contagem dos estudandantes de Engenharia de Software: " + arvore.getTempo_es() + "ms");

        System.out.println("Tempo decorrido para remoção dos estudantes com matrícula <= 20205000: " + arvore.getTempo_remocao() + "ms");
    }

    /*
     * Método de análise de inserção na ED Lista Duplamente Encadeada
     */
    public static void lista() {
        ListaDupla lista = new ListaDupla();
        System.out.println("Tempo decorrido para inserção de 100.000 registros na Lista Duplamente Encadeada: " + lista.getTempo_insercao() + "ms");

        System.out.println("Tempo decorrido para ordenação da Lista Duplamente Encadeada: " + lista.getTempo_ordem() + "ms");

        System.out.println("Tempo decorrido para contagem dos estudandantes de Engenharia de Software: " + lista.getTempo_es() + "ms");

        System.out.println("Tempo decorrido para remoção dos estudantes com matrícula <= 20205000: " + lista.getTempo_remocao() + "ms");
    }
}
