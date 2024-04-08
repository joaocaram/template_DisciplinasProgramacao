package Requisicao;

import java.time.Duration;
import java.time.LocalDateTime;

public class Requisicao {
    private int idRequisicao;
    private int idCliente;
    private int numPessoas;
    private LocalDateTime dataHoraEntrada;
    private LocalDateTime dataHoraSaida;
    private boolean atendida;

    public Requisicao(int idRequisicao, int idCliente, int numPessoas, LocalDateTime dataHoraEntrada) {
        this.idRequisicao = idRequisicao;
        this.idCliente = idCliente;
        this.numPessoas = numPessoas;
        this.dataHoraEntrada = dataHoraEntrada;
        this.dataHoraSaida = null;
        this.atendida = false;
    }

    public Duration calcularDuracao() {
        if (dataHoraSaida != null) {
            return Duration.between(dataHoraEntrada, dataHoraSaida);
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
            dataHoraSaida = LocalDateTime.now();
        }
    }

    public int getIdRequisicao() {
        return idRequisicao;
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

    public boolean isAtendida() {
        return atendida;
    }

    public void setAtendida(boolean atendida) {
        this.atendida = atendida;
    }
}


