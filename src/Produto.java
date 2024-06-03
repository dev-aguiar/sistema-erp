import java.util.List;
import java.util.Scanner;

public class Produto {
    String nome;
    String cor;
    String modelo;
    double valor;
    int estoqueDoProduto;
    private static List<Produto> produtos;
    static Scanner sc = new Scanner(System.in);

    public Produto(List<Produto> produtos){
        Produto.produtos = produtos;
    }

    public void adicionarProduto() {
        Produto novoProduto = new Produto(produtos);
        System.out.print("\nPreencha as informações solicitadas para adicionar novo produto\n");
        System.out.println("\nAdicione o nome do produto:\n");
        nome = sc.next();
        novoProduto.nome = nome;

        System.out.println("\nAdicione a cor do produto:\n");
        cor = sc.next();
        novoProduto.cor = cor;

        System.out.println("\nAdicione o modelo do produto:\n");
        modelo = sc.next();
        novoProduto.modelo = modelo;

        System.out.println("\nDigite o valor do produto:\n");
        valor = sc.nextDouble();
        novoProduto.valor = valor;

        System.out.println("\nAdicione a quantidade do produto:\n");
        estoqueDoProduto = sc.nextInt();
        novoProduto.estoqueDoProduto = estoqueDoProduto;

        produtos.add(novoProduto);

        System.out.println("\nO produto:\n" + "\nNome: " + nome + "\nCor: " + cor
                + "\nModelo: " + modelo + "\nValor: " + valor + "\n" + "\nFoi adicionado com sucesso!\n");

    }

    public static void consultarProdutos() {
        if (produtos.isEmpty()) {
            System.out.println("\nNenhum produto cadastrado ainda.\n");
            return;
        } else {
            for (int i = 0; i < produtos.size(); i++) {
                Produto produto = produtos.get(i);
                System.out.println("\nCódigo: " + (i + 1) + "\nNome: " + produto.nome + "\nCor: " + produto.cor
                        + "\nModelo: " + produto.modelo + "\nValor: " + produto.valor + "\n");
            }
        }
    }

    public void excluirProduto() {
        consultarProdutos();
        System.out.println("\nDigite o código do produto que deseja excluir:\n");
        int posicaoSelecionada = sc.nextInt();
        if (posicaoSelecionada < 1 || posicaoSelecionada > produtos.size()) {
            System.out.println("\nCódigo inválido. Tente novamente.\n");
            return;
        } else {
            Produto produtoSelecionado = produtos.get(posicaoSelecionada - 1);
            System.out
                    .println("\nProduto excluído: " + produtoSelecionado.nome + ", " + produtoSelecionado.cor + ", "
                            + produtoSelecionado.modelo + produtoSelecionado.valor + "\n");
            produtos.remove(posicaoSelecionada - 1);
        }
    }

    void menuProduto() {
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
                adicionarProduto();
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