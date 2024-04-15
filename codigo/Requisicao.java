import java.time.LocalDate;
import java.time.LocalTime;

/**
 * A classe Requisicao representa uma requisição de reserva de mesa em um restaurante.
 * Cada requisição é associada a um cliente e inclui informações sobre a data, hora de entrada,
 * hora de saída e quantidade de pessoas.
 */
public class Requisicao {
    private Cliente cliente; // O cliente associado à requisição
    private int quantidadePessoas; // A quantidade de pessoas na reserva
    private LocalDate data; // A data da reserva
    private LocalTime horaEntrada; // A hora de entrada prevista
    private LocalTime horaSaida; // A hora de saída prevista

    /**
     * Construtor da classe Requisicao.
     * Inicializa um objeto Requisicao associado ao cliente fornecido,
     * com a data e hora atuais e sem hora de saída definida.
     * @param cliente O cliente que está fazendo a requisição.
     */
    public Requisicao(Cliente cliente) {
        this.cliente = cliente;
        this.data = LocalDate.now(); // Define a data como a data atual
        this.horaEntrada = LocalTime.now(); // Define a hora de entrada como a hora atual
        this.horaSaida = null; // A hora de saída é inicializada como nula
    }

    /**
     * Obtém a hora de entrada prevista para a reserva.
     * @return A hora de entrada prevista.
     */
    public LocalTime getHoraEntrada() {
        return horaEntrada;
    }

    /**
     * Obtém a data da reserva.
     * @return A data da reserva.
     */
    public LocalDate getData() {
        return data;
    }

    /**
     * Obtém a hora de saída prevista para a reserva.
     * @return A hora de saída prevista.
     */
    public LocalTime getHoraSaida() {
        return horaSaida;
    }

    /**
     * Obtém o cliente associado à requisição.
     * @return O cliente associado à requisição.
     */
    public Cliente getCliente() {
        return cliente;
    }

    /**
     * Obtém a quantidade de pessoas na reserva.
     * @return A quantidade de pessoas na reserva.
     */
    public int getQuantidadePessoas() {
        return quantidadePessoas;
    }

    /**
     * Define a data da reserva.
     * @param data A nova data da reserva.
     */
    public void setData(LocalDate data) {
        this.data = data;
    }

    /**
     * Define a hora de entrada prevista para a reserva.
     * @param horaEntrada A nova hora de entrada prevista.
     */
    public void setHoraEntrada(LocalTime horaEntrada) {
        this.horaEntrada = horaEntrada;
    }

    /**
     * Define a hora de saída prevista para a reserva.
     * @param horaSaida A nova hora de saída prevista.
     */
    public void setHoraSaida(LocalTime horaSaida) {
        this.horaSaida = horaSaida;
    }

    /**
     * Realiza a requisição de uma mesa para o número de pessoas especificado.
     * Verifica se o número de pessoas está dentro do intervalo permitido (1 a 8).
     * Caso contrário, exibe uma mensagem de erro.
     * @param quantidadePessoas A quantidade de pessoas na reserva.
     */
    public void requerirMesa(int quantidadePessoas) {
        if (quantidadePessoas > 0 && quantidadePessoas <= 8) {
            this.quantidadePessoas = quantidadePessoas;
        } else {
            System.out.println("Quantidade de pessoas inválida.");
        }
    }
}
