package restaurante.lpm.restaurante;

import restaurante.lpm.mesa.Mesa;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Optional;
import java.util.stream.Stream;

public class Restaurante {
    public String[] getAlocados() {
        return alocados;
    }

    public void setAlocados(String[] alocados) {
        this.alocados = alocados;
    }

    public String[] getFilaDeEspera() {
        return filaDeEspera;
    }

    public void setFilaDeEspera(String[] filaDeEspera) {
        this.filaDeEspera = filaDeEspera;
    }

    public Mesa[] getMesas() {
        return mesas;
    }

    public void setMesas(Mesa[] mesas) {
        this.mesas = mesas;
    }

    private String[] alocados;
    private String[] filaDeEspera;
    private Mesa[] mesas;

    /**
     * verificar se há alguma mesa disponível para atender o número de pessoas
     * @param nPessoas - número de pessoas da reserva
     * @return mesa disponível (caso não haja, retorna null)
     */
    public Optional<Mesa> checarDisponibilidadeMesas(int nPessoas) {
        Stream<Mesa> mesasDisponiveis = Arrays.stream(mesas).filter(mesa -> mesa.checarDisponibilidade() && mesa.getCapacidadePessoas() >= nPessoas);
        if (mesasDisponiveis.findAny().isPresent()) {
            return mesasDisponiveis.min(Comparator.comparing(Mesa::getCapacidadePessoas));
        }
        return null;
    }

    /**
     * destinar o cliente para a mesa disponível
     * @param cliente - cliente a ser alocado
     * @param mesa - mesa disponível para o cliente
     * @throws Exception - mesa ocupada, ou cliente não encontrado
     */
    public void alocarMesa(int cliente, Mesa mesa) throws Exception {
        try {
            mesa.alocarCliente();
        } catch (Exception e) {
            throw new Exception("Mesa já alocada para outro cliente");
        }
    }

    /**
     * desalocar o cliente da mesa anteriormente ocupada
     * @param cliente
     * @throws Exception - mesa já desalocada, ou cliente não encontrado
     */
    public void desalocarMesa(int cliente) throws Exception {
        throw new Exception("method not implemented yet");
    }
}
