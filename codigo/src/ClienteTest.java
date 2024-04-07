import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ClienteTest {

    @Test
    public void testGetNome() {
        Cliente cliente = new Cliente("João", 1);
        assertEquals("João", cliente.getNome());
    }

    @Test
    public void testSetNome() {
        Cliente cliente = new Cliente("João", 1);
        cliente.setNome("Maria");
        assertEquals("Maria", cliente.getNome());
    }

    @Test
    public void testGetIdCliente() {
        Cliente cliente = new Cliente("João", 1);
        assertEquals(1, cliente.getIdCliente());
    }

    @Test
    public void testSetIdCliente() {
        Cliente cliente = new Cliente("João", 1);
        cliente.setIdCliente(2);
        assertEquals(2, cliente.getIdCliente());
    }

    @Test
    public void testStatusCliente() {
        Cliente cliente = new Cliente("João", 1);
        assertDoesNotThrow(() -> cliente.statusCliente());
    }
}
