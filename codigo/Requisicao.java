import java.time.LocalDate;
import java.time.LocalTime;

public class Requisicao {
    private Cliente cliente;
    private int numDaFila;
    private LocalDate data;
    private LocalTime horaEntrada;
    private LocalTime horaSaida;
    private Mesa mesa;
    private int numAcompanhantes;

    public Requisicao(String nome) {
        this.numDaFila = numDaFila;
        this.data = data;
        this.horaEntrada = horaEntrada;
        this.horaSaida = horaSaida;
        this.numAcompanhantes = numAcompanhantes;

    }

    public String getNomeCliente() {
        return cliente.getNome();
    }
    
    public int getNumDaFila() {
        return numDaFila;
    }

    public LocalDate getData() {
      return data;
    }

    public LocalTime getEntrada() {
      return horaEntrada;
    }

    public LocalTime getSaida() {
      return horaSaida;
    }

    public int getNumMesa() {
        return mesa.getMesa();
    }

    public int getNumAcompanhantes() {
      return numAcompanhantes;
    }

}
