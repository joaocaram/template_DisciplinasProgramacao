
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ClienteTest {

    @Test
    public void testClienteConstruction_SetsNameAndIncrementsId() {
        String expectedName = "John Doe";
        Cliente cliente = new Cliente(expectedName);

        assertEquals(expectedName, cliente.getNome());
        assertEquals(1, cliente.getIdCliente());


        Cliente cliente2 = new Cliente("Jane Smith");

        assertEquals("Jane Smith", cliente2.getNome());
        assertEquals(2, cliente2.getIdCliente()); 
    }

    @Test
    public void testGetNome_ReturnsCorrectName() {
        String expectedName = "Alice";
        Cliente cliente = new Cliente(expectedName);

        assertEquals(expectedName, cliente.getNome());
    }

    @Test
    public void testGetIdCliente_ReturnsUniqueAndSequentialIds() {
        Cliente cliente1 = new Cliente("Bob");
        Cliente cliente2 = new Cliente("Charlie");
        Cliente cliente3 = new Cliente("David");
    
        assertEquals(1, cliente1.getIdCliente());
        assertEquals(2, cliente2.getIdCliente());
        assertEquals(3, cliente3.getIdCliente());
    }

}
    

