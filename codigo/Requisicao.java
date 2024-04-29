import java.time.LocalDateTime;

public class Requisicao {
  private static int contadorId = 1;
  private Integer idRequisicao;
  private LocalDateTime dataHoraEntrada;
  private LocalDateTime dataHoraSaida;
  private Cliente cliente;
  private Integer numeroDePessoas;
  private boolean atendida;
  private Mesa mesa;
  private Double conta;

  public Requisicao(Cliente cliente, Integer numeroDePessoas) {
    this.idRequisicao = contadorId++;
    this.numeroDePessoas = numeroDePessoas;
    this.dataHoraEntrada = LocalDateTime.now();
    this.cliente = cliente;
    this.atendida = false;
    this.mesa = null;
    this.conta = 0.0;
  }

  public Integer getIdRequisicao() {
    return idRequisicao;
  }

  public void setIdRequisicao(Integer idRequisicao) {
    this.idRequisicao = idRequisicao;
  }

  public LocalDateTime getDataHoraEntrada() {
    return dataHoraEntrada;
  }

  public void setDataHoraEntrada(LocalDateTime dataHoraEntrada) {
    this.dataHoraEntrada = dataHoraEntrada;
  }

  public LocalDateTime getDataHoraSaida() {
    return dataHoraSaida;
  }

  public void setDataHoraSaida(LocalDateTime dataHoraSaida) {
    this.dataHoraSaida = dataHoraSaida;
  }

  public Cliente getCliente() {
    return cliente;
  }

  public void setCliente(Cliente cliente) {
    this.cliente = cliente;
  }

  public Integer getNumeroDePessoas() {
    return numeroDePessoas;
  }

  public void setNumeroDePessoas(Integer numeroDePessoas) {
    this.numeroDePessoas = numeroDePessoas;
  }

  public boolean isAtendida() {
    return atendida;
  }

  public void setAtendida(boolean atendida) {
    this.atendida = atendida;
  }

  public Mesa getMesa() {
    return mesa;
  }

  public void setMesa(Mesa mesa) {
    this.mesa = mesa;
  }

  public Double getConta() {
    return conta;
  }

  public void setConta(Double conta) {
    this.conta = conta;
  }
}
