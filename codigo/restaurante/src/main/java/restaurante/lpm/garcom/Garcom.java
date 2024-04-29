package restaurante.lpm.garcom;

import restaurante.lpm.cardapio.Cardapio;
import restaurante.lpm.opcaoCardapio.OpcaoCardapio;
import restaurante.lpm.pedido.Pedido;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Optional;
import java.util.Scanner;

public class Garcom {
    public Cardapio getCardapio() {
        return cardapio;
    }

    public void setCardapio(Cardapio cardapio) {
        this.cardapio = cardapio;
    }

    public ArrayList<Pedido> getPedidos() {
        return pedidos;
    }

    public void setPedidos(ArrayList<Pedido> pedidos) {
        this.pedidos = pedidos;
    }

    public ArrayList<Pedido> getPedidosAtendidos() {
        return pedidosAtendidos;
    }

    public void setPedidosAtendidos(ArrayList<Pedido> pedidosAtendidos) {
        this.pedidosAtendidos = pedidosAtendidos;
    }

    private Cardapio cardapio;
    private ArrayList<Pedido> pedidos;

    private ArrayList<Pedido> pedidosAtendidos;

    public Garcom() {
        this.cardapio = new Cardapio();
        this.pedidos = new ArrayList<>();
    }

    public void atenderMesa(int idMesa) {
        System.out.println("O que gostaria de fazer?");
        System.out.println("1 - Ver cardápio");
        System.out.println("2 - Fazer pedido");

        Scanner scanner = new Scanner(System.in);
        String opcao = scanner.nextLine();
        switch (opcao) {
            case "1":
                this.getCardapio().exibirCardapio();
                break;
            case "2":
                this.fazerPedido(idMesa);
                break;
            default:
                System.out.println("Opção inválida");
                break;
        }
        scanner.close();
    }

    public void fazerPedido(int idMesa) {
        Pedido pedidoAtual = this.getPedidos().stream().filter(pedido -> idMesa == pedido.getIdMesa()).findFirst().get();
        this.anotarItens(pedidoAtual);
        this.fecharConta(pedidoAtual);
        this.getPedidosAtendidos().add(pedidoAtual);
        this.getPedidos().remove(pedidoAtual);
    }

    public void anotarItens(Pedido pedido) {
        System.out.println("Digite o ID do item que deseja pedir (x para encerrar):");
        Scanner scanner = new Scanner(System.in);
        String opcao = scanner.nextLine();
        do {
            String finalOpcao = opcao;
            Optional<OpcaoCardapio> comida = Arrays.stream(this.getCardapio().getComidas())
                    .filter(opcaoComida -> Integer.toString(opcaoComida.getId()).equals(finalOpcao))
                    .findFirst();
            if (comida.isPresent()) {
                pedido.getItens().add(comida.get());
            } else {
                String finalOpcao1 = opcao;
                Optional<OpcaoCardapio> bebida = Arrays.stream(this.getCardapio().getBebidas())
                        .filter(opcaoBebida -> Integer.toString(opcaoBebida.getId()).equals(finalOpcao1))
                        .findFirst();
                bebida.ifPresent(opcaoCardapio -> pedido.getItens().add(opcaoCardapio));
            }
            System.out.println("Digite o ID do item que deseja pedir (x para encerrar):");
            opcao = scanner.nextLine();
        } while (opcao.equals("x"));
        scanner.close();
    }

    public void fecharConta(Pedido pedido) {
        double valorTotal = 0.0;
        for (OpcaoCardapio item : pedido.getItens()) {
            valorTotal += item.getPreco();
        }
        valorTotal += valorTotal * pedido.getTAXA();
        pedido.setValorTotal(valorTotal);
        System.out.printf("VALOR TOTAL DO PEDIDO: \t R$ %2f \n", valorTotal);
        System.out.print("Por quantas pessoas será dividida a conta? ");
        Scanner scanner = new Scanner(System.in);
        int qtdPesoas = Integer.parseInt(scanner.nextLine());
        System.out.printf("VALOR POR PESSOA: \t R$ %2f \n", valorTotal / qtdPesoas);
    }
}
