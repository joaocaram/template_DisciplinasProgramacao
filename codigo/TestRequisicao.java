import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class TestRequisicao {

    @Test
    public void testGetQuantidadePessoas() {
        Cliente cliente = new Cliente("Fulano", "123456789", "123.456.789-10");
        Requisicao requisicao = new Requisicao(cliente, 5);
        assertEquals(5, requisicao.getQuantidadePessoas());
    }

    @Test
    public void testRequerirMesa() {
        Cliente cliente = new Cliente("Ciclano", "987654321", "987.654.321-00");
        Requisicao requisicao = new Requisicao(cliente, 3);
        assertEquals(3, requisicao.getQuantidadePessoas());
        requisicao.requerirMesa(4);
        assertEquals(3, requisicao.getQuantidadePessoas());
        requisicao.requerirMesa(2);
        assertEquals(2, requisicao.getQuantidadePessoas());
    }
}
