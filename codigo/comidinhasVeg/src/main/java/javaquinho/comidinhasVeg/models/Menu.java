package javaquinho.comidinhasVeg.models;
import java.util.ArrayList;

public class Menu {
    private ArrayList<Produto> produtos;

    public Menu() {

        this.produtos = new ArrayList<Produto>();
        String[] itensComida = { "Moqueca de Pamito", "Falafel Assado", "Salada Primavera com Macarrão Konjac",
                "Escondidinho de Inhame", "Strogonoff de Cogumelos", "Caçarola de legumes" };
        String[] itensBebida = { "Água", "Copo de Suco", "Refrigerante orgânico", "Cerveja vegana",
                "Taça de vinho vegano" };
        Integer[] valorComida = { 32, 20, 25, 18, 35, 22 };
        Integer[] valorBebida = { 3, 7, 7, 9, 18 };

        for (int i = 0; i < itensComida.length; i++) {
            adicionarProduto(itensComida[i], valorComida[i]);
            System.out.println(produtos.get(i));
        }
        for (int i = 0; i < itensBebida.length; i++) {
            adicionarProduto(itensBebida[i], valorBebida[i]);
        }
    }

    public void adicionarProduto(String nome, double preco) {
        Produto novoProduto = new Produto(nome, preco);
        produtos.add(novoProduto);
    }

    public String retornaMenu() {
        String relat = "";
        for (int i = 0; i < produtos.size(); i++) {
            relat+=(produtos.get(i) + "\n");
        }
        return relat;
    }

    public Produto getProduto(int indice) {
        return produtos.get(indice);
    }

    public int tamanhoMenu() {
        return produtos.size();
    }
}
