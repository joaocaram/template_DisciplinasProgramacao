package javaquinho.comidinhas.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = Produto.TABLE_NAME)
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
public class Produto {

    public static final String TABLE_NAME = "produto";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    public Long idProduto;

    @Column(name = "nome", nullable = false, columnDefinition = "char(50)")
    private String nome;

    @Column(name = "preco", nullable = false, columnDefinition = "double(6, 2)")
    private double preco;

    @OneToMany
    @JoinColumn(name = "menu_id", nullable = false)
    private Menu menu;

    public Long getId(){
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
