package estoque;

import java.util.Scanner;

import produto.ListaProduto;
import produto.Produto;

public class Estoque {
    private static Scanner sc = new Scanner(System.in);

    public static void modificarQuantidadeDoProduto() {
        System.out.println("\nExibindo os produtos disponíveis para modificar o estoque\n");
        ListaProduto.consultarProdutos();
        System.out.println("\nDigite o código do produto que deseja selecionar:\n");
        int posicaoSelecionada = sc.nextInt();

        if (posicaoSelecionada < 1 || posicaoSelecionada > ListaProduto.produtoList.size()) {
            System.out.println("\nCódigo inválido. Tente novamente.\n");
            return;
        }

        ListaProduto.produtoList.get(posicaoSelecionada - 1);
        System.out.println("\nAdicione a quantidade do produto:\n");
        int novoEstoque = sc.nextInt();
        Produto.setEstoqueDoProduto(novoEstoque);
        System.out.println("\nO estoque do " + Produto.getNome() + " foi atualizado para " + novoEstoque);
    }

    public static void zerarEstoqueDoProduto() {
        System.out.println("\nExibindo os produtos disponíveis para zerar o estoque\n");
        ListaProduto.consultarProdutos();
        System.out.println("\nDigite o código do produto que deseja zerar o estoque:\n");
        int posicaoSelecionada = sc.nextInt();

        if (posicaoSelecionada < 1 || posicaoSelecionada > ListaProduto.produtoList.size()) {
            System.out.println("\nCódigo inválido. Tente novamente.\n");
            return;
        }

        ListaProduto.produtoList.get(posicaoSelecionada - 1);
        Produto.setEstoqueDoProduto(0);

        System.out.println("\nO estoque do produto: " + Produto.getNome() + ", da cor " + Produto.getCor()
                + " e modelo " + Produto.getModelo() + " foi zerado!\n");
    }

    public static void consultarEstoqueDoProduto() {
        System.out.println("\nExibindo os produtos disponíveis para consultar o estoque\n");
        ListaProduto.consultarProdutos();
        System.out.println("\nDigite o código do produto que deseja consultar o estoque:\n");
        int posicaoSelecionada = sc.nextInt();

        if (posicaoSelecionada < 1 || posicaoSelecionada > ListaProduto.produtoList.size()) {
            System.out.println("\nCódigo inválido. Tente novamente.\n");
            return;
        }

        ListaProduto.produtoList.get(posicaoSelecionada - 1);
        System.out.println("\nO estoque atual do produto é " + Produto.getEstoqueDoProduto() + "\n");
    }

    public static void menuEstoque() {
        System.out.println("\nMenu Estoque:\n"
                + "\nO que deseja fazer?\n"
                + "\n1 - Modificar estoque do produto\n"
                + "2 - Consultar estoque atual do produto\n"
                + "3 - Zerar estoque do produto\n"
                + "4 - Voltar ao menu inicial\n");
        System.out.println("\nDigite sua escolha:\n");
        int escolha = sc.nextInt();

        switch (escolha) {
            case 1:
                modificarQuantidadeDoProduto();
                break;

            case 2:
                consultarEstoqueDoProduto();
                break;

            case 3:
                zerarEstoqueDoProduto();
                break;

            case 4:
                return;

            default:
                System.out.print("\nOpção inválida! Tente novamente uma opção válida\n");
                break;
        }

        menuEstoque();

    }

}