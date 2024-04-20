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

    public Requisicao(Cliente cliente, LocalDate data, LocalTime horaEntrada, int numAcompanhantes) {
        this.cliente = cliente;
        this.data = data;
        this.horaEntrada = horaEntrada;
        this.numAcompanhantes = numAcompanhantes;
        this.encerrada = false;
    }

     public Mesa encerrar(LocalTime horaSaida) {
        this.horaSaida = horaSaida;
        this.encerrada = true;
        return this.mesa;
    }

    public void alocarMesa(Mesa mesa) {
        this.mesa = mesa;
    }

    public boolean estaEncerrada() {
        return this.encerrada;
    }

    public boolean ehDaMesa(int idMesa) {
        return this.mesa != null && this.mesa.getId() == idMesa;
    }

    public int quantPessoas() {
        return this.numAcompanhantes;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public LocalDate getData() {
        return data;
    }

    public LocalTime getHoraEntrada() {
        return horaEntrada;
    }

    public LocalTime getHoraSaida() {
        return horaSaida;
    }

    public Mesa getMesa() {
        return mesa;
    }

    public int getNumAcompanhantes() {
        return numAcompanhantes;
    }

    public boolean isEncerrada() {
        return encerrada;
    }
}
