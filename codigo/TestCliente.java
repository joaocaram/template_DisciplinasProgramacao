import org.junit.Test;
import static org.junit.Assert.assertEquals;
import org.junit.Before;

public class TestCliente {

    private Cliente c;

    @Before
    public void setup(){
        c = new Cliente("João", "123456789", "23726737356");
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
    public void coletarDadosCliente() {
        assertEquals("Nome: João, Telefone: 123456789", c.dadosCliente());
    }
}
