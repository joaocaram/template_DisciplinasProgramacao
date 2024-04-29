package restaurante.lpm.pedido;

import restaurante.lpm.opcaoCardapio.OpcaoCardapio;

import java.util.ArrayList;

public class Pedido {

	public int getIdMesa() {
		return idMesa;
	}

	public void setIdMesa(int idMesa) {
		this.idMesa = idMesa;
	}

	public ArrayList<OpcaoCardapio> getItens() {
		return itens;
	}

	public void setItens(ArrayList<OpcaoCardapio> itens) {
		this.itens = itens;
	}

	public double getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(double valoTotal) {
		this.valorTotal = valoTotal;
	}

	public double getTAXA() {
		return TAXA;
	}

	private int idMesa;

	private ArrayList<OpcaoCardapio> itens;

	private double valorTotal;

	private final double TAXA = 0.1;

}
