package javaquinho.comidinhas.controllers;

import javaquinho.comidinhas.models.Pedido;
import javaquinho.comidinhas.repositories.PedidoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/pedidos")
public class PedidoController {

    private final PedidoRepository pedidoRepository;

    @Autowired
    public PedidoController(PedidoRepository pedidoRepository) {
        this.pedidoRepository = pedidoRepository;
    }

    @PostMapping
    public Pedido criarPedido(@RequestBody Pedido pedido) {
        return pedidoRepository.save(pedido);
    }

    @GetMapping("/{id}")
    public Pedido buscarPedido(@PathVariable Long id) {
        return pedidoRepository.findById(id)
            .orElseThrow(() -> new IllegalArgumentException("Pedido não encontrado"));
    }
}
