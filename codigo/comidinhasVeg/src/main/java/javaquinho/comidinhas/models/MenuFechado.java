package javaquinho.comidinhas.models;

import javaquinho.comidinhas.excecoes.LimiteProdutosException;

public class MenuFechado extends Menu{
    private static int MAXIMO_ITENS = 5;

    @Override
    public void adicionarProduto(Produto produto) throws LimiteProdutosException{
        if (getProdutos().size() >= MAXIMO_ITENS){
            throw new LimiteProdutosException(MAXIMO_ITENS);
        }
        else {
            this.getProdutos().add(produto);
        }
    }
    
}
