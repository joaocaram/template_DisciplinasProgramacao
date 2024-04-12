public class Cliente {
    private String nome;
    private int numPessoas;
    private int idCliente;

    public Cliente(String nome, int numPessoas, int idCliente) {
        this.nome = nome;
        this.numPessoas = numPessoas;
        this.idCliente = idCliente;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getNumPessoas() {
        return numPessoas;
    }

    public void setNumPessoas(int numPessoas) {
        this.numPessoas = numPessoas;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public void imprimeCliente() {
        System.out.println("Nome: " + nome);
        System.out.println("Número de pessoas: " + numPessoas);
        System.out.println("ID do cliente: " + idCliente);
    }
}
