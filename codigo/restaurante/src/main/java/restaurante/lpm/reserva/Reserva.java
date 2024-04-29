package restaurante.lpm.reserva;

import java.util.Date;

public class Reserva {
    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public Date getDataHoraEntrada() {
        return dataHoraEntrada;
    }

    public void setDataHoraEntrada(Date dataHoraEntrada) {
        this.dataHoraEntrada = dataHoraEntrada;
    }

    public Date getDataHoraSaida() {
        return dataHoraSaida;
    }

    public void setDataHoraSaida(Date dataHoraSaida) {
        this.dataHoraSaida = dataHoraSaida;
    }

    public int getIdMesa() {
        return idMesa;
    }

    public void setIdMesa(int idMesa) {
        this.idMesa = idMesa;
    }

    public int getnPessoas() {
        return nPessoas;
    }

    public void setnPessoas(int nPessoas) {
        this.nPessoas = nPessoas;
    }

    public boolean isReservaAtendida() {
        return reservaAtendida;
    }

    public void setReservaAtendida(boolean reservaAtendida) {
        this.reservaAtendida = reservaAtendida;
    }

    private int idCliente;
    private Date dataHoraEntrada;
    private Date dataHoraSaida;
    private int idMesa;
    private int nPessoas;
    private boolean reservaAtendida;

    public Reserva(Date dataHoraEntrada, int nPessoas) {
        this.idCliente = 1;
        this.dataHoraEntrada = dataHoraEntrada;
        this.nPessoas = nPessoas;
        this.reservaAtendida = false;
    }

    public Reserva(Date dataHoraEntrada, int idMesa, int nPessoas) {
        this.idCliente = 1;
        this.dataHoraEntrada = dataHoraEntrada;
        this.idMesa = idMesa;
        this.nPessoas = nPessoas;
        this.reservaAtendida = false;
    }

    public void finalizarReserva() {
        this.reservaAtendida = true;
        this.dataHoraSaida = new Date();
    }

    public void alocarMesa(int idMesa) {
        this.setIdMesa(idMesa);
    }
}
