@Entity
@Table(name = "pedidos")
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "requisicao_id")
    private Requisicao requisicao;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "item_cardapio_id")
    private ItemCardapio itemCardapio;

    @Column(name = "quantidade")
    private int quantidade;

    
}
