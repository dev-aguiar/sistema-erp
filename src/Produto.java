import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Produto extends FuncoesPai {
    String nome;
    String cor;
    String modelo;
    int estoqueDoProduto;
    List<Produto> produtos = new ArrayList<>();
    Scanner sc = new Scanner(System.in);

    public void adicionarProduto() {
        Produto novoProduto = new Produto();
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

        System.out.println("\nAdicione a quantidade do produto:\n");
        estoqueDoProduto = sc.nextInt();
        novoProduto.estoqueDoProduto = estoqueDoProduto;

        produtos.add(novoProduto);

        System.out.println("\nO produto: " + nome + ", " + cor + ", " + modelo + " foi adicionado com sucesso!\n");

    }

    public static void consultarProdutos(List<Produto> produtos) {
        if (produtos.isEmpty()) {
            System.out.println("\nNenhum produto cadastrado ainda.\n");
            return;
        } else {
            for (int i = 0; i < produtos.size(); i++) {
                Produto produto = produtos.get(i);
                System.out.println("\nCódigo: " + (i + 1) + "\nNome: " + produto.nome + "\nCor: " + produto.cor
                        + "\nModelo: " + produto.modelo + "\n");
            }
        }

    }

    public void excluirProduto() {
        consultarProdutos(produtos);
        System.out.println("\nDigite o código do produto que deseja excluir:\n");
        
        int posicaoSelecionada = sc.nextInt();

        if (posicaoSelecionada < 1 || posicaoSelecionada > produtos.size()) {
            System.out.println("\nCódigo inválido. Tente novamente.\n");
            return;
        } else {
            Produto produtoSelecionado = produtos.get(posicaoSelecionada - 1);
            System.out
                    .println("\nProduto excluído: " + produtoSelecionado.nome + ", " + produtoSelecionado.cor + ", "
                            + produtoSelecionado.modelo + "\n");
            produtos.remove(posicaoSelecionada - 1);
        }
    }

    public void iniciar() {
        System.out.println("\n>>> Bem vindo(a) ao nosso Sistema ERP!\n");
        System.out.println("\nO que deseja fazer?\n"
                + "\n1 - Adicionar novo produto\n"
                + "2 - Consultar meus produtos cadastrados\n"
                + "3 - Excluir um produto\n"
                + "4 - Consultar estoque do produto\n");
        System.out.println("Digite sua escolha:\n");
        int escolha = sc.nextInt();

        switch (escolha) {
            case 1:
                adicionarProduto();
                break;

            case 2:
                consultarProdutos(produtos);
                break;

            case 3:
                excluirProduto();
                break;

            case 4:
                menuEstoque(produtos);
                return;

            default:
                System.out.print("Opção inválida! Tente novamente uma opção válida\n");
                break;
        }

        iniciar();

    }

    @Override
    void menuEstoque(List<Produto> produto) {
        Estoque estoque = new Estoque(this);
        estoque.menuEstoque(produtos);
    }

}