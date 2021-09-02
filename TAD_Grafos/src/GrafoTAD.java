
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author carol
 */
public class GrafoTAD {

    LinkedList<Integer>[] adj;
    int num_vertices;
    boolean eh_dirigido;

    public GrafoTAD(int num_vertices, boolean eh_dirigido) {
        this.num_vertices = num_vertices;
        this.eh_dirigido = eh_dirigido;

        this.adj = new LinkedList[num_vertices];

        for (int i = 0; i < num_vertices; i++) {
            this.adj[i] = new LinkedList<>();
        }
    }

    public void insereAresta(int v0, int v1) {
        this.adj[v0].add(v1);

        if (!this.eh_dirigido) {
            this.adj[v1].add(v0);
        }
    }

    public void imprimeListaAdj() {
        for (int i = 0; i < this.num_vertices; i++) {
            System.out.println(i + " : " + adj[i]);
        }
    }

    public void percursoLargura(int vertInic) {
        Queue<Integer> fila = new LinkedList<>();
        boolean[] bol = new boolean[this.num_vertices];

        for (int i = 0; i < this.num_vertices; i++) {
            bol[i] = false;
        }

        fila.add(vertInic);
        bol[vertInic] = true;

        while (!fila.isEmpty()) {
            int vertice = fila.poll();
            System.out.println(vertice);

            for (int vert_adj : this.adj[vertice]) {
                if (!bol[vert_adj]) {
                    fila.add(vert_adj);
                    bol[vert_adj] = true;
                }
            }
        }
    }

    public void percursoProfundidade(int vertInic) {
        Stack<Integer> pilha = new Stack();
        boolean[] bol = new boolean[this.num_vertices];

        for (int i = 0; i < this.num_vertices; i++) {
            bol[i] = false;
        }

        pilha.push(vertInic);
        bol[vertInic] = true;

        while (!pilha.isEmpty()) {
            int vertice = pilha.pop();
            System.out.println(vertice);

            for (int vert_adj : this.adj[vertice]) {
                if (!bol[vert_adj]) {
                    pilha.push(vert_adj);
                    bol[vert_adj] = true;
                }
            }
        }
    }
}
