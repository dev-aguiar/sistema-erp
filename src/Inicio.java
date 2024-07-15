import java.util.Scanner;

import cliente.Cliente;
import cliente.ListaCliente;
import estoque.Estoque;
import produto.ListaProduto;
import produto.Produto;
import venda.ListaVenda;
import venda.Venda;

public class Inicio {
    static Scanner sc = new Scanner(System.in);

    public Inicio() {
        new Produto(Produto.getNome(), Produto.getCor(), Produto.getModelo(), Produto.getValor(), Produto.getEstoqueDoProduto());
        new Estoque();
        new Cliente(Cliente.getNome(), Cliente.getCidade(), Cliente.getTelefone());
        new Venda(Venda.getCliente(), Venda.getProduto(), Venda.getValorDoPedido());
    }

    public void iniciar() {
        System.out.println("\n>>> Bem vindo(a) ao nosso Sistema ERP!\n");
        System.out.println("\nO que deseja fazer?\n"
                + "\n1 - Ir ao menu de Produtos\n"
                + "2 - Ir ao Estoque de Produtos\n"
                + "3 - Ir ao menu de Clientes\n"
                + "4 - Ir ao menu de Vendas\n");
        System.out.println("Digite sua escolha:\n");
        int escolha = sc.nextInt();

        switch (escolha) {
            case 1:
                ListaProduto.menuProduto();
                break;
            case 2:
                Estoque.menuEstoque();
                break;
            case 3:
                ListaCliente.menuCliente();
                break;
            case 4:
                ListaVenda.menuVenda();
                break;
            default:
                System.out.print("Opção inválida! Tente novamente uma opção válida\n");
                break;
        }
        iniciar();
    }
}
