public class Mesa {

    private int idMesa;
    private int capacidade;
    private boolean disponivel;
    private List<Pedido> pedidos;

    public Mesa(int idMesa, int capacidade) {
        this.idMesa = idMesa;
        this.capacidade = capacidade;
        this.disponivel = true;
        this.pedidos = new ArrayList<>();
    }

    public int getIdMesa() {
        return idMesa;
    }

    public int getCapacidade() {
        return capacidade;
    }

    public boolean isDisponivel() {
        return disponivel;
    }

    public void setDisponivel(boolean disponivel) {
        this.disponivel = disponivel;
    }

    public List<Pedido> getPedidos() {
        return pedidos;
    }

    public void adicionarPedido(Pedido pedido) {
        pedidos.add(pedido);
    }

    public void finalizarPedido(Pedido pedido) {
        pedidos.remove(pedido);
    }

    public double calcularConta() {
        double totalPedidos = 0;
        for (Pedido pedido : pedidos) {
            totalPedidos += pedido.getValorTotal();
        }

        double taxaServico = totalPedidos * 0.1; 
        double valorTotal = totalPedidos + taxaServico;

        return valorTotal;
    }

    public void dividirConta() {
        double valorTotal = calcularConta();
        int numPessoas = 0; 

        for (Pedido pedido : pedidos) {
            numPessoas += pedido.getNumPessoas();
        }

        double valorPorPessoa = valorTotal / numPessoas;

        
        for (Pedido pedido : pedidos) {
            pedido.setValorDividido(valorPorPessoa * pedido.getNumPessoas());
        }
    }

    public void desocuparMesa() {
        setDisponivel(true);
        pedidos.clear();
    }
}


    



