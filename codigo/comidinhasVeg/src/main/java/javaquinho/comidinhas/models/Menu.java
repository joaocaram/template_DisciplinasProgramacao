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
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = Menu.TABLE_NAME)
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
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
