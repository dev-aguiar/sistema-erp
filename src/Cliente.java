import java.util.List;
import java.util.Scanner;

public class Cliente {
    String nome;
    String cidade;
    Long telefone;
    private List<Cliente> clientes;
    static Scanner sc = new Scanner(System.in);

    public Cliente(List<Cliente> clientes){
        this.clientes = clientes;
    }

    void cadastrarCliente() {
        Cliente novoCliente = new Cliente(clientes);
        System.out.println("\nDigite o nome completo do cliente:\n");
        nome = sc.next();
        novoCliente.nome = nome;

        System.out.println("\nDigite a cidade do cliente:\n");
        cidade = sc.next();
        novoCliente.cidade = cidade;

        System.out.println("\nInsira o telefone do cliente com o DDD:\n");
        System.out.println("\nExemplo: 11912345678\n");
        telefone = sc.nextLong();
        novoCliente.telefone = telefone;

        clientes.add(novoCliente);

        System.out.println("\nUm novo cliente foi adicionado: " + novoCliente.nome + ", " + novoCliente.telefone
                + " anos, de " + novoCliente.cidade + "\n");
    }

    static void consultarCliente(List<Cliente> clientes) {
        if (clientes.isEmpty()) {
            System.out.println("\nNenhum cliente foi adicionado ainda!\n");
        } else {
            System.out.println("\nExibindo todos os clientes cadastrados:\n");
            for (int i = 0; i < clientes.size(); i++) {
                Cliente cliente = clientes.get(i);
                System.out.println("\nCódigo do Cliente: " + (i + 1)
                        + "\nNome: " + cliente.nome
                        + "\nCidade: " + cliente.cidade
                        + "\nTelefone: " + cliente.telefone + "\n");
            }
        }
    }

    void selecionarCliente() {
        consultarCliente(clientes);
        int codigoSelecionado = sc.nextInt();
        if (codigoSelecionado < 1 || codigoSelecionado > clientes.size()) {
            System.out.println("\nCódigo do cliente inválido. Tente novamente\n");
            return;
        } else {
            Cliente clienteSelecionado = clientes.get(codigoSelecionado - 1);
            System.out.println("\nCliente selecionado: " + clienteSelecionado.nome + "\nTelefone:" + clienteSelecionado.telefone
                    + "\nCidade:" + clienteSelecionado.cidade + "\n");
        }
    }

    void menuCliente() {
        System.out.println("\nMenu Cliente:\n"
                + "\nO que deseja fazer?\n"
                + "\n1 - Cadastrar novo cliente\n"
                + "2 - Consultar clientes cadastrados\n"
                + "3 - Selecionar um cliente\n"
                + "4 - Voltar ao menu principal\n");
        System.out.println("\nDigite sua escolha:\n");
        int escolha = sc.nextInt();

        switch (escolha) {
            case 1:
                cadastrarCliente();
                break;

            case 2:
                consultarCliente(clientes);
                break;

            case 3:
                selecionarCliente();
                break;

            case 4:
                return;

            default:
                System.out.print("\nOpção inválida! Tente novamente uma opção válida\n");
                break;
        }

        menuCliente();

    }

}
