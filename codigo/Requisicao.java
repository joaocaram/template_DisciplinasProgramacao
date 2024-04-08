import java.time.LocalDate;
import java.time.LocalTime;

public class Requisicao {
    private int numDaFila;
    private LocalDate data;
    private LocalTime horaEntrada;
    private LocalTime horaSaida;
    private int numAcompanhantes;

    public Requisicao(String nome) {
        this.numDaFila = numDaFila;
        this.data = data;
        this.horaEntrada = horaEntrada;
        this.horaSaida = horaSaida;
        this.numAcompanhantes = numAcompanhantes;

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

    public int getNumAcompanhantes() {
      return numAcompanhantes;
    }

}
