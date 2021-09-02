package arvorebinaria;

public class ArvoreTAD {

    private Nodo raiz;

    public ArvoreTAD() {
        this.raiz = null;
    }

    public int tamanho() {
        return this.tamanhoRec(this.raiz);
    }

    private int tamanhoRec(Nodo nod) {
        if (nod == null) {
            return 0;
        } else {
            return this.tamanhoRec(nod.esq) + 1 + this.tamanhoRec(nod.dir);
        }
    }

    public boolean ehVazia() {
        return this.raiz == null;
    }

    public void insere(int elem) {
        this.insereRec(elem, this.raiz);
    }

    private void insereRec(int elem, Nodo nod) {
        if (this.raiz == null) {
            Nodo novo = new Nodo(elem);
            this.raiz = novo;
        } else if (elem == nod.elem) {
            throw new UnsupportedOperationException("Este elemento está duplicado.");
        } else if (elem < nod.elem) {
            if (nod.esq == null) {
                Nodo novo = new Nodo(elem);
                nod.esq = novo;
            } else {
                this.insereRec(elem, nod.esq);
            }
        } else if (elem > nod.elem) {
            if (nod.dir == null) {
                Nodo novo = new Nodo(elem);
                nod.dir = novo;
            } else {
                this.insereRec(elem, nod.dir);
            }
        }
    }

    public void imprimeEmOrdem() {
        imprimeEmOrdemRec(this.raiz);
    }

    private void imprimeEmOrdemRec(Nodo nod) {
        if (nod == null) {
            return;
        } else {
            imprimeEmOrdemRec(nod.esq);
            System.out.println(nod.elem);
            imprimeEmOrdemRec(nod.dir);
        }
    }

    public void imprimePreOrdem() {
        imprimePreOrdemRec(this.raiz);
    }

    private void imprimePreOrdemRec(Nodo nod) {
        if (nod == null) {
        } else {
            System.out.println(nod.elem);
            imprimePreOrdemRec(nod.esq);
            imprimePreOrdemRec(nod.dir);
        }
    }

    public void imprimePosOrdem() {
        imprimePosOrdemRec(this.raiz);
    }

    private void imprimePosOrdemRec(Nodo nod) {
        if (nod == null) {
            System.out.println("Nodo vazio.");
        } else {
            imprimePosOrdemRec(nod.esq);
            imprimePosOrdemRec(nod.dir);
            System.out.println(nod.elem);
        }
    }

    public void remove(int elem) {
        this.raiz = this.removeRec(elem, this.raiz);
    }

    public Nodo removeRec(int elem, Nodo n) {
        if (n == null) {
            return null;
        } else if (elem == n.elem) {
            if (n.esq == null && n.dir == null) {
                return null;
            } else if (n.esq == null) {
                return n.dir;
            } else if (n.dir == null) {
                return n.esq;
            } else {
                Nodo aux = n.dir;
                while (aux.esq != null) {
                    aux = aux.esq;
                }
                n.elem = aux.elem;
                n.dir = this.removeRec(aux.elem, n.dir);
            }
        } else if (elem < n.elem) {
            n.esq = this.removeRec(elem, n.esq);
        } else {
            n.dir = this.removeRec(elem, n.dir);
        }
        return n;
    }

    public boolean pesquisa(int elem) {
        return pesquisaRec(elem, this.raiz);
    }

    private boolean pesquisaRec(int elem, Nodo n) {
        if (n == null) {
            return false;
        } else if (elem == n.elem) {
            return true;
        } else if (elem < n.elem) {
            return this.pesquisaRec(elem, n.esq);
        } else if (elem > n.elem) {
            return this.pesquisaRec(elem, n.dir);
        } else {
            return false;
        }
    }

    public int acessaMenor() {
        return acessaMenorRec(this.raiz);
    }

    public int acessaMenorRec(Nodo nod) {
        if (nod == null) {
            System.out.println("Exception: nodo vazio.");
            return Integer.MAX_VALUE;
        } else {
            int menor = nod.elem;
            int esqMin = this.acessaMenorRec(nod.esq);
            int dirMin = this.acessaMenorRec(nod.dir);

            if (esqMin < menor) {
                menor = esqMin;
            } else if (dirMin < menor) {
                menor = dirMin;
            }
            return menor;
        }
    }

    public int acessaMaior() {
        return acessaMaiorRec(this.raiz);
    }

    public int acessaMaiorRec(Nodo nod) {
        if (nod == null) {
            System.out.println("Exception: nodo vazio.");
            return Integer.MIN_VALUE;
        } else {
            int maior = nod.elem;
            int esqMax = this.acessaMaiorRec(nod.esq);
            int dirMax = this.acessaMaiorRec(nod.dir);

            if (esqMax > maior) {
                maior = esqMax;
            } else if (dirMax > maior) {
                maior = dirMax;
            }
            return maior;
        }
    }

    public void limpa() {
        this.limpaRec(this.raiz);
    }

    public void limpaRec(Nodo nod) {
        if (nod == null) {
            return;
        } else {
            limpaRec(nod.esq);
            limpaRec(nod.dir);
            nod = null;
        }
    }

    public void imprimeFormatoArvore() {
        this.imprimeFormatoArvore(this.raiz, 0);
    }

    private void imprimeFormatoArvore(Nodo n, int nivel) {
        if (n != null) {
            this.imprimeFormatoArvore(n.dir, nivel + 1);
            for (int i = 0; i < nivel; i++) {
                System.out.print("  ");
            }
            System.out.println(n.elem);
            this.imprimeFormatoArvore(n.esq, nivel + 1);
        }
    }

}
