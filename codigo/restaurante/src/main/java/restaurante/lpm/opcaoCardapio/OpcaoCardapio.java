package restaurante.lpm.opcaoCardapio;

public class OpcaoCardapio {
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public int getId() {
        return id;
    }

    String nome;
    double preco;
    int id;

    public OpcaoCardapio(String nome, double preco, int id) {
        this.nome = nome;
        this.preco = preco;
        this.id = id;
    }
}
