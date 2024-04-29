

import java.time.Duration;
import java.time.LocalDateTime;

public class TesteRequisicao {
    
	public static void main(String[] args) {
        Cliente cliente = new Cliente("João", 1);

        Requisicao requisicao = new Requisicao(1, cliente.getIdCliente(), 4, LocalDateTime.now());

        boolean alocado = requisicao.alocarCliente(cliente, 4);

        if (alocado) {
            System.out.println("Cliente alocado.");
        } else {
            System.out.println("Não foi possível alocar o cliente.");
        }

        requisicao.encerrarRequisicao();
        System.out.println("Requisição encerrada.");

        if (requisicao.isAtendida()) {
            Duration duracao = requisicao.calcularDuracao();
            long segundos = duracao.getSeconds();
            long horas = segundos / 3600;
            long minutos = (segundos % 3600) / 60;
            segundos = segundos % 60;
            System.out.println("Duração da estadia do cliente: " + horas + " horas, " + minutos + " minutos e " + segundos + " segundos.");
        } else {
            System.out.println("A requisição ainda não foi atendida.");
        }
    }
}
