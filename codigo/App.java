public class App {
    public static void main(String[] args) {

        Restaurante restaurante = new Restaurante();
        restaurante.iniciarRestaurante(restaurante);

        do {
            System.out.println("Restaurante");
            System.out.println("1 - Cadastrar Cliente");
            System.out.println("2 - Atender Cliente (Criar Requisição)");
            System.out.println("3 - Sair");
            System.out.println("Digite a opção desejada: ");
            int opcao = Integer.parseInt(System.console().readLine());

            switch (opcao) {
                case 1:
                    System.out.println("Digite o nome do cliente: ");
                    String nomeCliente = System.console().readLine();
                    System.out.println("Digite quantas pessoas: ");
                    int qtdPessoas = Integer.parseInt(System.console().readLine());
                    Cliente cliente = new Cliente(nomeCliente);
                    restaurante.adicionarRequisicao(cliente, qtdPessoas);
                    break;
                case 2:
                    System.out.println("Digite o nome do cliente: ");
                    String nomeClienteAtendimento = System.console().readLine();
                    System.out.println("Digite quantas pessoas: ");
                    int qtdPessoasAtendimento = Integer.parseInt(System.console().readLine());
                    Cliente clienteAtendimento = new Cliente(nomeClienteAtendimento);
                    restaurante.adicionarRequisicao(clienteAtendimento, qtdPessoasAtendimento);
                    break;
                case 3:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Opção inválida");
                    break;
            }
        } while (true);
    }
}
