package restaurante.lpm.mesa;

public class Mesa {

	public int getCapacidadePessoas() {
		return capacidadePessoas;
	}

	public void setCapacidadePessoas(int capacidadePessoas) {
		this.capacidadePessoas = capacidadePessoas;
	}

	public boolean getDisponibilidade() {
		return disponibilidade;
	}

	public void setDisponibilidade(boolean disponibilidade) {
		this.disponibilidade = disponibilidade;
	}

	public int getIdMesa() {
		return idMesa;
	}

	public void setIdMesa(int idMesa) {
		this.idMesa = idMesa;
	}

	private int capacidadePessoas;
	private boolean disponibilidade;
	private int idMesa;


	/**
	 * @param capacidadePessoas capacidade de pessoas
	 * @param disponibilidade disponibilidade da mesa
	 */
	public Mesa(int idMesa, int capacidadePessoas, boolean disponibilidade) {
		if ( capacidadePessoas < 2 ) {
			this.setCapacidadePessoas(2);
		} else if ( capacidadePessoas > 2 && capacidadePessoas <= 4) {
			this.setCapacidadePessoas(4);
		} else if ( capacidadePessoas > 4 && capacidadePessoas <= 8 ) {
			this.setCapacidadePessoas(8);
		} else if ( capacidadePessoas > 8 ) {
			this.setCapacidadePessoas(8);
		}
		this.setDisponibilidade(disponibilidade);
		this.setIdMesa(idMesa);
	}

}
