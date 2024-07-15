package produto;

public class Produto {
    static String nome;
    static String cor;
    static String modelo;
    static double valor;
    static int estoqueDoProduto;

    public Produto(String nome, String cor, String modelo, double valor, int estoqueDoProduto) {
        Produto.nome = nome;
        Produto.cor = cor;
        Produto.modelo = modelo;
        Produto.valor = valor;
        Produto.estoqueDoProduto = estoqueDoProduto;
    }

    public static String getNome() {
        return nome;
    }

    public static String getCor() {
        return cor;
    }

    public static String getModelo() {
        return modelo;
    }

    public static double getValor() {
        return valor;
    }

    public static int getEstoqueDoProduto() {
        return estoqueDoProduto;
    }

    public static void setEstoqueDoProduto(int novoEstoque) {
        Produto.estoqueDoProduto = novoEstoque;
    }

    @Override
    public String toString() {
        return "{" +
                " nome='" + getNome() + "'" +
                ", cor='" + getCor() + "'" +
                ", modelo='" + getModelo() + "'" +
                ", valor='" + getValor() + "'" +
                ", estoqueDoProduto='" + getEstoqueDoProduto() + "'" +
                "}";
    }            

}