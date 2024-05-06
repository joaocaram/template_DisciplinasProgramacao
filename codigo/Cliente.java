public class Cliente {

	private static int ultimoID;
	private String nomeCliente;
	private int idCliente;

	static{
		ultimoID = 0;
	}

	public Cliente(String nome) {
		if(nome.length() > 2)
			nomeCliente = nome;	
		else 
			nomeCliente = "Cliente anônimo";
		idCliente = ++ultimoID;
	}

	@Override
	public String toString(){
		return String.format("Nome: %s - identificador: %d", nomeCliente, idCliente);
	}

	@Override
	public int hashCode(){
		return idCliente;
	}
}
