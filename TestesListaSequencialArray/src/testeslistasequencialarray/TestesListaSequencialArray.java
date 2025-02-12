// Aluno: João Henrique Alves de Sousa

package testeslistasequencialarray;

import java.util.Scanner;

public class TestesListaSequencialArray {
    private int[] dados;
    private int tamAtual;  // criação da lista vazia
    private int tamMax;

    public TestesListaSequencialArray() {
        tamMax = 100;
        tamAtual = 0;  // definição dos parâmetros
        dados = new int[tamMax];
    }

    public boolean listaVazia() {  // verifica se a lista está vazia
        return tamAtual == 0;
    }

    public boolean listaCheia() {  // verifica se a lista está cheia
        return tamAtual == tamMax;
    }

    public int obterElemento(int p) {  // obtém o valor do elemento
        if (p > tamAtual || p <= 0) {
            System.out.println("Lista vazia ou posicao invalida. Retorna erro!!!!\n");
            return -1;
        } else {
            return dados[p - 1];
        }
    }

    public int modificarElemento(int p, int novoValor) {  // modifica um elemento em uma posição determinada
        if (p > tamAtual || p <= 0) {
            System.out.println("Lista vazia ou posicao invalida. Retorna erro!!!!\n");
            return -1;
        } else {
            System.out.println("Valor atual: " + dados[p - 1] + " na posicao: " + p);
            dados[p - 1] = novoValor;
            return dados[p - 1];
        }
    }

    public int inserirElemento(int p, int valorElemento) {  // insere um elemento em uma posição válida
        if (listaCheia() || (p > tamAtual + 1) || (p <= 0)) {
            System.out.println("Lista cheia ou posicao invalida. Retorna erro!!!!\n");
            return -1;
        } else {
            for (int i = tamAtual; i >= p; i--) {
                dados[i] = dados[i - 1];
            }
            dados[p - 1] = valorElemento;
            tamAtual++;
            return 1;
        }
    }

    public int removerElemento(int p) {  // remove um elemento de uma posição válida
        if ((p > tamAtual) || (p < 1)) {
            System.out.println("Lista vazia ou posicao invalida. Retorna erro!!!!\n");
            return -1;
        } else {
            int valorDoElementoRemovido = dados[p - 1];
            for (int i = p - 1; i < tamAtual - 1; i++) {
                dados[i] = dados[i + 1];
            }
            tamAtual--;
            return valorDoElementoRemovido;
        }
    }

    public void imprimirLista() {       //imprime a lista
        if (tamAtual == 0) {
        } else {
            for (int i = 0; i < tamAtual; i++) {
                System.out.print(dados[i]);
                if (i < tamAtual - 1) {
                    System.out.print(", ");
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TestesListaSequencialArray lista = new TestesListaSequencialArray();
        System.out.println("Digite o numero do caso teste");
        System.out.println("Caso 1 lista vazia");
        System.out.println("Caso 2 lista cheia tamMax = 10 e tamAtual = 10 lista = {1,2,3,4,5,6,7,8,9,10}");
        System.out.println("Caso 3 tamMax = 10 e tamAtual = 5 lista = {1,2,3,4,5}");
        int n = scanner.nextInt();
        while (n != 1 && n != 2 && n != 3) {
            System.out.println("Numero invalido, tente novamente");
            n = scanner.nextInt();
        }
        switch (n) {
            case 1:
                lista.tamMax = 100;
                lista.tamAtual = 0;
                lista.dados = new int[lista.tamMax];
                break;
            case 2:
                lista.tamMax = 10;
                lista.tamAtual = 10;
                lista.dados = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
                break;
            case 3:
                lista.tamMax = 10;
                lista.tamAtual = 5;
                lista.dados = new int[]{1, 2, 3, 4, 5, 0, 0, 0, 0, 0};
                break;
            default:
                System.out.println("Caso de teste invalido.");
                return;
        }

        System.out.println("A lista sequencial tem um tamanho maximo de: " + lista.tamMax);
        System.out.println("A lista sequencial tem um tamanho atual de: " + lista.tamAtual);

        boolean v = lista.listaVazia();
        System.out.println("A lista esta vazia? " + v);

        boolean c = lista.listaCheia();
        System.out.println("A lista esta cheia? " + c);

        System.out.println("Tamanho atual da lista: " + lista.tamAtual);

        System.out.println("Digite a posicao do elemento da lista que deseja obter o valor.");
        int p = scanner.nextInt();
        int valor = lista.obterElemento(p);
        if (valor != -1)
            System.out.println("O valor do elemento na posicao: " + p + " e: " + valor);

        System.out.println("Digite a posicao do elemento da lista que deseja modificar. ");
        p = scanner.nextInt();
        System.out.println("Digite o novo valor para o elemento que deseja modificar.");
        int novoValor = scanner.nextInt();
        int valorModificado = lista.modificarElemento(p, novoValor);
        if (valorModificado != -1) {
            System.out.println("Novo valor: " + valorModificado + " na posicao: " + p);
            System.out.print("Lista = {"); lista.imprimirLista(); System.out.println("}");
        }

        System.out.println("Digite a posicao do elemento da lista que deseja inserir.");
        p = scanner.nextInt();
        System.out.println("Digite um valor para o elemento que deseja inserir.");
        int valorNovoElemento = scanner.nextInt();
        int novoElemento = lista.inserirElemento(p, valorNovoElemento);
        if (novoElemento != -1) {
            System.out.println("O novo elemento na posicao: " + p + " tem um valor de: " + valorNovoElemento);
            System.out.print("Lista = {"); lista.imprimirLista(); System.out.println("}");
        }

        System.out.println("Digite a posicao do elemento da lista que deseja remover.");
        p = scanner.nextInt();
        int valorDoElementoRemovido = lista.removerElemento(p);
        if (valorDoElementoRemovido != -1) {
            System.out.println("O elemento na posicao: " + p + " foi removido com sucesso.");
            System.out.print("Lista = {"); lista.imprimirLista(); System.out.println("}");
        }
    }
}
