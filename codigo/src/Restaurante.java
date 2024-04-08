import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Restaurante {
  private List<Mesa> mesas;
  private Queue<Requisicao> filaEspera;
  private List<Requisicao> requisicoesAtendidas;

  public Restaurante() {
    mesas = new ArrayList<>();
    filaEspera = new LinkedList<>();
    requisicoesAtendidas = new ArrayList<>();
  }

  public boolean alocarMesa(Requisicao requisicao) {
    for (Mesa mesa : mesas) {
      if (mesa.verificarDisponibilidade() && mesa.getCapacidade() >= requisicao.getNumPessoas()) {
        mesa.setIdRequisicao(requisicao.getIdRequisicao());
        requisicoesAtendidas.add(requisicao);
        filaEspera.remove(requisicao);
        System.out.println("Requisição atendida com sucesso: " + requisicao.getIdRequisicao());
        return true;
      }
    }
    adicionarClienteFilaEspera(requisicao);
    System.out.println("Requisição adicionada à fila de espera: " + requisicao.getIdRequisicao());
    return false;
  }

  public void liberarMesa(int idRequisicao) {
    for (Mesa mesa : mesas) {
      if (mesa.getIdRequisicao() == idRequisicao) {
        for (Requisicao requisicao : requisicoesAtendidas) {
          if (requisicao.getIdRequisicao() == idRequisicao) {
            requisicao.encerrarRequisicao();
          }
        }
        mesa.setIdRequisicao(-1);
        if (!filaEspera.isEmpty()) {
          alocarMesa(proxNaFila());
        }
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