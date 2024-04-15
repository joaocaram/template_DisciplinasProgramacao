import java.time.LocalDate;
import java.time.LocalTime;

public class Requisicao {
    private Cliente cliente;
    private int quantidadePessoas;
    private LocalDate data;
    private LocalTime horaEntrada;
    private LocalTime horaSaida;

    public Requisicao(Cliente cliente) {
        this.cliente = cliente;
        this.data = LocalDate.now();
        this.horaEntrada = LocalTime.now();
        this.horaSaida = null;
    }

    public LocalTime getHoraEntrada() {
        return horaEntrada;
    }

    public LocalDate getData() {
        return data;
    }

    public LocalTime getHoraSaida() {
        return horaSaida;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public int getQuantidadePessoas() {
        return quantidadePessoas;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public void setHoraEntrada(LocalTime horaEntrada) {
        this.horaEntrada = horaEntrada;
    }

    public void setHoraSaida(LocalTime horaSaida) {
        this.horaSaida = horaSaida;
    }

    public void requerirMesa(int quantidadePessoas) {
        if (quantidadePessoas > 0 && quantidadePessoas <= 8) {
            this.quantidadePessoas = quantidadePessoas;
        } else {
            System.out.println("Quantidade de pessoas inválida.");
        }
    }
}
