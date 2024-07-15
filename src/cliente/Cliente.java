package cliente;
public class Cliente {
    private static String nome;
    private static String cidade;
    private static Long telefone;


    public Cliente(String nome, String cidade, Long telefone) {
        Cliente.nome = nome;
        Cliente.cidade = cidade;
        Cliente.telefone = telefone;
    }


    public static String getNome() {
        return nome;
    }

    public static String getCidade() {
        return cidade;
    }

    public static Long getTelefone() {
        return telefone;
    }


    @Override
    public String toString() {
        return "{" +
            "Nome ='" + getNome() + "'" +
            "Cidade ='" + getCidade() + "'" +
            "Telefone ='" + getTelefone() + "'" +
            "}";
    }

}
