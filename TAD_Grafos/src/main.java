/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author carol
 */
public class main {

    public static void main(String[] args) {
      
        GrafoTAD grafo = new GrafoTAD(8, false);
        GrafoTAD digrafo = new GrafoTAD(6, true);
        
        //Dígrafo
        
        digrafo.insereAresta(0, 2);
        digrafo.insereAresta(1, 2);
        digrafo.insereAresta(1, 4);
        digrafo.insereAresta(2, 4);
        digrafo.insereAresta(3, 2);
        digrafo.insereAresta(3, 5);
        digrafo.insereAresta(5, 4);
        
        //Testes
        //digrafo.imprimeListaAdj();
        //digrafo.percursoLargura(0);
        //digrafo.percursoProfundidade(0);
        
        //Grafo
        
        grafo.insereAresta(0, 1);
        grafo.insereAresta(5, 1);
        grafo.insereAresta(5, 2);
        grafo.insereAresta(1, 2);
        grafo.insereAresta(2, 3);
        grafo.insereAresta(2, 4);
        grafo.insereAresta(2, 6);
        grafo.insereAresta(3, 4);
        grafo.insereAresta(6, 7);
        
        //Testes
        //grafo.imprimeListaAdj();
        //grafo.percursoLargura(0);
        //grafo.percursoProfundidade(0);
    }
    
}
