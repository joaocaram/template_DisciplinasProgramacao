import java.util.Scanner;

public class AtenderClienteCriarRequisicao {

    public static void main(String[] args) {
        // Criar um objeto Scanner para ler os dados do usuário
        Scanner scanner = new Scanner(System.in);

        // Solicitar os dados do cliente ao atendente
        System.out.println("Informe o nome do cliente:");
        String nome = scanner.nextLine();

        System.out.println("Informe o telefone do cliente:");
        String telefone = scanner.nextLine();

        System.out.println("Informe o e-mail do cliente:");
        String email = scanner.nextLine();

        // Solicitar a descrição do problema ao atendente
        System.out.println("Informe a descrição do problema:");
        String descricao = scanner.nextLine();

        // Solicitar a prioridade da requisição ao atendente
        System.out.println("Informe a prioridade da requisição (baixa, média ou alta):");
        String prioridade = scanner.nextLine();

        // Validar os dados informados pelo atendente
        if (nome.isEmpty() || telefone.isEmpty() || email.isEmpty() || descricao.isEmpty() || prioridade.isEmpty()) {
            System.out.println("Dados inválidos. Por favor, informe todos os dados corretamente.");
            return;
        }

        // Criar a requisição no banco de dados
        // ... Código para criar a requisição no banco de dados ...

        // Exibir uma mensagem de sucesso para o atendente
        System.out.println("Requisição criada com sucesso!");
    }
}



