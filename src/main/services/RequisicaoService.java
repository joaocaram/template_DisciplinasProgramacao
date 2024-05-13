@Service
public class RequisicaoService {

    @Autowired
    private RequisicaoRepository requisicaoRepository;

    @Autowired
    private MesaService mesaService;

    public List<Requisicao> findAll() {
        return requisicaoRepository.findAll();
    }

    public Requisicao findById(Long id) {
        return requisicaoRepository.findById(id).orElse(null);
    }
    
    public Requisicao save(Requisicao requisicao) {
        Mesa mesa = mesaService.findMesaDisponivel(requisicao.getNumeroPessoas());
        if (mesa != null) {
            requisicao.setMesa(mesa);
            mesa.setOcupada(true);
        }
        return requisicaoRepository.save(requisicao);
    }
    
    public Requisicao update(Long id, Requisicao requisicao) {
        Requisicao existingRequisicao = findById(id);
        if (existingRequisicao != null) {
            existingRequisicao.setDataHoraEntrada(requisicao.getDataHoraEntrada());
            existingRequisicao.setDataHoraSaida(requisicao.getDataHoraSaida());
            existingRequisicao.setCliente(requisicao.getCliente());
            existingRequisicao.setNumeroPessoas(requisicao.getNumeroPessoas());
            existingRequisicao.setAtendida(requisicao.isAtendida());
            return requisicaoRepository.save(existingRequisicao);
        }
        return null;
    }
    
    public void deleteById(Long id) {
        requisicaoRepository.deleteById(id);
    }
    
    public void atenderRequisicao(Long id) {
        Requisicao requisicao = findById(id);
        if (requisicao != null) {
            requisicao.setAtendida(true);
            requisicaoRepository.save(requisicao);
        }
    }
    
    public void finalizarRequisicao(Long id) {
        Requisicao requisicao = findById(id);
        if (requisicao != null) {
            requisicao.setDataHoraSaida(LocalDate.now());
            requisicao.getMesa().setOcupada(false);
            requisicaoRepository.save(requisicao);
        }
    }
    
    private Mesa findMesaDisponivel(int numeroPessoas) {
        List<Mesa> mesasDisponiveis = mesaService.findMesasDisponiveis();
        for (Mesa mesa : mesasDisponiveis) {
            if (mesa.getCapacidade() >= numeroPessoas) {
                return mesa;
            }
        }
        return null;
    }
}    
