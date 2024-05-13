import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cliente")
public class ClienteController {

    @PostMapping("/criar")
    public Cliente criarCliente(@RequestParam("nome") String nome) {
        return new Cliente(nome);
    }

    @GetMapping("/{id}")
    public Cliente getCliente(@PathVariable("id") int id) {
    }
}

@RestController
@RequestMapping("/pedido")
public class PedidoController {

    @PostMapping("/criar")
    public Pedido criarPedido(@RequestBody Pedido pedido) {
    }

    @GetMapping("/{id}")
    public Pedido getPedido(@PathVariable("id") int id) {
    }
}
