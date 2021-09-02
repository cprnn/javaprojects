package arvorebinaria;

public class Nodo {
    public int elem;
    public Nodo esq, dir;
    
    public Nodo(int elem) {
        this.elem = elem;
        this.esq = null;
        this.dir = null;
    }
}
