package venda;

import cliente.Cliente;
import produto.Produto;

public class Venda {
    static Produto produto;
    static Cliente cliente;
    private static double valorDoPedido;


    public Venda(Cliente cliente, Produto produto, double valorDoPedido) {
        Venda.cliente = cliente;
        Venda.produto = produto;
        Venda.valorDoPedido = valorDoPedido;
    }

    public static Cliente getCliente() {
        return cliente;
    }

    public static Produto getProduto() {
        return produto;
    }

    public static double getValorDoPedido() {
        return valorDoPedido;
    }


}

