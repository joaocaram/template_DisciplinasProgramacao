public class Cliente {
    
    public String nome;
    public int idCliente;

    public void statusCliente(){
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
