public class Cliente {
  private static int contadorId = 1;

  private String nome;
  private int idCliente;

  public Cliente(String nome) {
      this.nome = nome;
      this.idCliente = contadorId++;
  }

  public String getNome() {
      return nome;
  }

  public int getIdCliente() {
      return idCliente;
  }
}