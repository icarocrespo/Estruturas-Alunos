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
        Vetor vetor = new Vetor(100000);
        ListaDupla listaDupla = new ListaDupla(100000);
        Arvore arvore = new Arvore(100000);

        // Análise de inserção
        insercao(vetor, listaDupla, arvore);

        // Análise de ordenação
        ordenacao(vetor, listaDupla);

        // Análise de contagem
        contarES(vetor, listaDupla, arvore);

        // Análise de remoção
        remocao(vetor, listaDupla, arvore);

        // Chamada do método que exibe os dados referentes ao Vetor
        //vetor();
        // Chamada do método que exibe os dados referentes ao Lista Duplamente Encadeada
        //lista();
        // Chamada do método que exibe os dados referentes ao Árvore Binária
        //arvore();
    }

    /*
     * Método de análise da inserção de 100.000 estudantes
     */
    public static void insercao(Vetor vetor, ListaDupla listaDupla, Arvore arvore) {
        System.out.println("INSERÇÃO DE 100.000 ESTUDANTES");
        vetor.inserir();
        System.out.println("Vetor | Tempo decorrido: " + vetor.getTempo_insercao() + "ms");
        listaDupla.inserir();
        System.out.println("Lista duplamente encadeada | Tempo decorrido: " + listaDupla.getTempo_insercao() + "ms");
        arvore.inserir();
        System.out.println("Árvore binária | Tempo decorrido: " + arvore.getTempo_insercao() + "ms");
        System.out.println("");
    }

    /*
     * Método de análise da ordenação crescente
     */
    public static void ordenacao(Vetor vetor, ListaDupla listaDupla) {
        System.out.println("ORDENAÇÃO CRESCENTE");
        System.out.println("");
        vetor.ordenar();
        listaDupla.ordenar();
        System.out.println("-- Mostrando Vetor --");
        vetor.mostrar();
        System.out.println("Mostrando Lista duplamente encadeada");
        listaDupla.mostrar();
        System.out.println("Vetor | Tempo decorrido: " + vetor.getTempo_ordem() + "ms");
        System.out.println("Lista duplamente encadeada | Tempo decorrido: " + listaDupla.getTempo_ordem() + "ms");
        System.out.println("");
    }

    /*
     * Método de contagem dos estudantes de Engenharia de Software
     */
    public static void contarES(Vetor vetor, ListaDupla listaDupla, Arvore arvore) {
        System.out.println("CONTAGEM DOS ESTUDANTES DE ENGENHARIA DE SOFTWARE");
        vetor.contarES();
        System.out.println("Vetor | Tempo decorrido dos " + vetor.getEstudantesES() + " estudantes: " + vetor.getTempo_es() + "ms");
        listaDupla.contarES();
        System.out.println("Lista duplamente encadeada | Tempo decorrido dos " + listaDupla.getEstudantesES() + " estudantes: " + listaDupla.getTempo_es() + "ms");
        arvore.contarES();
        System.out.println("Árvore binária | Tempo decorrido dos "
                + arvore.getEstudantesES() + " estudantes: " + arvore.getTempo_es() + "ms");
    }

    /*
     * Método de análise da remoção de estudantes com matrícula <= 202050000
     */
    public static void remocao(Vetor vetor, ListaDupla listaDupla, Arvore arvore) {
        System.out.println("REMOÇÃO ESTUDANTES <= 202050000");
        vetor.remocaoNovo();
        System.out.println("Vetor | Tempo decorrido: " + vetor.getTempo_remocao() + "ms");
        listaDupla.remocao();
        System.out.println("Lista duplamente encadeada | Tempo decorrido: " + listaDupla.getTempo_remocao() + "ms");
        arvore.remocao();
        System.out.println("Árvore binária | Tempo decorrido: " + arvore.getTempo_remocao() + "ms");
        System.out.println("");
    }

    /*
     * Método de análise da ED Vetor
     */
    public static void vetor() {
        System.out.println("VETOR");
        Vetor vetor = new Vetor(100000);
        vetor.inserir();
        System.out.println("Tempo decorrido para inserção de 100.000 estudantes: " + vetor.getTempo_insercao() + "ms");
        vetor.ordenar();
        vetor.mostrar();
        System.out.println("Tempo decorrido para ordenação crescente: " + vetor.getTempo_ordem() + "ms");
        vetor.contarES();
        System.out.println("Tempo decorrido para contagem dos estudantes de Engenharia de Software: " + vetor.getTempo_es() + "ms");
        vetor.remocaoNovo();
        System.out.println("Tempo decorrido para remoção dos estudantes com matrícula <= 20205000: " + vetor.getTempo_remocao() + "ms");
        System.out.println("--- || ---");
    }

    /*
     * Método de anális da ED Árvore Binária
     */
    public static void arvore() {
        System.out.println("Árvore binária");
        Arvore arvore = new Arvore(100000);
        arvore.inserir();
        System.out.println("Tempo decorrido para inserção de 100.000 estudantes: " + arvore.getTempo_insercao() + "ms");
        arvore.mostrarCrescente();
        System.out.println("Tempo decorrido para mostrar crescente: " + arvore.getTempo_ordem() + "ms");
        arvore.contarES();
        System.out.println("Tempo decorrido para contagem dos estudantes de Engenharia de Software ("
                + arvore.getEstudantesES() + ") : " + arvore.getTempo_es() + "ms");
        arvore.remocao();
        System.out.println("Tempo decorrido para remoção dos estudantes com matrícula <= 20205000: " + arvore.getTempo_remocao() + "ms");
        System.out.println("--- || ---");
    }

    /*
     * Método de análise da ED Lista Duplamente Encadeada
     */
    public static void lista() {
        System.out.println("Lista duplamente encadeada");
        ListaDupla lista = new ListaDupla(100000);
        lista.inserir();
        System.out.println("Tempo decorrido para inserção de 100.000 estudantes: " + lista.getTempo_insercao() + "ms");
        lista.ordenar();
        lista.mostrar();
        System.out.println("Tempo decorrido para ordenação crescente: " + lista.getTempo_ordem() + "ms");
        lista.contarES();
        System.out.println("Tempo decorrido para contagem dos " + lista.getEstudantesES() + " estudantes de Engenharia de Software: " + lista.getTempo_es() + "ms");
        lista.remocao();
        System.out.println("Tempo decorrido para remoção dos estudantes com matrícula <= 20205000: " + lista.getTempo_remocao() + "ms");
        System.out.println("--- || ---");
    }

    public static double segundos(long tempo) {
        return (double) tempo / 1_000_000_000.0;
    }
}
