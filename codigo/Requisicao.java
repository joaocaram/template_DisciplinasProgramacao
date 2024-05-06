import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Requisicao {

	private Cliente cliente;
	private Mesa mesa;
	private int quantPessoas;
	private LocalDateTime entrada;
	private LocalDateTime saida;
	private boolean encerrada;

	public Requisicao(int quantPessoas, Cliente cliente) {
		this.quantPessoas = 1;
		if(quantPessoas > 1 )
			this.quantPessoas = quantPessoas;
		this.cliente = cliente;
		entrada = saida = null;
		mesa = null;
		encerrada = false;
	}

	public Mesa encerrar() {
		saida = LocalDateTime.now();
		mesa.desocupar();
		encerrada = true;
		return mesa;
	}

	public void alocarMesa(Mesa mesa) {
		if(mesa.estahLiberada(quantPessoas)){
			this.mesa = mesa;
			entrada = LocalDateTime.now();
			this.mesa.ocupar();
		}
	}

	public boolean estahEncerrada(){
		return encerrada;
	}

	public boolean ehDaMesa(int idMesa){
		return idMesa == mesa.getIdMesa();
	}

	public int quantPessoas(){
		return quantPessoas;
	}

	public String toString(){
		DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
		StringBuilder stringReq = new StringBuilder(cliente.toString());
		if(mesa!=null){
			stringReq.append("\n"+mesa.toString()+"\n");
			stringReq.append("Entrada em "+ formato.format(entrada)+"\n");
			if(saida!=null)
				stringReq.append("Saída em "+formato.format(saida)+"\n");
		}
		else{
			stringReq.append(" Em espera.");
		}
		return stringReq.toString();
	}
}
