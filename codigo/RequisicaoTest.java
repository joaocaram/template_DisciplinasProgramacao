package com.projetoLPM;

import org.junit.jupiter.api.Test;
import java.time.LocalDateTime;
import static org.junit.jupiter.api.Assertions.*;

public class RequisicaoTest {

    @Test
    public void testCalcularDuracao() {
        LocalDateTime dataHoraEntrada = LocalDateTime.of(2024, 4, 22, 10, 0);
        LocalDateTime dataHoraSaida = LocalDateTime.of(2024, 4, 22, 11, 0);

        Requisicao requisicao = new Requisicao(1, null, null, 4, dataHoraEntrada);
        requisicao.encerrarRequisicao();
        requisicao.setDataHoraSaida(dataHoraSaida);

        long duracaoEsperada = 60;
        long duracaoReal = requisicao.calcularDuracao();

        assertEquals(duracaoEsperada, duracaoReal);
    }

    @Test
    public void testAlocarCliente() {
        Cliente cliente = new Cliente(1, "João");
        Mesa mesa = new Mesa(1);

        Requisicao requisicao = new Requisicao(1, cliente, mesa, 4, LocalDateTime.now());
        boolean clienteAlocado = requisicao.alocarCliente(4);

        assertTrue(clienteAlocado);
        assertTrue(requisicao.isAtendida());
    }

    @Test
    public void testEncerrarRequisicao() {
        Requisicao requisicao = new Requisicao(1, null, null, 4, LocalDateTime.now());
        requisicao.encerrarRequisicao();

        assertTrue(requisicao.isAtendida());
        assertNotNull(requisicao.getDataHoraSaida());
    }
}

