package javaquinho.comidinhasVeg.models;
public class Produto {

    private static int contador = 1;

    public int idProduto;
    private String nome;
    private double preco;

    public Produto(String nome, double preco) {
        this.idProduto = contador++;
        this.nome = nome;
        this.preco = preco;
    }

    public int getId(){
        return idProduto;
    }
    public String getNome() {
        return nome;
    }

    public double getPreco() {
        return preco;
    }

    public String toString(){

        return "ID: " + getId() + " nome: " + getNome() + " preço: R$" + getPreco();

    }
    
}
