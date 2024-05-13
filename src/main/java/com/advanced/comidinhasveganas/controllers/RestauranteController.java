import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/restaurant")
public class RestauranteController {

    @Autowired
    private RestauranteService restauranteService;

    @PostMapping("/mesa")
    public ResponseEntity<Void> adicionarMesa(@RequestBody Mesa mesa) {
        restauranteService.adicionarMesa(mesa);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PostMapping("/item-cardapio")
    public ResponseEntity<Void> adicionarItemCardapio(@RequestBody ItemCardapio itemCardapio) {
        restauranteService.adicionarItemCardapio(itemCardapio);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PostMapping("/requisicao")
    public ResponseEntity<Void> adicionarRequisicao(@RequestBody Requisicao requisicao) {
        restauranteService.adicionarRequisicao(requisicao);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping("/mesas")
    public ResponseEntity<List<Mesa>> obterTodasAsMesas() {
        List<Mesa> mesas = restauranteService.getMesas();
        return ResponseEntity.ok().body(mesas);
    }

    @GetMapping("/cardapio")
    public ResponseEntity<List<ItemCardapio>> obterTodoOCardapio() {
        List<ItemCardapio> cardapio = restauranteService.getCardapio();
        return ResponseEntity.ok().body(cardapio);
    }

    @GetMapping("/requisicoes")
    public ResponseEntity<List<Requisicao>> obterTodasAsRequisicoes() {
        List<Requisicao> requisicoes = restauranteService.getRequisicoes();
        return ResponseEntity.ok().body(requisicoes);
    }
}
