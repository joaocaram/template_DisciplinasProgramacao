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
    public void testVerificarDisponibilidadeMesaDisponivelSemOcupacao() {
    Mesa mesa = new Mesa(1, 4);

    boolean disponivel = mesa.verificarDisponibilidade();

    assertTrue(disponivel);
    }

    @Test
    public void testVerificarDisponibilidadeMesaOcupadaComOcupacaoTotal() {
    Mesa mesa = new Mesa(1, 4);
    mesa.alocarCliente(new Cliente(1, "João", 4));

    boolean disponivel = mesa.verificarDisponibilidade();

    assertFalse(disponivel);
    }

    @Test
    public void testVerificarDisponibilidadeMesaOcupadaComOcupacaoParcial() {
    Mesa mesa = new Mesa(1, 4);
    mesa.alocarCliente(new Cliente(1, "João", 2));

    boolean disponivel = mesa.verificarDisponibilidade(2);

    assertFalse(disponivel);
    assertTrue(mesa.verificarDisponibilidade(1));
    }

    @Test
    public void testAlocarClienteMesaDisponivelCapacidadeSuficiente() {
    Mesa mesa = new Mesa(1, 4);

    Cliente cliente = new Cliente(1, "João", 2);

    boolean alocado = mesa.alocarCliente(cliente);

    assertTrue(alocado);
    assertFalse(mesa.isDisponivel());
    assertEquals(cliente.getNumPessoas(), mesa.getOcupacaoAtual()); 
    }

    @Test
    public void testAlocarClienteMesaIndisponivel() {
    Mesa mesa = new Mesa(1, 4);
    mesa.alocarCliente(new Cliente(1, "João", 4));

    Cliente cliente = new Cliente(2, "Maria", 2);

    boolean alocado = mesa.alocarCliente(cliente);

    assertFalse(alocado);
    assertTrue(mesa.isDisponivel());
    assertEquals(0, mesa.getOcupacaoAtual());
    }   

    @Test
    public void testAlocarClienteMesaDisponivelCapacidadeInsuficiente() {
    Mesa mesa = new Mesa(1, 2);

    Cliente cliente = new Cliente(1, "João", 4);

    boolean alocado = mesa.alocarCliente(cliente);

    assertFalse(alocado);
    assertTrue(mesa.isDisponivel());
    assertEquals(0, mesa.getOcupacaoAtual());

    @Test
    public void testAlocarClientesEmMesasDiferentes() {
        Restaurante restaurante = new Restaurante();

        Cliente cliente1 = new Cliente(1, "João", 2);
        Cliente cliente2 = new Cliente(2, "Maria", 4);
        Cliente cliente3 = new Cliente(3, "Pedro", 3);

        assertTrue(restaurante.alocarMesa(new Requisicao(cliente1)));
        assertTrue(restaurante.alocarMesa(new Requisicao(cliente2)));
        assertTrue(restaurante.alocarMesa(new Requisicao(cliente3)));

        for (Mesa mesa : restaurante.getMesas()) {
            assertFalse(mesa.isDisponivel());
            assertNotNull(mesa.getCliente());
        }
    }
}

