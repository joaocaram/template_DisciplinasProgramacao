package restaurante.lpm.restaurante;

import restaurante.lpm.mesa.Mesa;
import restaurante.lpm.reserva.Reserva;
import restaurante.lpm.cardapio.Cardapio;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Optional;
import java.util.stream.Stream;

public class Restaurante {
    private Reserva[] alocados;
    private Reserva[] filaDeEspera;
    private Mesa[] mesas;
    private Cardapio cardapio;

    public Restaurante() {
        this.cardapio = new Cardapio();
        this.alocados = new Reserva[0];
        this.filaDeEspera = new Reserva[0];
        this.mesas = new Mesa[0];
    }

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

    public Cardapio getCardapio() {
        return cardapio;
    }

    public void setCardapio(Cardapio cardapio) {
        this.cardapio = cardapio;
    }

    public Optional<Mesa> checarDisponibilidadeMesas(int nPessoas) {
        Stream<Mesa> mesasDisponiveis = Arrays.stream(mesas).filter(mesa -> mesa.getDisponibilidade() && mesa.getCapacidadePessoas() >= nPessoas);
        if (mesasDisponiveis.findAny().isPresent()) {
            return mesasDisponiveis.min(Comparator.comparing(Mesa::getCapacidadePessoas));
        }
        return Optional.empty();
    }

    public void alocarMesa(Reserva reserva, Mesa mesa) throws Exception {
        try {
            reserva.setIdMesa(mesa.getIdMesa());
            mesa.setDisponibilidade(false);
        } catch (Exception e) {
            throw new Exception("Mesa já alocada para outro cliente");
        }
    }

    public void desalocarMesa(int cliente) throws Exception {
        throw new Exception("method not implemented yet");
    }

    public void exibirCardapio() {
        this.cardapio.exibirCardapio();
    }
}

