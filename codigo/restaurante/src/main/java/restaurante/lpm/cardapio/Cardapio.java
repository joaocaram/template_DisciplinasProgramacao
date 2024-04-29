package restaurante.lpm.cardapio;

import restaurante.lpm.opcaoCardapio.OpcaoCardapio;

import java.util.Scanner;

public class Cardapio {

	public Cardapio() {
		this.bebidas = new OpcaoCardapio[]{
				new OpcaoCardapio("Água", 3, 1),
				new OpcaoCardapio("Copo de suco", 7, 2),
				new OpcaoCardapio("Refrigerante orgânico", 7, 3),
				new OpcaoCardapio("Cerveja vegana", 9, 4),
				new OpcaoCardapio("Taça de vinho vegano", 18, 5)
		};
		this.comidas = new OpcaoCardapio[]{
				new OpcaoCardapio("Moqueca de palmito", 32, 1),
				new OpcaoCardapio("Falafel assado", 20, 2),
				new OpcaoCardapio("Salada primavera com macarrão Konjac", 25, 3),
				new OpcaoCardapio("Escondidinho de inhame", 18, 4),
				new OpcaoCardapio("Strogonoff de cogumelos", 35, 5),
				new OpcaoCardapio("Caçarola de legumes", 22, 6)
		};
	}

	public OpcaoCardapio[] getBebidas() {
		return bebidas;
	}

	public void setBebidas(OpcaoCardapio[] bebidas) {
		this.bebidas = bebidas;
	}

	public OpcaoCardapio[] getComidas() {
		return comidas;
	}

	public void setComidas(OpcaoCardapio[] comidas) {
		this.comidas = comidas;
	}

	private OpcaoCardapio[] bebidas;
	private OpcaoCardapio[] comidas;

	public void exibirCardapio() {
		System.out.println("Deseja exibir o cardápio completo, ou apenas bebidas ou comidas?");
		System.out.println("1- Cardápío completo");
		System.out.println("2 - Bebidas");
		System.out.println("3 - Comidas");

		Scanner scanner = new Scanner(System.in);
		String opcao = scanner.nextLine();
		switch (opcao) {
			case "1":
				this.exibirBebidas();
				this.exibirComidas();
				break;
			case "2":
				this.exibirBebidas();
				break;
			case "3":
				this.exibirComidas();
				break;
			default:
				System.out.println("Opção inválida");
				break;
		}
		scanner.close();
	}

	public void exibirBebidas() {
		for (OpcaoCardapio bebida : this.getBebidas()) {
			System.out.printf("- %s \t R$ %2f \n", bebida.getNome(), bebida.getPreco());
		}
	}

	public void exibirComidas() {
		for (OpcaoCardapio comida : this.getComidas()) {
			System.out.printf("- %s \t R$ %2f \n", comida.getNome(), comida.getPreco());
		}
	}
}
