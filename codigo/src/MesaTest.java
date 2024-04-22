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

    @Test
    public void testVerificarDisponibilidadeMesaDisponivel() {
        Mesa mesa = new Mesa(1, 4);
    
        boolean disponivel = mesa.isDisponivel();
    
        assertTrue(disponivel);
    }
    
    @Test
    public void testVerificarDisponibilidadeMesaOcupada() {
        Mesa mesa = new Mesa(1, 4);
        mesa.alocarCliente(new Cliente(1, "João", 4));
    
        boolean disponivel = mesa.isDisponivel();
    
        assertFalse(disponivel);
    }
    
    @Test
    public void testVerificarDisponibilidadeMesaDisponivelCapacidadeInsuficiente() {
        Mesa mesa = new Mesa(1, 2);
    
        Cliente cliente = new Cliente(1, "João", 4);
    
        boolean disponivel = mesa.verificarDisponibilidade(cliente.getNumPessoas());
    
        assertFalse(disponivel);
    }
    
    @Test
    public void testAlocarClienteMesaDisponivelCapacidadeSuficiente() {
        Mesa mesa = new Mesa(1, 4);
    
        Cliente cliente = new Cliente(1, "João", 2);
    
        boolean alocado = mesa.alocarCliente(cliente);
    
        assertTrue(alocado);
        assertFalse(mesa.isDisponivel());
    }
    
    @Test
    public void testAlocarClienteMesaIndisponivel() {
        Mesa mesa = new Mesa(1, 4);
        mesa.alocarCliente(new Cliente(1, "João", 4));
    
        Cliente cliente = new Cliente(2, "Maria", 2);
    
        boolean alocado = mesa.alocarCliente(cliente);
    
        assertFalse(alocado);
        assertTrue(mesa.isDisponivel());
    }
    
    @Test
    public void testAdicionarPedidoMesaVazia() {
        Mesa mesa = new Mesa(1, 4);
        Pedido pedido = new Pedido(1, Arrays.asList(new Item("Pizza", 25.0), new Item("Refrigerante", 5.0)));
    
        mesa.adicionarPedido(pedido);
    
        List<Pedido> pedidos = mesa.getPedidos();
        assertEquals(1, pedidos.size());
        assertEquals(pedido, pedidos.get(
    
    

