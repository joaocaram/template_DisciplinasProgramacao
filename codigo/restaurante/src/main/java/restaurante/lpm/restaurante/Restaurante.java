package restaurante.lpm.restaurante;

import restaurante.lpm.mesa.Mesa;
import restaurante.lpm.reserva.Reserva;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Optional;
import java.util.stream.Stream;

public class Restaurante {
    public Reserva[] getAlocados() {
        return alocados;
    }

    public void setAlocados(Reserva[] alocados) {
        this.alocados = alocados;
    }

    public Reserva[] getFilaDeEspera() {
        return filaDeEspera;
    }

    public void setFilaDeEspera(Reserva[] filaDeEspera) {
        this.filaDeEspera = filaDeEspera;
    }

    public Mesa[] getMesas() {
        return mesas;
    }

    public void setMesas(Mesa[] mesas) {
        this.mesas = mesas;
    }

    private Reserva[] alocados;
    private Reserva[] filaDeEspera;
    private Mesa[] mesas;

    /**
     * verificar se há alguma mesa disponível para atender o número de pessoas
     * @param nPessoas - número de pessoas da reserva
     * @return mesa disponível (caso não haja, retorna null)
     */
    public Optional<Mesa> checarDisponibilidadeMesas(int nPessoas) {
        Stream<Mesa> mesasDisponiveis = Arrays.stream(mesas).filter(mesa -> mesa.getDisponibilidade() && mesa.getCapacidadePessoas() >= nPessoas);
        if (mesasDisponiveis.findAny().isPresent()) {
            return mesasDisponiveis.min(Comparator.comparing(Mesa::getCapacidadePessoas));
        }
        return Optional.empty();
    }

    /**
     * destinar o cliente para a mesa disponível
     * @param reserva - reserva a ser alocada
     * @param mesa - mesa disponível para o cliente
     * @throws Exception - mesa ocupada, ou cliente não encontrado
     */
    public void alocarMesa(Reserva reserva, Mesa mesa) throws Exception {
        try {
            reserva.setIdMesa(mesa.getIdMesa());
            mesa.setDisponibilidade(false);
        } catch (Exception e) {
            throw new Exception("Mesa já alocada para outro cliente");
        }
    }

    /**
     * desalocar o cliente da mesa anteriormente ocupada
     * @param cliente cliente
     * @throws Exception - mesa já desalocada, ou cliente não encontrado
     */
    public void desalocarMesa(int cliente) throws Exception {
        throw new Exception("method not implemented yet");
    }
}
