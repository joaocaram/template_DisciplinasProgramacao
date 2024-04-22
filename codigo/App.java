import java.util.Scanner;

public class App {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Restaurante restaurante = new Restaurante();
        int opcao;


        do {
            System.out.println("\nEscolha uma opção:");
            System.out.println("1. Cadastrar cliente");
            System.out.println("2. Criar nova requisição");
            System.out.println("3. Mostrar fila de atendimento");
            System.out.println("4. Mostrar menu");
            System.out.println("5. Preencher pedido");
            System.out.println("6. Fechar Conta");
            System.out.println("7. Sair");

            opcao = scanner.nextInt();

            switch (opcao) {

                case 1:   // Cadastrar cliente.
/* 

Scanear primeiro  cpf, manda para um if e vê se o cara já existe ou não. Se não existir pede o resto dos dados do cara e cria um Cliente, 
se já tiver o cara na lista, pula o if e já vai criar a requisição direto. Com isso funde o case 1 e case 2, o cadastro e criar requisição.
Aí o nome do case seria "Criar/Gerar/Fazer Requisição".
No caso os métodos para ver se o Cliente existe ou não e criar Cliente vai estar dentro da classe Restaurante. Já o construtor da 
Requisição, eu chamo aqui no Main, depois de pedir o número de pessoas.

 */

                String nome,  telContato,  CPF;
                System.out.println("Digite o CPF: ");
                CPF = scanner.next();
                scanner.nextLine();
                if(restaurante.clienteExiste(CPF)){

                    System.out.println("Cliente já possui cadastro.");

                } else{

                    System.out.println("Digite o nome: ");
                    nome = scanner.nextLine();
                    System.out.println("Digite o telefone de contato: ");
                    telContato = scanner.nextLine();
                    // Ele tá pulando esse scan
                    restaurante.newCliente(nome, telContato, CPF);

                }

                System.out.println("Deseja requerir uma mesa? Digite 1 para sim ou 0 para não.");
                int continuar = scanner.nextInt();

                if(continuar == 0){
                    break;
                }



                case 2:  
                /* 

                Criar requisição de um cliente já existente. Scaneia o CPF de um cliente, acha o objeto no banco de dados e
                cria a requisição atribuindo-a a ele. Tem que scanear também a quantidade de pessoas, isso tem q ser a primeira pessoa.

                */
                
                String cpf; 
                int quantidadePessoas;

                System.out.println("Digite o CPF: ");
                cpf = scanner.next();
                scanner.nextLine();

                System.out.println("Digite a quantidade de pessoas: ");
                quantidadePessoas = scanner.nextInt();
                
                restaurante.criarRequisicao(cpf, quantidadePessoas); 
                
                break;


                case 3: // Mostrar Fila de Atendimento

                restaurante.mostrarFilaAtendimento();  

                break;


                case 4:// Mostra o menu do restaurante

                Menu.mostrarMenu();

                break;
                

                case 5:  /* Case para preencher o pedido de uma Requisição/Mesa */


                break;


                case 6: // Fechar conta

 /* 
    tem que melhorar os metodos que usa pra fechar a conta, pra fazer o cálculo do pedido já com os 10% e jogar a req pro histórico
    tem que ver também onde que vai chamar o set horaSaida da Requisição, se vai ser aqui no Main (oq pessoalmente acho que não é) ou se 
    vai estar dentro do método fecharConta dentro de Restaurante.
 */
                
 /*  A ser definido ainda:
    A respeito do histórico, seria melhor duas listas com as req, a filaAtendimento e historicoAtendimento, ou fazer uma lista só
    atendimento com um boolean se foi atendido ou não.
 */

                break;

                case 7: // Sair

                    System.out.println("Saindo...");
                    break;

                default:
                    System.out.println("Opção inválida.");
                    break;
            }

        } while (opcao != 7);
        
    scanner.close();
    }
}
