import org.junit.Test;
import static org.junit.Assert.assertEquals;
import org.junit.Before;

public class TestCliente {

    private Cliente c;

    @Before
    public void setup(){
        c = new Cliente("João", "123456789");
    }

    @Test
    public void testGetNome() {
        assertEquals("João", c.getNome());
    }

    @Test
    public void testGetTelContato() {
        assertEquals("123456789", c.getTelContato());
    }

    @Test
    public void testSetNome() {
        c.setNome("João Caram");
        assertEquals("João Caram", c.getNome());
    }

    @Test
    public void testSetTelContato() {
        c.setTelContato("222222222");
        assertEquals("222222222", c.getTelContato());
    }
}