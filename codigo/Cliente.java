/**
 * A classe Cliente representa um cliente do sistema de restaurante.
 */
public class Cliente {
    
    private String nome;        
    private String telContato;  

    /**
     * Construtor para inicializar um objeto Cliente com o nome e número de telefone de contato.
     * 
     * @param nome O nome do cliente.
     * @param telContato O número de telefone de contato do cliente.
     */
    public Cliente(String nome, String telContato) {
        this.nome = nome;
        this.telContato = telContato;
    }

    /**
     * Obter o nome do cliente.
     * 
     * @return O nome do cliente.
     */
    public String getNome() {
        return nome;
    }

    /**
     * Obter o número de telefone de contato do cliente.
     * 
     * @return O número de telefone de contato do cliente.
     */
    public String getTelContato() {
        return telContato;
    }

    /**
     * Obter uma string contendo os dados do cliente formatados.
     * 
     * @return Uma string contendo os dados do cliente (nome e telefone de contato).
     */
    public String dadosCliente(){
        return "Nome: " + this.nome + ", Telefone: " + this.telContato;
    }
}
