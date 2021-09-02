package arvorebinaria;

import java.util.Scanner;

/**
 *
 * @author carol
 */
public class Principal {

    public static void main(String[] args) {
        ArvoreTAD arv = new ArvoreTAD();
        Scanner scan = new Scanner(System.in);

        int op = 0;

        while (op != 9) {

            System.out.println("MENU DE OPERAÇÕES:");
            System.out.println("1 - Imprime elementos da Árvore");
            System.out.println("2 - Insere elemento na Árvore");
            System.out.println("3 - Maior elemento da Árvore");
            System.out.println("4 - Menor elemento da Árvore");
            System.out.println("5 - Pesquisa por um elemento na Árvore");
            System.out.println("6 - Limpar a Árvore");
            System.out.println("9 - Sair");

            op = scan.nextInt();

            switch (op) {
                case 1:
                    int aux = 0;

                    while (aux != 9) {

                        System.out.println("\n \n");
                        System.out.println("1 - Imprime em pós-ordem");
                        System.out.println("2 - Imprime em pré-ordem");
                        System.out.println("3 - Imprime em ordem");
                        System.out.println("9 - Voltar ao menu");

                        aux = scan.nextInt();

                        System.out.println("\n \n");

                        switch (aux) {
                            case 1:
                                arv.imprimePosOrdem();
                                break;
                            case 2:
                                arv.imprimePreOrdem();
                                break;
                            case 3:
                                arv.imprimeEmOrdem();
                                break;
                            default:
                                System.out.println("Opção inválida!");
                                break;
                        }
                    }

                    break;

                case 2:
                    System.out.println("Digite o valor: ");
                    arv.insere(scan.nextInt());
                    break;
                    
                case 3:
                    System.out.println("Maior elemento da arvore: " + arv.acessaMaior());
                    break;
                    
                case 4:
                    System.out.println("Menor elemento da arvore: " + arv.acessaMenor());
                    break;
                    
                case 5:
                    System.out.println("Digite o valor: ");
                    boolean found = arv.pesquisa(scan.nextInt());

                    if (found) {
                        System.out.println("Elemento encontrado!");
                    } else {
                        System.out.println("Elemento não encontrado!");
                    }
                    break;
                    
                case 6:
                    arv.limpa();
                    break;
                    
                default:
                    System.out.println("Operação não encontrada!");
                    break;
            }

        }
    }
}
