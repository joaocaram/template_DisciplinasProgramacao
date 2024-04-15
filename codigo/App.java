public class App {
public static void main(String[] args) {
        //Cadastrar Cliente
        Cliente cliente1 = new Cliente("João Antônio", "965843209");

        //Atender cliente/criar requisição
        Requisicao requisicao1 = new Requisicao(cliente1);

        //Cliente diz qual o número pessoas na Mesa
        requisicao1.requerirMesa(4);

        //Criar Mesa
        Mesa mesa1 = new Mesa();
        mesa1.setCapacidade(4);

        //Instância de Restaurante
        Restaurante restaurante = new Restaurante();

        //Adiciona a Requisição à fila
        restaurante.adicionarRequisicao(requisicao1);

        //Aloca a Mesa
        restaurante.alocarMesa();

        //Confirma se a Mesa está ocupada, após alocar 
        System.out.println("Mesa 1 está ocupada? " + mesa1.estaOcupada());

        //Liberar Mesa/Finalizar Requisição
        restaurante.fecharConta(mesa1);

        //Adiciona a Requisição ao Histórico
        restaurante.adicionarAoHistorico(requisicao1);
    }
}


