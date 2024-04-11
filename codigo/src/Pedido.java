public class Pedido {
  private Integer idItem;
  private Integer quantidade;

  public Pedido(Integer idItem, Integer quantidade) {
    this.idItem = idItem;
    this.quantidade = quantidade;
  }

  public Integer getIdItem() {
    return idItem;
  }
  public void setIdItem(Integer idItem) {
    this.idItem = idItem;
  }
  public Integer getQuantidade() {
    return quantidade;
  }
  public void setQuantidade(Integer quantidade) {
    this.quantidade = quantidade;
  }
}
