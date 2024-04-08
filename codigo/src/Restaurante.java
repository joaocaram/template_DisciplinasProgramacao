import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Restaurante {
  private List<Mesa> mesas;
  private Queue<Requisicao> filaEspera;

  public Restaurante() {
    mesas = new ArrayList<>();
    filaEspera = new LinkedList<>();
  }

  public boolean alocarMesa(Requisicao requisicao) {
    for (Mesa mesa : mesas) {
      if (mesa.verificarDisponibilidade() && mesa.getCapacidade() >= requisicao.getNumPessoas()) {
        mesa.setIdRequisicao(requisicao.getIdRequisicao());
        filaEspera.remove(requisicao);
        System.out.println("Requisição deu bom: " + requisicao.getIdRequisicao());
        return true;
      }
    }
    adicionarClienteFilaEspera(requisicao);
    System.out.println("Requisição deu ruim: " + requisicao.getIdRequisicao());
    return false;
  }

  public void liberarMesa(int idRequisicao) {
    for (Mesa mesa : mesas) {
      if (mesa.getIdRequisicao() == idRequisicao) {
        Requisicao.encerrarRequisicao();
        mesa.setIdRequisicao(-1);
        if (filaEspera.isEmpty()) {
          return;
        }
        alocarMesa(proxNaFila());
        return;
      }
    }
  }

  public int verificarMesasDisponiveis() {
    int disponiveis = 0;
    for (Mesa mesa : mesas) {
      if (mesa.verificarDisponibilidade()) {
        System.out.println("Mesa disponível: " + mesa.getIdMesa());
        System.out.println("Capacidade: " + mesa.getCapacidade());
        disponiveis++;
      }
    }
    return disponiveis;
  }

  public void adicionarClienteFilaEspera(Requisicao requisicao) {
    filaEspera.add(requisicao);
  }

  public Requisicao proxNaFila() {
    return filaEspera.poll();
  }

  public void addMesa(Mesa mesa) {
    mesas.add(mesa);
  }

  public List<Mesa> getMesas() {
    return mesas;
}

  public Queue<Requisicao> getFilaEspera() {
    return filaEspera;
  }



}