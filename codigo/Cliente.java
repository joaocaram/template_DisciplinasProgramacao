public class Cliente {
    private static int contadorId = 1;
    private int idCliente;
  
    private String nome;
  
    public Cliente(String nome) {
      setNome(nome); 
      this.idCliente = contadorId++;
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
  }
