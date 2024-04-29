public class ItemCardapio {
    int idItem;
    String nome;
    Double preco;
  
    public ItemCardapio(int idItem, String nome, Double preco) {
      setIdItem(idItem);
      setNome(nome);
      setPreco(preco);
    }
  
    public String getNome() {
      return nome;
    }
  
    public void setNome(String nome) {
      this.nome = nome;
    }
  
    public Double getPreco() {
      return preco;
    }
  
    public void setPreco(Double preco) {
      this.preco = preco;
    }
  
    public int getIdItem() {
      return idItem;
    }
  
    public void setIdItem(int idItem) {
      this.idItem = idItem;
    }
  }