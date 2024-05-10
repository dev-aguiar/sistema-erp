import java.util.List;
import java.util.Scanner;

public class Estoque extends FuncoesPai {
    Scanner sc = new Scanner(System.in);

    public void modificarQuantidadeDoProduto(List<Produto> produtos) {
        System.out.println("\nExibindo os produtos disponíveis para modificar o estoque\n");
        Produto.consultarProdutos(produtos);
        System.out.println("\nDigite o código do produto que deseja selecionar:\n");
        int posicaoSelecionada = sc.nextInt();

        if (posicaoSelecionada < 1 || posicaoSelecionada > produtos.size()) {
            System.out.println("\nCódigo inválido. Tente novamente.\n");
            return;
        }

        Produto produtoSelecionado = produtos.get(posicaoSelecionada - 1);
        System.out.println("\nAdicione a quantidade do produto:\n");
        int novoEstoque = sc.nextInt();
        produtoSelecionado.estoqueDoProduto = novoEstoque;
        System.out.println("\nO estoque do " + produtoSelecionado.nome + " foi atualizado para " + novoEstoque);
    }

    public void zerarEstoqueDoProduto(List<Produto> produtos) {
        System.out.println("\nExibindo os produtos disponíveis para zerar o estoque\n");
        Produto.consultarProdutos(produtos);
        System.out.println("\nDigite o código do produto que deseja zerar o estoque:\n");
        int posicaoSelecionada = sc.nextInt();

        if (posicaoSelecionada < 1 || posicaoSelecionada > produtos.size()) {
            System.out.println("\nCódigo inválido. Tente novamente.\n");
            return;
        }

        Produto produtoSelecionado = produtos.get(posicaoSelecionada - 1);
        produtoSelecionado.estoqueDoProduto = 0;
    }

    public void consultarEstoqueDoProduto(List<Produto> produtos) {
        System.out.println("\nExibindo os produtos disponíveis para consultar o estoque\n");
        Produto.consultarProdutos(produtos);
        System.out.println("\nDigite o código do produto que deseja consultar o estoque:\n");
        int posicaoSelecionada = sc.nextInt();

        if (posicaoSelecionada < 1 || posicaoSelecionada > produtos.size()) {
            System.out.println("\nCódigo inválido. Tente novamente.\n");
            return;
        }

        Produto produtoSelecionado = produtos.get(posicaoSelecionada - 1);
        System.out.println("\nEstoque modificado com sucesso!\n");
        System.out.println("\nO estoque atual do produto é " + produtoSelecionado.estoqueDoProduto + "\n");
    }

    @Override
    void iniciar() {
        Produto produto = new Produto();
        produto.iniciar();
    }

    void iniciar(List<Produto> produtos) {
        menuEstoque(produtos);
    }

    @Override
    void menuEstoque(List<Produto> produtos) {
        System.out.println("\nMenu Estoque:\n"
                + "\nO que deseja fazer?\n"
                + "\n1 - Modificar estoque do produto\n"
                + "2 - Consultar estoque atual do produto\n"
                + "3 - Zerar estoque do produto\n"
                + "4 - Voltar ao menu anterior\n");
        System.out.println("\nDigite sua escolha:\n");
        int escolha = sc.nextInt();

        switch (escolha) {
            case 1:
                modificarQuantidadeDoProduto(produtos);
                menuEstoque(produtos);
                break;

            case 2:
                consultarEstoqueDoProduto(produtos);
                menuEstoque(produtos);
                break;

            case 3:
                zerarEstoqueDoProduto(produtos);
                menuEstoque(produtos);
                break;

            case 4:
                iniciar(produtos);
                break;

            default:
                System.out.print("\nOpção inválida! Tente novamente uma opção válida\n");
                menuEstoque(produtos);
                break;
        }

    }
}
