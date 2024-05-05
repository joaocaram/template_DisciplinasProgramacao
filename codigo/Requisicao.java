import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

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
    private ArrayList<Produto> pedido; // Lista de produtos solicitados na requisição

    /**
     * Construtor da classe Requisicao.
     * Inicializa um objeto Requisicao associado ao cliente fornecido,
     * com a data e hora atuais e sem hora de saída definida.
     * @param cliente O cliente que está fazendo a requisição.
     * @param quantidadePessoas A quantidade de pessoas na reserva.
     */
    public Requisicao(Cliente cliente, int quantidadePessoas) {
        this.cliente = cliente;
        this.data = LocalDate.now(); // Define a data como a data atual
        this.horaEntrada = LocalTime.now(); // Define a hora de entrada como a hora atual
        this.horaSaida = null; // A hora de saída é inicializada como nula
        this.quantidadePessoas = quantidadePessoas; // Define a quantidade de pessoas
        this.pedido = new ArrayList<>(); // Inicializa a lista de produtos
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
     * Adiciona um produto ao pedido da requisição.
     * @param produto O produto a ser adicionado ao pedido.
     */
    public void adicionarProduto(Produto produto) {
        pedido.add(produto);
    }

    /**
     * Calcula o tempo de permanência do cliente na mesa.
     * @return O tempo de permanência do cliente na mesa.
     */
    public Duration calcularTempoPermanencia() {
        LocalTime horaAtual = LocalTime.now();
        return Duration.between(horaEntrada, horaAtual);
    }

    /**
     * Atualiza a quantidade de pessoas na reserva.
     * @param novaQuantidade A nova quantidade de pessoas na reserva.
     * @return Verdadeiro se a atualização for bem-sucedida, falso caso contrário.
     */
    public boolean atualizarQuantidadePessoas(int novaQuantidade) {
        if (novaQuantidade > 0 && novaQuantidade <= 8) {
            this.quantidadePessoas = novaQuantidade;
            return true;
        } else {
            return false;
        }
    }

    /**
     * Verifica a disponibilidade de mesas para a quantidade de pessoas especificada.
     * @param capacidadeMesa A capacidade desejada da mesa.
     * @param mesasDisponiveis Lista das mesas disponíveis no restaurante.
     * @return Verdadeiro se houver uma mesa disponível, falso caso contrário.
     */
    public boolean verificarDisponibilidadeMesa(int capacidadeMesa, ArrayList<Mesa> mesasDisponiveis) {
        // Percorre a lista de mesas disponíveis para verificar se alguma tem a capacidade desejada e está livre
        for (Mesa mesa : mesasDisponiveis) {
            if (!mesa.estaOcupada() && mesa.getCapacidade() >= capacidadeMesa) {
                return true; // Mesa disponível encontrada
            }
        }
        return false; // Nenhuma mesa disponível encontrada
    }
}
