import java.util.ArrayList;

public class Restaurante {
    private ArrayList<Mesa> mesas;
    private ArrayList<Requisicao> filaAtendimento;
    private ArrayList<Requisicao> historicoAtendimento;
    private Cliente[] listaClientes;

    public void alocarMesa() {
        Requisicao requisicao;
        boolean alocado = false;
        int indice = 0;

        while (!alocado) {
            requisicao = filaAtendimento.get(indice);
            for (Mesa mesa : mesas) {
                if (mesa.getCapacidade() <= requisicao.getQuantidadePessoas() && !mesa.estaOcupada()) {
                    mesa.ocupar(requisicao);
                    removerRequisicao(requisicao);
                    alocado = true;
                }
            }

            indice++;
        }
    }

    public void adicionarRequisicao(Requisicao requisicao) {
        filaAtendimento.add(requisicao);
    }

    public void fecharConta(Mesa mesa) {
        for (Mesa mesaFila : mesas) {
            if (mesa.equals(mesaFila)) {
                mesa.desocupar();
                return;
            }
        }
    }

    public void adicionarAoHistorico(Requisicao requisicao) {
        historicoAtendimento.add(requisicao);
    }

    public void removerRequisicao(Requisicao requisicao) {
        Double indexRequisicao = indexRequisicao(requisicao);
        filaAtendimento.remove(indexRequisicao.intValue());
    }

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

    public int clienteExiste(String cpf) {
        var index = -1;
        for (Cliente cliente : listaClientes) {
            if (cliente.getCpf() == cpf) {
                return index;
            }

            index++;
        }

        return index;
    }

    public Cliente pesquisaCliente(String cpf){
        Cliente retorno;
        for (Cliente cliente : listaClientes){
            if(cliente.getCpf() == cpf){
                retorno = cliente;
            }
        }

        return retorno;
    }
}