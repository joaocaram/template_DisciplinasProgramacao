package javaquinho.comidinhasVeg.models;
/**
 * A classe Cliente representa um cliente do sistema de restaurante.
 */
public class Cliente {
    
    private static int contador = 1;
    
    private String nome;
    private String telContato;
    private int id;
    private String CPF;

    /**
     * Construtor para inicializar um objeto Cliente com o nome e número de telefone de contato.
     * 
     * @param nome O nome do cliente.
     * @param telContato O número de telefone de contato do cliente.
     * @param id O ID do cliente.
     */
    public Cliente(String nome, String telContato, String CPF) {
        setNome(nome);
        setTelContato(telContato);
        setCPF(CPF);
        id = contador++;
    }

    /**
     * Define o nome do cliente.
     * 
     * @param nome O nome a ser definido para o cliente.
     */
    public void setNome(String nome) {
        if(nome.length() >= 3){
            this.nome = nome;
        }
    }

    /**
     * Define o número de telefone de contato do cliente.
     * 
     * @param telContato O número de telefone a ser definido para o cliente.
     */
    public void setTelContato(String telContato) {
        if(telContato.length() >= 11 && telContato.length() <= 17){
            this.telContato = telContato;
        }
    }

    /**
     * Define o CPF do cliente.
     * 
     * @param CPF O CPF a ser definido para o cliente.
     */
    public void setCPF(String CPF){
        if(CPF.length() == 11){
            this.CPF = CPF;
        }
    }

    /**
     * Obtém o ID único do cliente.
     * 
     * @return O ID único do cliente.
     */
    public int getId() {
        return id;
    }

    /**
     * Obtém o nome do cliente.
     * 
     * @return O nome do cliente.
     */
    public String getNome() {
        return nome;
    }

    /**
     * Obtém o número de telefone de contato do cliente.
     * 
     * @return O número de telefone de contato do cliente.
     */
    public String getTelContato() {
        return telContato;
    }

    /**
     * Obtém o CPF do cliente.
     * 
     * @return O CPF cliente.
     */
    public String getCPF(){
        return CPF;
    }

    /**
     * Retorna uma string contendo os dados do cliente formatados.
     * 
     * @return Uma string contendo os dados do cliente (ID, nome e telefone de contato).
     */
    public String toString(){

        return "ID: " + getId() +  ", Nome: " + getNome() + ", Telefone: " + getTelContato() + ", CPF: " + getCPF();
    
    }
}
