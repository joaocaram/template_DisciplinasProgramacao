public class Produto {
    private String nome;
    private Integer preco;

    public Produto(String nome, Integer preco) {
        this.nome = nome;
        this.preco = preco;
    }

    public String getNome() {
        return nome;
    }

    public double getPreco() {
        return preco;
    }
}
