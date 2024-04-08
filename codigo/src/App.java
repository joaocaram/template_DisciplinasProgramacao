public class App {
    public static void main(String[] args) {

      Restaurante restaurante = new Restaurante();

      Mesa mesa1 = new Mesa(1, 4);
      Mesa mesa2 = new Mesa(2, 2);

      restaurante.addMesa(mesa1);
      restaurante.addMesa(mesa2);

      System.out.println("Mesas disponíveis: " + restaurante.verificarMesasDisponiveis());
      
      Cliente cliente = new Cliente("João");

      restaurante.alocarMesa(new Requisicao(cliente.getIdCliente(), 4));

      cliente = new Cliente("Maria");

      restaurante.alocarMesa(new Requisicao(cliente.getIdCliente(), 3));

      System.out.println("Mesas disponíveis: " + restaurante.verificarMesasDisponiveis());

      restaurante.liberarMesa(1);

      System.out.println("Mesas disponíveis: " + restaurante.verificarMesasDisponiveis());

    }

}