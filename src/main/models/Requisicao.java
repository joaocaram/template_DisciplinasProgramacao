@Entity
@Table(name = "requisicoes")
public class Requisicao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "data_hora_entrada")
    private LocalDate dataHoraEntrada;

    @Column(name = "data_hora_saida")
    private LocalDate dataHoraSaida;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;

    @Column(name = "numero_pessoas")
    private int numeroPessoas;

    @Column(name = "atendida")
    private boolean atendida;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "mesa_id")
    private Mesa mesa;

    
    @OneToMany(mappedBy = "requisicao", cascade = CascadeType.ALL)
    private List<Pedido> pedidos = new ArrayList<>();

    }
