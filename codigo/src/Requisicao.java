

import java.time.Duration;
import java.time.LocalDateTime;

public class Requisicao {
    private int idRequisicao;
    private Cliente cliente;
    private Mesa mesa;
    private int numPessoas;
    private LocalDateTime dataHoraEntrada;
    private LocalDateTime dataHoraSaida;
    private boolean atendida;
    private double conta;

    public Requisicao(int idRequisicao, Cliente cliente, Mesa mesa, int numPessoas, LocalDateTime dataHoraEntrada) {
        this.idRequisicao = idRequisicao;
        this.cliente = cliente;
        this.mesa = mesa;
        this.numPessoas = numPessoas;
        this.dataHoraEntrada = dataHoraEntrada;
        this.dataHoraSaida = null;
        this.atendida = false;
        this.conta = 0.0;
    }

    public long calcularDuracao() {
        if (dataHoraSaida != null) {
            Duration duracao = Duration.between(dataHoraEntrada, dataHoraSaida);
            return duracao.toMinutes();
        } else {
            return 0;
        }
    }

    public boolean alocarCliente(int numPessoasDesejadas) {
        if (!atendida && numPessoasDesejadas <= numPessoas) {
            atendida = true;
            return true;
        }
        return false;
    }

    public void encerrarRequisicao() {
        if (!atendida) {
            atendida = true;
            dataHoraSaida = LocalDateTime.now();
        }
    }

    public int getIdRequisicao() {
        return idRequisicao;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public Mesa getMesa() {
        return mesa;
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
    
    public void setDataHoraSaida(LocalDateTime dataHoraSaida) {
        this.dataHoraSaida = dataHoraSaida;
    }


    public boolean isAtendida() {
        return atendida;
    }

    public void setAtendida(boolean atendida) {
        this.atendida = atendida;
    }

    public double getConta() {
        return conta;
    }

    public void setConta(double conta) {
        this.conta = conta;
    }
}
