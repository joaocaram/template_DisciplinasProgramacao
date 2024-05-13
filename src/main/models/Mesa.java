@Entity
@Table(name = "mesas")
public class Mesa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "numero")
    private int numero;

    @Column(name = "capacidade")
    private int capacidade;

    @Column(name = "ocupada")
    private boolean ocupada;

}
