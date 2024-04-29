import java.util.ArrayList;
import java.util.List;

public class Mesa {
  private int capacidade;
  private int idMesa;
  private int clientesSentados;
  private List<Pedido> pedidos;
  private Double totalConta;

  public Mesa(int idMesa, int capacidade) {
    setIdMesa(idMesa);
    setCapacidade(capacidade);
    setClientesSentados(0);
    this.pedidos = new ArrayList<>();
    this.totalConta = 0.0;
  }

  public int getCapacidade() {
    return capacidade;
  }

  public void setCapacidade(int capacidade) {
    this.capacidade = capacidade;
  }

  public int getIdMesa() {
    return idMesa;
  }

  public void setIdMesa(int idMesa) {
    this.idMesa = idMesa;
  }

  public int getClientesSentados() {
    return clientesSentados;
  }

  public void setClientesSentados(int clientesSentados) {
    this.clientesSentados = clientesSentados;
  }

  public List<Pedido> getPedidos() {
    return pedidos;
  }

  public void addPedidos(Pedido pedido) {
    pedidos.add(pedido);
  }

  public Double getTotalConta() {
    return totalConta;
  }

  public void addTotalConta(Double totalConta) {
    this.totalConta += totalConta;
  }

  public double dividirConta() {
    return totalConta / this.clientesSentados;
  }

  public void pagarConta(){
    this.clientesSentados = 0;
    this.totalConta = 0.0;
    this.pedidos.clear();
  }
  public void adicionarTaxaServico() {
	    double taxaServico = totalConta * 0.10;
	    totalConta += taxaServico;
	}

}