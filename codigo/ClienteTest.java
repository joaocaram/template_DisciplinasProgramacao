import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class ClienteTest {

    @Test
    public void testConstrutor() {
        Cliente cliente = new Cliente("Gabriel", 3);
        assertEquals(cliente.getNome(), "Gabriel");
        assertEquals(3, cliente.getNumeroAcompanhantes());
    }
}
