public class Mesa {
  private int capacidade;
  private int idMesa;
  private int idRequisicao;

  public Mesa(int idMesa, int capacidade) {
      this.idMesa = idMesa;
      this.capacidade = capacidade;
      this.idRequisicao = -1; // ID de requisição -1 indica que a mesa está disponível
  }

  public boolean verificarDisponibilidade() {
      return idRequisicao == -1;
  }

  public int getCapacidade() {
      return capacidade;
  }

  public int getIdMesa() {
      return idMesa;
  }
  
  public void setIdRequisicao(int idRequisicao) {
      this.idRequisicao = idRequisicao;
  }

  public int getIdRequisicao() {
      return idRequisicao;
  }

}

