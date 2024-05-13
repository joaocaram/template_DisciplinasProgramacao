@RestController
@RequestMapping("/requisicoes")
public class RequisicaoController {

    private final RequisicaoService requisicaoService;

    public RequisicaoController(RequisicaoService requisicaoService) {
        this.requisicaoService = requisicaoService;
    }

    @GetMapping
    public ResponseEntity<List<Requisicao>> getRequisicoes() {
        List<Requisicao> requisicoes = requisicaoService.findAll();
        return ResponseEntity.ok(requisicoes);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Requisicao> getRequisicao(@PathVariable Long id) {
        Requisicao requisicao = requisicaoService.findById(id);
        if (requisicao == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(requisicao);
    }

    @PostMapping
    public ResponseEntity<Requisicao> createRequisicao(@RequestBody Requisicao requisicao) {
        Requisicao createdRequisicao = requisicaoService.save(requisicao);
        return ResponseEntity.created(URI.create("/requisicoes/" + createdRequisicao.getId())).body(createdRequisicao);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Requisicao> updateRequisicao(@PathVariable Long id, @RequestBody Requisicao requisicao) {
        Requisicao updatedRequisicao = requisicaoService.update(id, requisicao);
        if (updatedRequisicao == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(updatedRequisicao);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRequisicao(@PathVariable Long id) {
        requisicaoService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/disponiveis")
    public ResponseEntity<List<Mesa>> getMesasDisponiveis() {
        List<Mesa> mesasDisponiveis = mesaService.findMesasDisponiveis();
        return ResponseEntity.ok(mesasDisponiveis);
    }

    @PostMapping("/atender/{id}")
    public ResponseEntity<Void> atenderRequisicao(@PathVariable Long id) {
        requisicaoService.atenderRequisicao(id);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/finalizar/{id}")
    public ResponseEntity<Void> finalizarRequisicao(@PathVariable Long id) {
        requisicaoService.finalizarRequisicao(id);
        return ResponseEntity.ok().build();
    }
}
