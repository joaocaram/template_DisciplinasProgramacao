import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Requisicao {

    // Variáveis de instância para representar uma requisição
    private Cliente cliente; // Cliente associado à requisição
    private Mesa mesa; // Mesa associada à requisição
    private int quantPessoas; // Quantidade de pessoas na requisição
    private LocalDateTime entrada; // Data e hora de entrada na mesa
    private LocalDateTime saida; // Data e hora de saída da mesa
    private boolean encerrada; // Indica se a requisição foi encerrada

    /**
     * Construtor da classe Requisicao.
     * @param cliente O cliente associado à requisição.
     * @param quantPessoas A quantidade de pessoas na requisição.
     */
    public Requisicao(Cliente cliente, int quantPessoas) {
        // Define a quantidade de pessoas como pelo menos 1, se a quantidade fornecida for menor que 1
        this.quantPessoas = Math.max(1, quantPessoas);
        this.cliente = cliente;
        // Inicializa as variáveis de data/hora e mesa como nulas
        entrada = saida = null;
        mesa = null;
        // Inicializa a requisição como não encerrada
        encerrada = false;
    }

    /**
     * Encerra a requisição, desocupando a mesa e registrando a data/hora de saída.
     * @return A mesa que foi desocupada.
     */
    public Mesa encerrar() {
        // Registra a data/hora de saída como o momento atual
        saida = LocalDateTime.now();
        // Desocupa a mesa associada a requisição
        mesa.desocupar();
        // Marca a requisição como encerrada
        encerrada = true;
        // Retorna a mesa que foi desocupada
        return mesa;
    }

    /**
     * Aloca uma mesa para a requisição, se disponível.
     * @param mesa A mesa a ser alocada.
     */
    public void alocarMesa(Mesa mesa) {
        // Verifica se a mesa está disponível para a quantidade de pessoas na requisição
        if (mesa.estahLiberada(quantPessoas)) {
            // Se sim, associa a mesa à requisição
            this.mesa = mesa;
            // Registra a data/hora de entrada como o momento atual
            entrada = LocalDateTime.now();
            // Ocupa a mesa associada à requisição
            this.mesa.ocupar();
        }
    }

    /**
     * Verifica se a requisição está encerrada.
     * @return true se a requisição está encerrada, false caso contrário.
     */
    public boolean estahEncerrada() {
        return encerrada;
    }

    /**
     * Verifica se a requisição é associada à mesa com o ID especificado.
     * @param idMesa O ID da mesa a ser verificada.
     * @return true se a requisição é associada à mesa com o ID especificado, false caso contrário.
     */
    public boolean ehDaMesa(int idMesa) {
        // Verifica se a mesa associada à requisição tem o ID especificado
        return mesa != null && idMesa == mesa.getIdMesa();
    }

    /**
     * Obtém a quantidade de pessoas na requisição.
     * @return A quantidade de pessoas na requisição.
     */
    public int quantPessoas() {
        return quantPessoas;
    }

    /**
     * Retorna uma representação em formato de string da requisição.
     * @return Uma string representando a requisição.
     */
    public String toString() {
        // Formato para exibir datas/horas
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
        // Construtor de string para montar a representação da requisição
        StringBuilder stringReq = new StringBuilder(cliente.toString());
        if (mesa != null) {
            // Se a requisição estiver associada a uma mesa, adiciona informações sobre a mesa, entrada e saída
            stringReq.append("\n").append(mesa.toString()).append("\n");
            stringReq.append("Entrada em ").append(formato.format(entrada)).append("\n");
            if (saida != null)
                stringReq.append("Saída em ").append(formato.format(saida)).append("\n");
        } else {
            // Se a requisição estiver em espera (sem mesa associada), adiciona essa informação
            stringReq.append(" Em espera.");
        }
        // Retorna a string representando a requisição
        return stringReq.toString();
    }
}
