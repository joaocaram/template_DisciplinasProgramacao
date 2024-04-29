import org.junit.Test;
import static org.junit.Assert.*;

public class ClienteTest {

    @Test
    public void testFazerPedido() {
        Cliente cliente = new Cliente(1, "João");
        cliente.fazerPedido("Pizza de pepperoni");

        assertEquals("Pizza de pepperoni", cliente.getPedido());
    }

    @Test
    public void testDeclararQuantidade() {
        Cliente cliente = new Cliente(1, "João");
        cliente.declararQuantidade(5);

        assertEquals(5, cliente.getQuantidade());
    }
}
