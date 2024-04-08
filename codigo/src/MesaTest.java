import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

// Implementação fake da classe Cliente
class Cliente {
    private int id;
    private String nome;
    private int numPessoas;

    public Cliente(int id, String nome, int numPessoas) {
        this.id = id;
        this.nome = nome;
        this.numPessoas = numPessoas;
    }

    public int getNumPessoas() {
        return numPessoas;
    }
}

// Implementação fake da classe Requisicao
class Requisicao {
    private Cliente cliente;

    public Requisicao(Cliente cliente) {
        this.cliente = cliente;
    }

    public Cliente getCliente() {
        return cliente;
    }
}

public class MesaTest {
    @Test
    public void testVerificarDisponibilidadeMesaDisponivel() {
        Mesa mesa = new Mesa(1, 4);
        mesa.setDisponivel(true);

        boolean disponivel = mesa.verificarDisponibilidade();

        assertTrue(disponivel);
    }

    @Test
    public void testVerificarDisponibilidadeMesaOcupada() {
        Mesa mesa = new Mesa(1, 4);
        mesa.setDisponivel(false);

        boolean disponivel = mesa.verificarDisponibilidade();

        assertFalse(disponivel);
    }

    @Test
    public void testAlocarClienteMesaDisponivelCapacidadeSuficiente() {
        Mesa mesa = new Mesa(1, 4);
        mesa.setDisponivel(true);

        Cliente cliente = new Cliente(1, "João", 2);

        boolean alocado = mesa.alocarCliente(cliente);

        assertTrue(alocado);
        assertFalse(mesa.isDisponivel());
        assertEquals(cliente, mesa.getCliente());
    }

    @Test
    public void testAlocarClienteMesaIndisponivel() {
        Mesa mesa = new Mesa(1, 4);
        mesa.setDisponivel(false);

        Cliente cliente = new Cliente(1, "João", 2);

        boolean alocado = mesa.alocarCliente(cliente);

        assertFalse(alocado);
        assertTrue(mesa.isDisponivel());
        assertNull(mesa.getCliente());
    }

    @Test
    public void testAlocarClienteMesaDisponivelCapacidadeInsuficiente() {
        Mesa mesa = new Mesa(1, 2);
        mesa.setDisponivel(true);

        Cliente cliente = new Cliente(1, "João", 4);

        boolean alocado = mesa.alocarCliente(cliente);

        assertFalse(alocado);
        assertTrue(mesa.isDisponivel());
        assertNull(mesa.getCliente());
    }
}
