package venda;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import cliente.Cliente;
import cliente.ListaCliente;
import produto.Produto;
import produto.ListaProduto;

public class ListaVenda {

    private static List<Venda> vendaList = new ArrayList<>();
    private static Scanner sc = new Scanner(System.in);

    public static void gerarPedido(Cliente cliente, Produto produto, double valorDoPedido) {
        System.out.println("\nIniciando novo pedido de venda:\n");
        System.out.println("\nDeseja adicionar um cliente ao pedido de venda?\n"
                + "\n1 - Sim, desejo adicionar.\n"
                + "2 - Não, continuar sem cliente.\n");
        int escolha = sc.nextInt();
        if (escolha == 1) {
            ListaCliente.consultarCliente();
            int codigoSelecionado = sc.nextInt();
            if (codigoSelecionado < 1 || codigoSelecionado > ListaCliente.clienteList.size()) {
                System.out.println("\nCódigo do cliente inválido. Tente novamente\n");
                return;
            } else {
                Cliente c = ListaCliente.clienteList.get(codigoSelecionado - 1);
                System.out.println("\nCliente selecionado: " + Cliente.getNome()
                        + "\nTelefone:" + Cliente.getTelefone()
                        + "\nCidade: " + Cliente.getCidade() + "\n");
                cliente = c;
            }
        }

        System.out.println("\nEscolha os produtos que deseja adicionar:\n");
        ListaProduto.consultarProdutos();
        int posicaoSelecionada = sc.nextInt();
        if (posicaoSelecionada < 1 || posicaoSelecionada > ListaProduto.produtoList.size()) {
            System.out.println("\nCódigo inválido. Tente novamente.\n");
            return;
        }

        produto = ListaProduto.produtoList.get(posicaoSelecionada - 1);
        System.out.println("\nAdicione a quantidade do produto que deseja adicionar no pedido:\n");
        int quantidadeEscolhida = sc.nextInt();
        if (quantidadeEscolhida > Produto.getEstoqueDoProduto()) {
            System.out
                    .println("\nEstoque do produto insuficiente! O estoque atual é " + Produto.getEstoqueDoProduto()
                            + "\n");
        }

        System.out.println("\n" + quantidadeEscolhida + " undidades do produto " + Produto.getNome()
                + " foi adicionado ao pedido de venda\n");

        valorDoPedido = Produto.getValor() * quantidadeEscolhida;

        vendaList.add(new Venda(cliente, produto, valorDoPedido));

        System.out.println("\nPedido de venda criado: \n"
                + "\nProduto: " + Produto.getNome()
                + "\nValor total: " + valorDoPedido);
    }

    public static void consultarPedidos() {
        if (vendaList.isEmpty()) {
            System.out.println("\nNenhum pedido cadastrado ainda.\n");
            return;
        } else {
            for (int i = 0; i < vendaList.size(); i++) {
                vendaList.get(i);
                System.out.println("\nPedido de venda: " + (i + 1)
                        + "\nCliente: " + Venda.getCliente()
                        + "\nValor: " + Venda.getValorDoPedido() + "\n");
            }
        }
    }

    public static void excluirPedido() {
        consultarPedidos();
        System.out.println("\nDigite o código do produto que deseja excluir:\n");

        int posicaoSelecionada = sc.nextInt();

        if (posicaoSelecionada < 1 || posicaoSelecionada > vendaList.size()) {
            System.out.println("\nCódigo inválido. Tente novamente.\n");
            return;
        }

        Venda pedidoSelecionado = vendaList.get(posicaoSelecionada - 1);
        System.out.println("\nPedido de Venda excluído: " + "\nCódigo do pedido: " + pedidoSelecionado + "\nValor: "
                + Venda.getValorDoPedido() + "\n");
        vendaList.remove(pedidoSelecionado);

    }

    public static void menuVenda() {
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
                gerarPedido(Venda.getCliente(), Venda.getProduto(), Venda.getValorDoPedido());
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