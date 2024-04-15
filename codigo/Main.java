import java.time.LocalTime;
    public static void main(String[] args) {
        //Instanciar Clientes com Nome e Celular
        Cliente cliente1 = new Cliente("João Antônio", "965843209");

        //Criando a requisição do Cliente
        Requisicao requisicao1 = new Requisicao(cliente1);

        //Cliente diz qual o número de mesas
        requisicao1.requerirMesa(4);

        // Criando instâncias de mesas
        Mesa mesa1 = new Mesa();
        mesa1.setCapacidade(4);

        // Criando uma instância de restaurante
        Restaurante restaurante = new Restaurante();

        // Adicionando as requisições à fila de atendimento do restaurante
        restaurante.adicionarRequisicao(requisicao1);

        // Realizando a alocação de mesas
        restaurante.alocarMesa();

        // Imprimindo informações sobre as mesas após a alocação
        System.out.println("Mesa 1 está ocupada? " + mesa1.estaOcupada());

        // Fechando a conta da mesa 1
        restaurante.fecharConta(mesa1);

        // Adicionando as requisições ao histórico de atendimento do restaurante
        restaurante.adicionarAoHistorico(requisicao1);
    }


