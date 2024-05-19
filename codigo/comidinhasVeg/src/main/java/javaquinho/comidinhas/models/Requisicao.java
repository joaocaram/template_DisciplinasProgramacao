package javaquinho.comidinhas.models;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

/**
 * Representa uma requisição feita por um cliente em um restaurante.
 */
public class Requisicao {

    private Cliente cliente;
    private Mesa mesa;
    private int quantPessoas;
    private LocalDateTime entrada;
    private LocalDateTime saida;
    private boolean encerrada;
    private List<Produto> produtos;

    /**
     * Construtor da classe Requisicao.
     * 
     * @param cliente O cliente que fez a requisição.
     * @param quantPessoas O número de pessoas para a requisição.
     */
    public Requisicao(Cliente cliente, int quantPessoas) {
        this.quantPessoas = 1;
        if (quantPessoas > 1)
            this.quantPessoas = quantPessoas;
        this.cliente = cliente;
        entrada = saida = null;
        mesa = null;
        encerrada = false;
        produtos = new ArrayList<>();
    }

    /**
     * Encerra a requisição e desocupa a mesa associada.
     * 
     * @return A mesa que foi desocupada.
     */
    public Mesa encerrar() {
        saida = LocalDateTime.now();
        mesa.desocupar();
        encerrada = true;
        return mesa;
    }

    /**
     * Aloca uma mesa à requisição se estiver disponível.
     * 
     * @param mesa A mesa a ser alocada.
     */
    public void alocarMesa(Mesa mesa) {
        if (mesa.estahLiberada(quantPessoas)) {
            this.mesa = mesa;
            entrada = LocalDateTime.now();
            this.mesa.ocupar();
        }
    }

    /**
     * Verifica se a requisição está encerrada.
     * 
     * @return true se a requisição estiver encerrada, caso contrário, false.
     */
    public boolean estahEncerrada() {
        return encerrada;
    }

    /**
     * Verifica se a requisição é da mesa com o ID fornecido.
     * 
     * @param idMesa O ID da mesa a ser verificado.
     * @return true se a requisição for da mesa com o ID fornecido, caso contrário, false.
     */
    public boolean ehDaMesa(int idMesa) {
        return idMesa == mesa.getIdMesa();
    }

    /**
     * Retorna a quantidade de pessoas associadas à requisição.
     * 
     * @return A quantidade de pessoas.
     */
    public int quantPessoas() {
        return quantPessoas;
    }

    /**
     * Adiciona um produto à lista de produtos da requisição.
     * 
     * @param produto O produto a ser adicionado.
     */
    public void adicionarProduto(Produto produto) {
        produtos.add(produto);
    }

    /**
     * Calcula o valor total dos produtos na requisição.
     * 
     * @return O valor total dos produtos.
     */
    public double calcularValorTotal() {
        double total = 0;
        for (Produto produto : produtos) {
            total += produto.getPreco();
        }
        return total;
    }

    /**
     * Calcula o valor por cliente na requisição.
     * 
     * @return O valor por cliente na requisição.
     */
    public double calcularValorPorCliente() {
        return calcularValorTotal() / quantPessoas;
    }

    /**
     * Retorna uma representação em formato de string da requisição.
     * 
     * @return Uma string representando os detalhes da requisição.
     */
    public String toString() {
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
        StringBuilder stringReq = new StringBuilder(cliente.toString());
        if (mesa != null) {
            stringReq.append("\n").append(mesa.toString()).append("\n");
            stringReq.append("Entrada em ").append(formato.format(entrada)).append("\n");
            if (saida != null)
                stringReq.append("Saída em ").append(formato.format(saida)).append("\n");
        } else {
            stringReq.append(" Em espera.");
        }
        stringReq.append("\nProdutos:\n");
        for (Produto produto : produtos) {
            stringReq.append(produto.toString()).append("\n");
        }
        stringReq.append("Valor total: R$").append(calcularValorTotal()).append("\n");
        stringReq.append("Valor por cliente: R$").append(calcularValorPorCliente()).append("\n");
        return stringReq.toString();
    }
}
