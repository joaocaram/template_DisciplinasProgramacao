package javaquinho.comidinhas.models;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import javaquinho.comidinhas.excecoes.LimiteProdutosException;
@Entity
public class PedidoFechado extends Pedido {
    
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
