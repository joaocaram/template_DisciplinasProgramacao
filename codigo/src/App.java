public class App {
    public static void main(String[] args) {

    Restaurante restaurante = new Restaurante();
    restaurante.iniciarRestaurante(restaurante);


    do {
      System.out.println("Restaurante");
      System.out.println("1 - Adicionar cliente");
      System.out.println("2 - Adicionar pedido");
      System.out.println("3 - Alocar cliente");
      System.out.println("4 - Pagar conta");
      System.out.println("5 - Imprimir lista de requisicoes");
      System.out.println("6 - Sair");
      System.out.println("Digite a opção desejada: ");
      int opcao = Integer.parseInt(System.console().readLine());

      switch (opcao) {
        case 1:
          System.out.println("Digite o nome do cliente: ");
          String nomeCliente = System.console().readLine();
          System.out.println("digite qts pessoas: ");
          int qtdPessoas = Integer.parseInt(System.console().readLine());
          Cliente cliente = new Cliente(nomeCliente);
          restaurante.adicionarRequisicao(cliente, qtdPessoas);
          break;
        case 2:
          restaurante.printCardapio();
          System.out.println("Digite a mesa");
          int idMesaPedido = Integer.parseInt(System.console().readLine());
          do {
            System.out.println("Digite o id do item: ");
            int idItem = Integer.parseInt(System.console().readLine());
            System.out.println("Digite a quantidade: ");
            int quantidade = Integer.parseInt(System.console().readLine());
            Pedido pedido = new Pedido(idItem, quantidade);
            restaurante.addPedidos(idMesaPedido, pedido);
            System.out.println("Deseja adicionar mais itens? (s/n)");
            String continuar = System.console().readLine();
            if (continuar.equals("n")) {
              break;
            }
          } while (true);
          break;
        case 3:
          restaurante.alocarCliente();
          break;
        case 4:
          System.out.println("Digite o id da mesa: ");
          int idMesa = Integer.parseInt(System.console().readLine());
          restaurante.printTotalConta(idMesa);
          restaurante.pagarConta(idMesa);
          break;
        case 5:
          restaurante.printListaRequisicoes();
          break;
        case 6:
          System.exit(0);
          break;
        default:
          System.out.println("Opção inválida");
          break;
      }
    } while (true);
  }


}