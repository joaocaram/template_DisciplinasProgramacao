import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.time.LocalDate;
import java.time.LocalTime;

class RequisicaoTest {

    @Test
    void testEncerrarRequisicaoJaEncerrada() {
        Cliente cliente = new Cliente("Cliente1");
        Mesa mesa = new Mesa(1);
        Requisicao req = new Requisicao(cliente, LocalDate.now(), LocalTime.of(14, 0), 4);
        req.alocarMesa(mesa);
        req.encerrar(LocalTime.of(15, 0));

        assertThrows(IllegalStateException.class, () -> req.encerrar(LocalTime.of(16, 0)),
                     "Deveria lançar uma exceção ao tentar encerrar uma requisição já encerrada");
    }

    @Test
    void testAlocarMesaQuandoJaAlocada() {
        Cliente cliente = new Cliente("Cliente1");
        Mesa mesa1 = new Mesa(1);
        Mesa mesa2 = new Mesa(2);
        Requisicao req = new Requisicao(cliente, LocalDate.now(), LocalTime.of(14, 0), 4);
        req.alocarMesa(mesa1);
        req.alocarMesa(mesa2);
        
        assertEquals(2, req.getMesa().getId(), "A mesa deveria ser atualizada para a nova mesa");
    }

    @Test
    void testEhDaMesaSemMesaAlocada() {
        Cliente cliente = new Cliente("Cliente1");
        Requisicao req = new Requisicao(cliente, LocalDate.now(), LocalTime.of(14, 0), 4);

        assertFalse(req.ehDaMesa(1), "Deveria retornar false já que nenhuma mesa foi alocada");
    }

    @Test
    void testEncerrarComHoraSaidaAntesDeHoraEntrada() {
        Cliente cliente = new Cliente("Cliente1");
        Requisicao req = new Requisicao(cliente, LocalDate.now(), LocalTime.of(14, 0), 4);

        assertThrows(IllegalArgumentException.class, () -> req.encerrar(LocalTime.of(13, 0)),
                     "Deveria lançar uma exceção quando a hora de saída é antes da hora de entrada");
    }
}
