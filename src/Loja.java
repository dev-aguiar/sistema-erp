import java.util.ArrayList;
import java.util.List;

public class Loja {
    private List<Produto> produtos;
    private List<Cliente> clientes;
    private List<Venda> vendas;

    public Loja() {
        this.produtos = new ArrayList<>();
        this.clientes = new ArrayList<>();
        this.vendas = new ArrayList<>();
    }

    public List<Produto> getProdutos() {
        return produtos;
    }

    public List<Cliente> getClientes() {
        return clientes;
    }

    public List<Venda> getVendas() {
        return vendas;
    }
}
