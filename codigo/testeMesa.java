import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class testeMesa {
    
    @Test
    public void testSetCapacidade() {
        Mesa mesa = new Mesa();
        mesa.setCapacidade(4);
        assertEquals(4, mesa.getCapacidade());
    }


    @Test
    public void testSetCapacidadeInvalida() {
        Mesa mesa = new Mesa();
        mesa.setCapacidade(5); 
        assertEquals(0, mesa.getCapacidade());
    }

    @Test
    public void testOcuparEDesocupar() {
        Mesa mesa = new Mesa();
        Cliente cliente = new Cliente("Roberta", "319987458536");
        Requisicao requisicao = new Requisicao(cliente);

        assertFalse(mesa.estaOcupada());
        assertTrue(mesa.ocupar(requisicao));
        assertTrue(mesa.estaOcupada());

        mesa.desocupar();
        assertFalse(mesa.estaOcupada());
    }

}
