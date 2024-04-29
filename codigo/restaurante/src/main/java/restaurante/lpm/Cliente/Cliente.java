public class Cliente {
    private int id;
    private String nome;
    private String pedido;
    private int quantidade; 

    public Cliente(int id, String nome) {
        this.id = id;
        this.nome = nome;
        this.pedido = "";
        this.quantidade = 0; 
    }

    public void fazerPedido(String pedido) {
        this.pedido = pedido;
        System.out.println(nome + " fez o pedido: " + pedido);
    }

    public void declararQuantidade(int quantidade) {
        this.quantidade = quantidade;
        System.out.println(nome + " chamou " + quantidade + " Convidados");
    }
}
