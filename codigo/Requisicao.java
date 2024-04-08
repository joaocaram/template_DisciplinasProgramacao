import java.time.LocalDate;
import java.time.LocalTime;

public class Requisicao {
    private Cliente cliente;
    private int quantidadePessoas;
    private LocalDate data;
    private LocalTime horaEntrada;

    public Requisicao(Cliente cliente) {
        this.cliente = cliente;
        this.data = LocalDate.now();
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

 public int requerirMesa(int quantidadePessoas) {

    if (quantidadePessoas > 8 && quantidadePessoas < 1 ) {
        return -1; 
    }
    this.quantidadePessoas = quantidadePessoas;


 }

}
