package produto;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ListaProduto {

    public static List<Produto> produtoList = new ArrayList<>();
    private static Scanner sc = new Scanner(System.in);

    public static void adicionarProduto(String nome, String cor, String modelo, double valor, int estoqueDoProduto) {
        System.out.print("\nPreencha as informações solicitadas para adicionar novo produto\n");
        System.out.println("\nAdicione o nome do produto:\n");
        nome = sc.next();

        System.out.println("\nAdicione a cor do produto:\n");
        cor = sc.next();

        System.out.println("\nAdicione o modelo do produto:\n");
        modelo = sc.next();

        System.out.println("\nDigite o valor do produto:\n");
        valor = sc.nextDouble();

        System.out.println("\nAdicione a quantidade do produto:\n");
        estoqueDoProduto = sc.nextInt();

        produtoList.add(new Produto(nome, cor, modelo, valor, estoqueDoProduto));

        System.out.println("\nO produto:\n" + "\nNome: " + nome + "\nCor: " + cor
                + "\nModelo: " + modelo + "\nValor: " + valor + "\n" + "\nFoi adicionado com sucesso!\n");

    }

    public static void consultarProdutos() {
        if (produtoList.isEmpty()) {
            System.out.println("\nNenhum produto cadastrado ainda.\n");
            return;
        } else {
            for (int i = 0; i < produtoList.size(); i++) {
                produtoList.get(i);
                System.out.println("\nCódigo: " + (i + 1) + "\nNome: " + Produto.getNome() + "\nCor: " + Produto.getCor()
                        + "\nModelo: " + Produto.getModelo() + "\nValor: " + Produto.getValor() + "\n");
            }
        }
    }

    public static void excluirProduto() {
        consultarProdutos();
        System.out.println("\nDigite o código do produto que deseja excluir:\n");
        int posicaoSelecionada = sc.nextInt();
        if (posicaoSelecionada < 1 || posicaoSelecionada > produtoList.size()) {
            System.out.println("\nCódigo inválido. Tente novamente.\n");
            return;
        } else {
            Produto produtoSelecionado = produtoList.get(posicaoSelecionada - 1);
            System.out
                    .println("\nProduto excluído: " + Produto.getNome() + ", " + Produto.getCor() + ", "
                            + Produto.getModelo() + Produto.getValor() + "\n");
            produtoList.remove(produtoSelecionado);
        }
    }

    public static void menuProduto() {
        System.out.println("\n>>> Menu Produtos:\n");
        System.out.println("\nO que deseja fazer?\n"
                + "\n1 - Adicionar novo produto\n"
                + "2 - Consultar meus produtos cadastrados\n"
                + "3 - Excluir um produto\n"
                + "4 - Voltar ao menu inicial\n");
        System.out.println("Digite sua escolha:\n");
        int escolha = sc.nextInt();

        switch (escolha) {
            case 1:
                adicionarProduto(Produto.getNome(), Produto.getCor(), Produto.getModelo(), Produto.getValor(), Produto.getEstoqueDoProduto());
                break;

            case 2:
                consultarProdutos();
                break;

            case 3:
                excluirProduto();
                break;

            case 4:
                return;

            default:
                System.out.print("Opção inválida! Tente novamente uma opção válida\n");
                break;
        }

        menuProduto();

    }

}