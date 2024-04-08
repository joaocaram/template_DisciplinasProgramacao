public class Cliente {
    private int id;
    private String nome;
    private String pedido;

    public Cliente(int id, String nome) {
        this.id = id;
        this.nome = nome;
        this.pedido = "";
    }

    public void fazerPedido(String pedido) {
        this.pedido = pedido;
        System.out.println(nome + " fez o pedido: " + pedido);
    }
}
