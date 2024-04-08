import java.util.List;
import java.util.Queue;

public class Restaurante {
    private int mesas;
    private Queue<Cliente> filaEspera;

    public Restaurante(int mesas, Queue<Cliente> filaEspera) {
        this.mesas = mesas;
        this.filaEspera = filaEspera;
    }

    public boolean alocarMesa() {
        if (mesas > 0) {
            mesas--;
            return true;
        } else {
            return false;
        }
    }

    public int getMesas() {
        return mesas;
    }

    public void setMesas(int mesas) {
        this.mesas = mesas;
    }

    public int getFilaEsperaSize() {
        return filaEspera.size();
    }

    public boolean isFilaEsperaEmpty() {
        return filaEspera.isEmpty();
    }

    public void adicionarClienteFilaEspera(Cliente cliente) {
        filaEspera.add(cliente);
    }

    public Cliente proxNaFila() {
        return filaEspera.peek();
    }

    // Outros métodos, getters e setters conforme necessário
}
