public class Mesa {

    private int idMesa;
    private int capacidade;
    private boolean disponivel;

    public Mesa(int idMesa, int capacidade) {
        this.idMesa = idMesa;
        this.capacidade = capacidade;
        this.disponivel = true;
    }

    public int getIdMesa() {
        return idMesa;
    }

    public int getCapacidade() {
        return capacidade;
    }

    public boolean isDisponivel() {
        return disponivel;
    }

    public void setDisponivel(boolean disponivel) {
        this.disponivel = disponivel;
    }

    public boolean verificarDisponibilidade() {
        return isDisponivel();
    }

    public boolean alocarCliente(Cliente cliente) {
        if (isDisponivel() && cliente.getNumPessoas() <= getCapacidade()) {
            setDisponivel(false);
            return true;
        }
        return false;
    }
}
