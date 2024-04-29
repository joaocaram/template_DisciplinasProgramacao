import static org.junit.Assert.assertEquals;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;

public class TestRequisicao {

    private Cliente cliente;

    @BeforeEach
    public void setup(){
        cliente = new Cliente ("Ciclano", "987654321", "987.654.321-00");
    }

    @Test
    public void testGetQuantidadePessoas() {
        Requisicao requisicao = new Requisicao(cliente, 5);
        assertEquals(5, requisicao.getQuantidadePessoas());
    }

    @Test
    public void testRequerirMesa() {
        Requisicao requisicao = new Requisicao(cliente, 3);
        assertEquals(3, requisicao.getQuantidadePessoas());
        requisicao.requerirMesa(4);
        assertEquals(3, requisicao.getQuantidadePessoas());
        requisicao.requerirMesa(2);
        assertEquals(2, requisicao.getQuantidadePessoas());
    }
}
