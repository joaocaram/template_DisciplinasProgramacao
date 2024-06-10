package javaquinho.comidinhas.controllers;

import java.util.List;
import java.util.Optional;
import java.net.URI;
import javaquinho.comidinhas.models.Pedido;
import javaquinho.comidinhas.models.Produto;
import javaquinho.comidinhas.repositories.PedidoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
@RequestMapping("/pedidos")
@Validated
public class PedidoController {

    @Autowired
    private PedidoRepository pedidoRepository;

    // Criar novo pedido
    @PostMapping
    public ResponseEntity<Pedido> criarPedido(@RequestBody Pedido pedido) {
        Pedido novoPedido = pedidoRepository.save(pedido);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}").buildAndExpand(novoPedido.getId()).toUri();
        return ResponseEntity.created(uri).body(novoPedido);
    }

    // Puxar todos os pedidos
    @GetMapping
    public ResponseEntity<List<Pedido>> getAllPedidos() {
        List<Pedido> pedidos = pedidoRepository.findAll();
        return ResponseEntity.ok().body(pedidos);
    }

    // Puxar determinado pedido
    @GetMapping("/{pedidoId}")
    public ResponseEntity<Pedido> getPedidoById(@PathVariable Long pedidoId) {
        Optional<Pedido> optionalPedido = pedidoRepository.findById(pedidoId);
        return optionalPedido.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Puxar todos os pedidos do cliente
    @GetMapping("/cliente/{clienteId}")
    public ResponseEntity<List<Pedido>> getPedidosByClienteId(@PathVariable Long clienteId) {
        List<Pedido> pedidos = pedidoRepository.findByClienteId(clienteId);
        return pedidos.isEmpty() ? ResponseEntity.notFound().build() : ResponseEntity.ok().body(pedidos);
    }

    // Atualizar pedido
    @PutMapping("/{pedidoId}/adicionar-produto")
    public ResponseEntity<Pedido> adicionarProdutoAoPedido(
            @PathVariable Long pedidoId,
            @RequestBody Produto produto) {
        Optional<Pedido> optionalPedido = pedidoRepository.findById(pedidoId);
        if (optionalPedido.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        Pedido pedido = optionalPedido.get();
        pedido.getProdutos().add(produto);
        pedidoRepository.save(pedido);

        return ResponseEntity.ok().body(pedido);
    }
}
