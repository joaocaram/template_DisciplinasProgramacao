public class Cliente {

    private String nome;
    private int idCliente;

    
    public Cliente(String nome, int idCliente) {
        this.nome = nome;
        this.idCliente = idCliente;
    }

    public void statusCliente() {
        getIdCliente();
        getNome();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }
}
