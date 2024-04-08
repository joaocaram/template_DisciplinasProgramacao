public class Mesa {

    private int idMesa;
    private int capacidade;
    private boolean disponivel;
    private int ocupacaoAtual;

    public Mesa(int idMesa, int capacidade) {
        this.idMesa = idMesa;
        this.capacidade = capacidade;
        this.disponivel = true;
        this.ocupacaoAtual = 0;
    }

    public int getIdMesa() {
        return idMesa;
    }

    public int getCapacidade() {
        return capacidade;
    }

    public boolean isDisponivel() {
        return disponivel && ocupacaoAtual == 0;
    }

    public void setDisponivel(boolean disponivel) {
        this.disponivel = disponivel;
    }

    public int getOcupacaoAtual() {
        return ocupacaoAtual;
    }

    public void setOcupacaoAtual(int ocupacaoAtual) {
        this.ocupacaoAtual = ocupacaoAtual;
    }

    public boolean verificarDisponibilidade(int numPessoas) {
        return isDisponivel() && numPessoas <= getCapacidade();
    }

    public boolean alocarCliente(Cliente cliente) {
        if (verificarDisponibilidade(cliente.getNumPessoas())) {
            setDisponivel(false);
            setOcupacaoAtual(cliente.getNumPessoas());
            return true;
        }
        return false;
    }

    public void desocuparMesa() {
        setDisponivel(true);
        setOcupacaoAtual(0);
    }
}

