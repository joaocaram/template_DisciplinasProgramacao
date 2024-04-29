package restaurante.lpm.cliente;

import restaurante.lpm.reserva.Reserva;

import java.util.Date;

public class Cliente {

	public int getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Reserva getReserva() {
		return reserva;
	}

	public void setReserva(Reserva reserva) {
		this.reserva = reserva;
	}

	private int idCliente;

	private String nome;

	private Reserva reserva;

	public Cliente(int id, String nome, Reserva reserva) {
		this.idCliente = id;
		this.nome = nome;
		this.reserva = reserva;
	}

	public Reserva fazerReserva(int qtdPessoas) {
		this.reserva = new Reserva(new Date(), qtdPessoas);
		return this.getReserva();
	}
}
