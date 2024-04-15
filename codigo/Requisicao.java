import java.time.LocalDate;
import java.time.LocalTime;

// Classe que representa uma requisição para reservar uma mesa
public class Requisicao {
    private Cliente cliente; // Cliente que está fazendo a requisição
    private int quantidadePessoas; // Quantidade de pessoas para a reserva
    private LocalDate data; // Data da reserva
    private LocalTime horaEntrada; // Hora de entrada na reserva
    private LocalTime horaSaida; // Hora de saída da reserva (pode ser nulo se ainda não saiu)

    // Construtor da classe
    public Requisicao(Cliente cliente) {
        this.cliente = cliente;
        this.data = LocalDate.now(); // Define a data atual como a data da reserva
        this.horaEntrada = LocalTime.now(); // Define a hora atual como a hora de entrada na reserva
        this.horaSaida = null; // Ainda não há hora de saída definida
    }

    // Métodos get que obtem os atributos da classe
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

    // Métodos sets que definem os atributos da classe
    public void setData(LocalDate data) {
        this.data = data;
    }

    public void setHoraEntrada(LocalTime horaEntrada) {
        this.horaEntrada = horaEntrada;
    }

    public void setHoraSaida(LocalTime horaSaida) {
        this.horaSaida = horaSaida;
    }

    // Método para requerir uma mesa com uma quantidade específica de pessoas
    public void requerirMesa(int quantidadePessoas) {
        // Verifica se a quantidade de pessoas é válida (entre 1 e 8)
        if (quantidadePessoas > 0 && quantidadePessoas <= 8) {
            this.quantidadePessoas = quantidadePessoas;
        } else {
            System.out.println("Quantidade de pessoas inválida.");
        }
    }
}
