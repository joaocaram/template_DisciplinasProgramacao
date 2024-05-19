package com.calabreso.restaurante.entity;



public class Mesa {

	private static int ultimoID;
	private int idMesa;
	private int capacidade;
	private boolean ocupada;

	static{
		ultimoID = 0;
	}
	public Mesa(int capacidade) {
		this.capacidade = 2;
		if(capacidade>2)
			this.capacidade = capacidade;
		idMesa = ++ultimoID;
		ocupada = false;
	}

	public void ocupar() {
		ocupada = true;
	}

	public void desocupar() {
		ocupada = false;
	}

	public boolean estahLiberada(int quantPessoas) {
		return (quantPessoas <= capacidade && !ocupada);
	}

	public int getIdMesa(){
		return idMesa;
	}
	
	public String toString(){
		String descricao = String.format("Mesa %02d (%d pessoas), ",idMesa, capacidade);
		if(ocupada)
			descricao += "ocupada.";
		else 
			descricao += "liberada.";
		
		return descricao;
	}

}
