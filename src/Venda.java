import java.util.List;
import java.util.Scanner;

public class Venda {
    private List<Venda> vendas;
    private List<Produto> produtos;
    private List<Cliente> clientes;
    private Produto produto;
    private Cliente cliente;
    private Scanner sc = new Scanner(System.in);
    double valorDoPedido;

    public Venda(List<Venda> vendas, List<Produto> produtos, List<Cliente> clientes) {
        this.vendas = vendas;
        this.produtos = produtos;
        this.clientes = clientes;
    }

    public Venda criarPedido(Produto produto, int quantidade, Cliente cliente) {
        Venda pedido = new Venda(vendas, produtos, clientes);
        pedido.produto = produto;
        pedido.valorDoPedido = produto.valor * quantidade;
        pedido.cliente = cliente;
        return pedido;
    }

    public void gerarPedido() {
        System.out.println("\nIniciando novo pedido de venda:\n");
        System.out.println("\nDeseja adicionar um cliente ao pedido de venda?\n"
                + "\n1 - Sim, desejo adicionar.\n"
                + "2 - Não, continuar sem cliente.\n");
        int escolha = sc.nextInt();
        if (escolha == 1) {
            Cliente.consultarCliente(clientes);
            int codigoSelecionado = sc.nextInt();
                if (codigoSelecionado < 1 || codigoSelecionado > clientes.size()) {
                    System.out.println("\nCódigo do cliente inválido. Tente novamente\n");
                    return;
                    } else {
                        cliente = clientes.get(codigoSelecionado - 1);
                            System.out.println("\nCliente selecionado: " + cliente.nome
                                                + "\nTelefone:" + cliente.telefone
                                                + "\nCidade: " + cliente.cidade + "\n");
            }
        } 

        System.out.println("\nEscolha os produtos que deseja adicionar:\n");
        Produto.consultarProdutos();
        int posicaoSelecionada = sc.nextInt();
        if (posicaoSelecionada < 1 || posicaoSelecionada > produtos.size()) {
            System.out.println("\nCódigo inválido. Tente novamente.\n");
            return;
        }

        produto = produtos.get(posicaoSelecionada - 1);
        System.out.println("\nAdicione a quantidade do produto que deseja adicionar no pedido:\n");
        int quantidadeEscolhida = sc.nextInt();
        if (quantidadeEscolhida > produto.estoqueDoProduto) {
            System.out
                    .println("\nEstoque do produto insuficiente! O estoque atual é " + produto.estoqueDoProduto + "\n");
        }

        System.out.println("\n" + quantidadeEscolhida + " undidades do produto " + produto.nome
                + " foi adicionado ao pedido de venda\n");

        Venda novoPedido = criarPedido(produto, quantidadeEscolhida, cliente);
        vendas.add(novoPedido);

        System.out.println("\nPedido de venda criado: \n"
                + "\nProduto: " + produto.nome
                + "\nValor total: " + novoPedido.valorDoPedido);
    }

    public void consultarPedidos() {
        if (vendas.isEmpty()) {
            System.out.println("\nNenhum produto cadastrado ainda.\n");
            return;
        } else {
            for (int i = 0; i < vendas.size(); i++) {
                Venda venda = vendas.get(i);
                System.out.println("\nPedido de venda: " + (i + 1)
                                + "\nCliente: " + venda.cliente
                                + "\nValor: " + venda.valorDoPedido + "\n");
            }
        }
    }

    public void excluirPedido() {
        consultarPedidos();
        System.out.println("\nDigite o código do produto que deseja excluir:\n");

        int posicaoSelecionada = sc.nextInt();

        if (posicaoSelecionada < 1 || posicaoSelecionada > vendas.size()) {
            System.out.println("\nCódigo inválido. Tente novamente.\n");
            return;
        }

        Venda pedidoSelecionado = vendas.get(posicaoSelecionada - 1);
        System.out.println("\nPedido de Venda excluído: " + "\nCódigo do pedido: " + pedidoSelecionado + "\nValor: "
                + pedidoSelecionado.produto.valor + "\n");
        vendas.remove(posicaoSelecionada - 1);

    }

    public void menuVenda() {
        System.out.println("\nMenu Estoque:\n"
                + "\nO que deseja fazer?\n"
                + "\n1 - Gerar Pedido de Venda\n"
                + "2 - Consultar pedidos de venda gerados\n"
                + "3 - Excluir um pedido de venda\n"
                + "4 - Voltar ao menu principal\n");
        System.out.println("\nDigite sua escolha:\n");
        int escolha = sc.nextInt();

        switch (escolha) {
            case 1:
                gerarPedido();
                break;

            case 2:
                consultarPedidos();
                break;

            case 3:
                excluirPedido();
                break;

            case 4:
                return;

            default:
                System.out.print("\nOpção inválida! Tente novamente uma opção válida\n");
                break;
        }

        menuVenda();

    }

}
