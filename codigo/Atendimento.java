public class Atendimento {
    private Cliente cliente;
    private String descricao;

    public Atendimento(Cliente cliente, String descricao) {
        this.cliente = cliente;
        this.descricao = descricao;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public void imprimeAtendimento() {
        System.out.println("Cliente: " + cliente.getNome());
        System.out.println("Descrição: " + descricao);
    }

}

