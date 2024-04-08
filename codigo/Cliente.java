public class Cliente {
    
    private String nome;
    private String telContato;

    public Cliente(String nome, String telContato) {
        this.nome = nome;
        this.telContato = telContato;
    }

    public String getNome() {
        return nome;
    }

    public String getTelContato() {
        return telContato;
    }

    public String dadosCliente(){
        return "Nome: " + this.nome + ", Telefone: " + this.telContato;
    }
}