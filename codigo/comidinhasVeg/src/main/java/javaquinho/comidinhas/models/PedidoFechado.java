package javaquinho.comidinhas.models;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import javaquinho.comidinhas.excecoes.LimiteProdutosException;
@Entity
public class PedidoFechado extends Pedido {

    @OneToOne
    @JoinColumn(name = "requisicao", nullable = true)
    private Requisicao requisicao;

    private static int MAXIMO_ITENS_PESSOA = 2;

    public int getMaximoItens() {
        return this.requisicao.getQuantPessoas() * MAXIMO_ITENS_PESSOA;
    }

    @Override
    public double getSomarTotal() {
        return this.requisicao.getQuantPessoas() * 32;
    }

    @Override
    public void addProduto(Produto produto) throws LimiteProdutosException{
        if (this.getProdutos().size() >= getMaximoItens()){
            throw new LimiteProdutosException(getMaximoItens());
        }
        else {
            this.addProduto(produto);
        }
    }
}
