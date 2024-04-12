import java.time.Duration;
import java.time.LocalDateTime;

public class NovaRequisicao {
    private int id;
    private int idCliente;
    private int numPessoas;
    private LocalDateTime entrada;
    private LocalDateTime saida;
    private boolean atendida;

    public NovaRequisicao(int id, int idCliente, int numPessoas, LocalDateTime entrada) {
        this.id = id;
        this.idCliente = idCliente;
        this.numPessoas = numPessoas;
        this.entrada = entrada;
        this.saida = null;
        this.atendida = false;
    }

    public Duration calcularDuracao() {
        if (saida != null) {
            return Duration.between(entrada, saida);
        } else {
            return Duration.ZERO;
        }
    }

    public boolean alocarCliente(Cliente cliente, int numPessoasDesejadas) {
        if (!atendida && numPessoasDesejadas <= numPessoas) {
            atendida = true;
            return true;
        }
        return false;
    }

    public void encerrarRequisicao() {
        if (!atendida) {
            atendida = true;
            saida = LocalDateTime.now();
            Duration duracao = calcularDuracao();
            System.out.println("Requisição encerrada. Duração: " + duracao.toMinutes() + " minutos.");
        }
    }

    public int getId() {
        return id;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public int getNumPessoas() {
        return numPessoas;
    }

    public LocalDateTime getEntrada() {
        return entrada;
    }

    public LocalDateTime getSaida() {
        return saida;
    }

    public boolean isAtendida() {
        return atendida;
    }

    public void setAtendida(boolean atendida) {
        this.atendida = atendida;
    }
}

