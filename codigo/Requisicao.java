import java.time.LocalDate;
import java.time.LocalTime;

public class Requisicao {
    private Cliente cliente;
    private LocalDate data;
    private LocalTime horaEntrada;
    private LocalTime horaSaida;
    private Mesa mesa;
    private int numAcompanhantes;
    private boolean encerrada

    public Requisicao(Cliente cliente, LocalDate data, LocalTime horaEntrada, LocalTime horaSaida, Mesa mesa, int numAcompanhantes) {
        this.cliente = cliente;
        this.data = data;
        this.horaEntrada = horaEntrada;
        this.horaSaida = horaSaida;
        this.mesa = mesa;
        this.numAcompanhantes = numAcompanhantes;

    }

    public String getNomeCliente() {
        return cliente.getNome();
    }

    public LocalDate getData() {
      return data;
    }

    public void setData(LocalDate data){
        this.data = data;
    }

    public LocalTime getEntrada() {
      return horaEntrada;
    }

    public LocalTime getSaida() {
      return horaSaida;
    }

    public void alocarMesa(Mesa mesa) {
        return mesa.getMesa();
    }

    public int getNumAcompanhantes() {
      return numAcompanhantes;
    }

    public void salvar(LocalTime horaSaida){
        this.horaSaida = horaSaida;
    }
}
