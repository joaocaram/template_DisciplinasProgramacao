@RestController
@RequestMapping("/mesas")
public class MesaController {

    private final MesaService mesaService;

    public MesaController(MesaService mesaService) {
        this.mesaService = mesaService;
    }

    @GetMapping
    public ResponseEntity<List<Mesa>> getMesas() {
        List<Mesa> mesas = mesaService.findAll();
        return ResponseEntity.ok(mesas);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Mesa> getMesa(@PathVariable Long id) {
        Mesa mesa = mesaService.findById(id);
        if (mesa == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(mesa);
    }

    @PostMapping
    public ResponseEntity<Mesa> createMesa(@RequestBody Mesa mesa) {
        Mesa createdMesa = mesaService.save(mesa);
        return ResponseEntity.created(URI.create("/mesas/" + createdMesa.getId())).body(createdMesa);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Mesa> updateMesa(@PathVariable Long id, @RequestBody Mesa mesa) {
        Mesa updatedMesa = mesaService.update(id, mesa);
        if (updatedMesa == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(updatedMesa);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMesa(@PathVariable Long id) {
        mesaService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
