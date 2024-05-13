@Service
public class MesaService {

    @Autowired
    private MesaRepository mesaRepository;

    public List<Mesa> findAll() {
        return mesaRepository.findAll();
    }

    public Mesa findById(Long id) {
        return mesaRepository.findById(id).orElse(null);
    }

    public Mesa save(Mesa mesa) {
        return mesaRepository.save(mesa);
    }

    public Mesa update(Long id, Mesa mesa) {
        Mesa existingMesa = findById(id);
        if (existingMesa != null) {
            existingMesa.setNumero(mesa.getNumero());
            existingMesa.setCapacidade(mesa.getCapacidade());
            existingMesa.setOcupada(mesa.isOcupada());
            return mesaRepository.save(existingMesa);
        }
        return null;
    }

    public void deleteById(Long id) {
        mesaRepository.deleteById(id);
    }

    public List<Mesa> findMesasDisponiveis() {
        return mesaRepository.findByOcupadaIsFalse();
    }
}
