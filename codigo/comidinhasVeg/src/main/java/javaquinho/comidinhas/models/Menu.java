package javaquinho.comidinhas.models;
import java.util.ArrayList;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;

@Entity
@Table(name = Menu.TABLE_NAME)
@AllArgsConstructor
@EqualsAndHashCode
public class Menu {
    public static final String TABLE_NAME = "menu";
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private Long id;

    @OneToOne
    @JoinColumn(name = "produto_id", nullable = false, updatable = false)
    private Produto produto;

    // private ArrayList<Produto> produtos;

    public Menu() {

        // this.produtos = new ArrayList<Produto>();
        // String[] itensComida = { "Moqueca de Pamito", "Falafel Assado", "Salada Primavera com Macarrão Konjac",
        //         "Escondidinho de Inhame", "Strogonoff de Cogumelos", "Caçarola de legumes" };
        // String[] itensBebida = { "Água", "Copo de Suco", "Refrigerante orgânico", "Cerveja vegana",
        //         "Taça de vinho vegano" };
        // Integer[] valorComida = { 32, 20, 25, 18, 35, 22 };
        // Integer[] valorBebida = { 3, 7, 7, 9, 18 };

        // for (int i = 0; i < itensComida.length; i++) {
        //     adicionarProduto(itensComida[i], valorComida[i]);
        //     System.out.println(produtos.get(i));
        // }
        // for (int i = 0; i < itensBebida.length; i++) {
        //     adicionarProduto(itensBebida[i], valorBebida[i]);
        // }
    }

    // public void adicionarProduto(String nome, double preco) {
    //     Produto novoProduto = new Produto(nome, preco);
    //     produtos.add(novoProduto);
    // }

    // public String retornaMenu() {
    //     String relat = "";
    //     for (int i = 0; i < produtos.size(); i++) {
    //         relat+=(produtos.get(i) + "\n");
    //     }
    //     return relat;
    // }

    // public Produto getProduto(int indice) {
    //     return produtos.get(indice);
    // }

    // public int tamanhoMenu() {
    //     return produtos.size();
    // }
}
