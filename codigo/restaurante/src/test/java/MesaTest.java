import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import restaurante.lpm.mesa.Mesa;

public class MesaTest {
    @Test
   
    public void criaMesaValidaCapacidade(){
        Mesa mesa = new Mesa(-558, true);
        assertEquals(2, mesa.getCapacidadePessoas());
        mesa = new Mesa(3, true);
        assertEquals(4, mesa.getCapacidadePessoas());
        mesa = new Mesa(7, true);
        assertEquals(8, mesa.getCapacidadePessoas());
        mesa = new Mesa(9, true);
        assertEquals(8, mesa.getCapacidadePessoas());

    }

}
