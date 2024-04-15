import java.util.ArrayList;

public class Restaurante {
    private ArrayList<Mesa> mesas;
    private ArrayList<Requisicao> filaAtendimento;
    private ArrayList<Requisicao> historicoAtendimento;
    private ArrayList<Cliente> listaClientes;

    /**
     * Método para alocar mesa com a primeira requisição disponível
     */
    public void alocarMesa() {
        Requisicao requisicao;
        boolean alocado = false;
        int indice = 0;

        while (!alocado) {
            requisicao = filaAtendimento.get(indice);
            for (Mesa mesa : mesas) {
                if (mesa.getCapacidade() <= requisicao.getQuantidadePessoas()
                        && !mesa.estaOcupada()) {
                    mesa.ocupar(requisicao);
                    removerRequisicao(requisicao);
                    alocado = true;
                }
            }

            indice++;
        }
    }

    /**
     * Método para adicionar requisição na lista de requisições
     * 
     * @param requisicao requisição que será adicionada a lista
     */
    public void adicionarRequisicao(Requisicao requisicao) {
        filaAtendimento.add(requisicao);
    }

    /**
     * Método para remover requisição na lista de requisições
     * 
     * @param requisicao requisição que será removida da lista
     */
    public void removerRequisicao(Requisicao requisicao) {
        Double indexRequisicao = indexRequisicao(requisicao);
        filaAtendimento.remove(indexRequisicao.intValue());
    }

    /**
     * Método para fechar a conta da mesa indicada
     * 
     * @param mesa mesa que terá a conta fechada
     */
    public void fecharConta(Mesa mesa) {
        for (Mesa mesaFila : mesas) {
            if (mesa.equals(mesaFila)) {
                mesa.desocupar();
                return;
            }
        }
    }

    /**
     * Método para adicionar requisição no histórico de requisições
     * 
     * @param requisicao requisição que será adicionada ao histórico
     */
    public void adicionarAoHistorico(Requisicao requisicao) {
        historicoAtendimento.add(requisicao);
    }

    /**
     * Retorna o index da requisição que estamos procurando na fila de atendimento
     * 
     * @param requisicao requisição que queremos pesquisar o index
     */
    private double indexRequisicao(Requisicao requisicao) {
        Double index = -1d;
        for (Requisicao requisicaoFila : filaAtendimento) {
            if (requisicaoFila.equals(requisicao)) {
                return index;
            }

            index++;
        }

        return index;
    }

    /**
     * Retorna a posição do cliente caso seu cadastro já exista no restaurante
     * 
     * @param cpf cpf do cliente que estamos procurando
     */
    public int clienteExiste(String cpf) {
        var index = -1;
        for (Cliente cliente : listaClientes) {
            if (cliente.getCPF() == cpf) {
                return index;
            }

            index++;
        }

        return index;
    }

    /**
     * Retorna os dados do cliente na posição da fila do atendimento solicitada
     * 
     * @param posicao posicao do cliente que estamos procurando
     */
    private Requisicao getClienteAtendimento (int posicao){
        return filaAtendimento.get(posicao);
    }
}