import static org.junit.Assert.*;
import org.junit.Test;
import java.time.LocalDateTime;

public class RequisicaoTest {

    @Test
    public void testAlocarMesa() {
        Cliente cliente = new Cliente("Saulo", "saulinho@gmail.com");
        Mesa mesa = new Mesa(1, 4);
        Requisicao req = new Requisicao(cliente, 3);

        req.alocarMesa(mesa);

        assertTrue("A requisição deve ter a mesa corretamente alocada", req.ehDaMesa(1));
    }

    @Test
    public void testEncerrar() {
        Cliente cliente = new Cliente("Saulo", "saulinho@gmail.com");
        Mesa mesa = new Mesa(1, 4);
        Requisicao req = new Requisicao(cliente, 3);

        req.alocarMesa(mesa);
        req.encerrar();

        assertTrue("A requisição deve estar encerrada", req.estahEncerrada());
    }

    @Test
    public void testQuantPessoas() {
        Cliente cliente = new Cliente("Saulo", "saulinho@gmail.com");
        Requisicao req = new Requisicao(cliente, 3);

        assertEquals("A quantidade de pessoas deve ser 3", 3, req.quantPessoas());
    }
}
