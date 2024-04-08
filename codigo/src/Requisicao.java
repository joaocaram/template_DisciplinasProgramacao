import java.time.LocalDateTime;

public class Requisicao {
    private static int contadorId = 1; // Para gerar IDs únicos automaticamente

    private int idRequisicao;
    private int idCliente;
    private int numPessoas;
    private LocalDateTime dataHoraEntrada;
    private LocalDateTime dataHoraSaida;

    public Requisicao(int idCliente, int numPessoas) {
        this.idRequisicao = contadorId++;
        this.idCliente = idCliente;
        this.numPessoas = numPessoas;
        this.dataHoraEntrada = LocalDateTime.now();
    }

    public int getIdCliente() {
        return idCliente;
    }

    public int getNumPessoas() {
        return numPessoas;
    }

    public LocalDateTime getDataHoraEntrada() {
        return dataHoraEntrada;
    }

    public LocalDateTime getDataHoraSaida() {
        return dataHoraSaida;
    }

    public int getIdRequisicao() {
        return idRequisicao;
    }

    public void encerrarRequisicao() {
        this.dataHoraSaida = LocalDateTime.now();
    }

}