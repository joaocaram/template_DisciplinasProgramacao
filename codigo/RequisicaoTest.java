import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.time.LocalDate;
import java.time.LocalTime;

public class RequisicaoTest {

    @Test
    public void testGetNomeCliente() {
        Cliente cliente = new Cliente("João");
        Requisicao requisicao = new Requisicao(cliente, LocalDate.now(), LocalTime.now(), LocalTime.now(), new Mesa(1), 2);

        assertEquals("João", requisicao.getNomeCliente());
    }

    @Test
    public void testGetData() {
        LocalDate data = LocalDate.of(2022, 4, 14);
        Requisicao requisicao = new Requisicao(null, data, null, null, null, 0);

        assertEquals(data, requisicao.getData());
    }

    @Test
    public void testSetSaida() {
        LocalTime horaSaida = LocalTime.of(12, 0);
        Requisicao requisicao = new Requisicao(null, null, null, null, null, 0);

        requisicao.setSaida(horaSaida);
        assertEquals(horaSaida, requisicao.getSaida());
    }

    @Test
    public void testGetNumMesa() {
        Mesa mesa = new Mesa(5);
        Requisicao requisicao = new Requisicao(null, null, null, null, mesa, 0);

        assertEquals(5, requisicao.getNumMesa());
    }

    @Test
    public void testGetNumAcompanhantes() {
        Requisicao requisicao = new Requisicao(null, null, null, null, null, 3);

        assertEquals(3, requisicao.getNumAcompanhantes());
    }

    @Test
    public void testSetNumAcompanhantes() {
        Requisicao requisicao = new Requisicao(null, null, null, null, null, 0);

        requisicao.setNumAcompanhantes(4);
        assertEquals(4, requisicao.getNumAcompanhantes());
    }


}
