import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.util.LinkedList;
import java.util.List;

@Entity
@Table(name = Restaurante.TABLE_NAME)
public class Restaurante {

    public static final String TABLE_NAME = "restaurante";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private List<Mesa> mesas;
    private List<Requisicao> filaRequisicoes;

    public Restaurante() {
        this.mesas = new LinkedList<>();
        this.filaRequisicoes = new LinkedList<>();
    }


    public void adicionarMesa(int idMesa, int capacidade) {
        Mesa mesa = new Mesa(idMesa, capacidade);
        mesas.add(mesa);
    }

    public void adicionarRequisicao(Cliente cliente, int numeroDePessoas) {
        Requisicao requisicao = new Requisicao(numeroDePessoas, cliente, null, numeroDePessoas, null);
        filaRequisicoes.add(requisicao);
    }

    public String printListaRequisicoes() {
        StringBuilder resultado = new StringBuilder("Requisições: \n");
        for (Requisicao req : filaRequisicoes) {
            resultado.append(req.toString()).append("\n");
        }
        return resultado.toString();
    }

    public String printListaMesas() {
        StringBuilder resultado = new StringBuilder("Mesas: \n");
        for (Mesa m : mesas) {
            resultado.append(m.toString()).append("\n");
        }
        return resultado.toString();
    }

    public void alocarCliente() {
        for (Requisicao requisicao : filaRequisicoes) {
            if (!requisicao.isAtendida()) {
                for (Mesa mesa : mesas) {
                    if (mesa.getCapacidade() >= requisicao.getNumPessoas() && mesa.getClientesSentados() == 0) {
                        mesa.setClientesSentados(requisicao.getNumPessoas());
                        requisicao.setAtendida(true);
                        requisicao.setMesa(mesa);
                        break;
                    }
                }
            }
        }
    }

    public void iniciarRestaurante() {
        for (int i = 0; i < 10; i++) {
            if (i < 4) {
                adicionarMesa(i, 4);
            } else if (i < 8) {
                adicionarMesa(i, 6);
            } else {
                adicionarMesa(i, 8);
            }
        }
    }
}
