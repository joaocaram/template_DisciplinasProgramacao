import java.util.ArrayList;
import java.util.List;

public class Menu {
    private static List<Produto> produtos;

    public Menu() {
        produtos = new ArrayList<>();
    }

    public void adicionarProduto(String nome, double preco) {
        Produto novoProduto = new Produto(nome, preco);
        produtos.add(novoProduto);
    }

    public static void mostrarMenu() {
        System.out.println("Menu do Restaurante:");
        for (int i = 0; i < produtos.size(); i++) {
            System.out.println((i+1) + ". " + produtos.get(i).getNome() + " - R$" + produtos.get(i).getPreco());
        }
    }

    public Produto getProduto(int indice) {
        return produtos.get(indice);
    }

    public int tamanhoMenu() {
        return produtos.size();
    }
}
