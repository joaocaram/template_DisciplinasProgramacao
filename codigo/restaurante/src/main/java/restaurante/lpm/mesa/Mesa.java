package restaurante.lpm.mesa;
public class Mesa {

	private int capacidadePessoas;

	private boolean disponibilidade;

	static int mesas = 0;
	private int IdMesa;

	public boolean checarDisponibilidade() {
		return disponibilidade;
	}

	public void alocarCliente() {
		this.disponibilidade = false;

	}

	public void desalocarCliente() {
		this.disponibilidade = true;
	}

	public int getCapacidadePessoas() {
		return capacidadePessoas;
	}

	public void setCapacidadePessoas(int capacidadePessoas) {
		this.capacidadePessoas = capacidadePessoas;
	}

	public int getIdMesa() {
		return this.IdMesa;
	}


	/**
	 * @param capacidadePessoas 
	 * @param disponibilidade   
	 */
	public Mesa(int capacidadePessoas, boolean disponibilidade) {
		if ( capacidadePessoas < 2 ) {
			this.capacidadePessoas = 2;
		} else if ( capacidadePessoas > 2 && capacidadePessoas <= 4) {
			this.capacidadePessoas = 4;
		} else if ( capacidadePessoas > 4 && capacidadePessoas <= 8 ) {
			this.capacidadePessoas = 8;
		} else if ( capacidadePessoas > 8 ) {
			this.capacidadePessoas = 8;
		}
		this.disponibilidade = disponibilidade;
		this.IdMesa = mesas++;
	}

}
