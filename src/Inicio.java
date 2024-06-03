import java.util.Scanner;

public class Inicio {
    private Loja loja;
    private Produto produto;
    private Estoque estoque;
    private Cliente cliente;
    private Venda venda;
    Scanner sc = new Scanner(System.in);

    public Inicio() {
        this.loja = new Loja();
        this.produto = new Produto(loja.getProdutos());
        this.estoque = new Estoque(loja.getProdutos());
        this.cliente = new Cliente(loja.getClientes());
        this.venda = new Venda(loja.getVendas(), loja.getProdutos(), loja.getClientes());
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
                produto.menuProduto();
                break;
            case 2:
                estoque.menuEstoque();
                break;
            case 3:
                cliente.menuCliente();
                break;
            case 4:
                venda.menuVenda();
                return;
            default:
                System.out.print("Opção inválida! Tente novamente uma opção válida\n");
                break;
        }
        iniciar();
    }
}
