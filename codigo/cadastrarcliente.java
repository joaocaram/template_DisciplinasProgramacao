import java.util.Scanner;

public class CadastrarCliente {

    public static void main(String[] args) {
        // Criar um objeto Scanner para ler os dados do usuário
        Scanner scanner = new Scanner(System.in);

        // Solicitar os dados do cliente ao usuário
        System.out.println("Informe o nome do cliente:");
        String nome = scanner.nextLine();

        System.out.println("Informe o endereço do cliente:");
        String endereco = scanner.nextLine();

        System.out.println("Informe o telefone do cliente:");
        String telefone = scanner.nextLine();

        System.out.println("Informe o e-mail do cliente:");
        String email = scanner.nextLine();

        // Validar os dados informados pelo usuário
        if (nome.isEmpty() || endereco.isEmpty() || telefone.isEmpty() || email.isEmpty()) {
            System.out.println("Dados inválidos. Por favor, informe todos os dados corretamente.");
            return;
        }

        // Cadastrar o cliente no banco de dados
        // ... Código para cadastrar o cliente no banco de dados ...

        // Exibir uma mensagem de sucesso para o usuário
        System.out.println("Cliente cadastrado com sucesso!");
    }
}



