package cliente;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ListaCliente {

    public static List<Cliente> clienteList = new ArrayList<>();

    static Scanner sc = new Scanner(System.in);
    

    static void cadastrarCliente(String nome, String cidade, Long telefone) {
        System.out.println("\nDigite o nome completo do cliente:\n");
        nome = sc.next();

        System.out.println("\nDigite a cidade do cliente:\n");
        cidade = sc.next();

        System.out.println("\nInsira o telefone do cliente com o DDD:\n");
        System.out.println("\nExemplo: 11912345678\n");
        telefone = sc.nextLong();

        clienteList.add(new Cliente(nome, cidade, telefone));

        System.out.println("\nUm novo cliente foi adicionado: " + nome + ", " + telefone
                + " anos, de " + cidade + "\n");
    }

    public static void consultarCliente() {
        if (clienteList.isEmpty()) {
            System.out.println("\nNenhum cliente foi adicionado ainda!\n");
        } else {
            System.out.println("\nExibindo todos os clientes cadastrados:\n");
            for (int i = 0; i < clienteList.size(); i++) {
                clienteList.get(i);
                System.out.println("\nCódigo do Cliente: " + (i + 1)
                        + "\nNome: " + Cliente.getNome()
                        + "\nCidade: " + Cliente.getCidade()
                        + "\nTelefone: " + Cliente.getTelefone() + "\n");
            }
        }
    }

    static void selecionarCliente() {
        consultarCliente();
        int codigoSelecionado = sc.nextInt();
        if (codigoSelecionado < 1 || codigoSelecionado > clienteList.size()) {
            System.out.println("\nCódigo do cliente inválido. Tente novamente\n");
            return;
        } else {
            clienteList.get(codigoSelecionado - 1);
            System.out.println(
                    "\nCliente selecionado: " + Cliente.getNome() + "\nTelefone:" + Cliente.getTelefone()
                            + "\nCidade:" + Cliente.getCidade() + "\n");
        }
    }

    public static void menuCliente() {
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
                cadastrarCliente(null, null, null);
                break;

            case 2:
                consultarCliente();
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