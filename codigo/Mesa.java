/**
 * A classe Mesa representa as mesas do sistema de restaurante.
 */
public class Mesa {

    private int id;
    private int capacidade;
    private boolean ocupada;
    private Requisicao requisicao;


    public int getCapacidade() {
        return capacidade;
    }

    public int getId() {
        return id;
    }

    public Requisicao getRequisicao() {
        return requisicao;
    }
    public boolean estaOcupada() {
        return ocupada;
    }

    public void setCapacidade(int capacidade) {
        if (capacidade == 4 || capacidade == 6 ||capacidade == 8 ){
        this.capacidade = capacidade;

    }
    }
  
    public void setOcupada(boolean ocupada) {
        this.ocupada = ocupada;
    }

/**
     * Método para realizar a ação de desocupar a mesa, tornando o @param setOcupada false.
     */
    public boolean desocupar(){
        this.requisicao = null;
        this.setOcupada(false); 
        return !estaOcupada();
    }

    /**
     * Método para realizar a ação de ocupar a mesa, tornando o @param setOcupada true.
     */
    public boolean ocupar(Requisicao requisicao){
       
        this.requisicao = requisicao;
        this.setOcupada(true); 
        return estaOcupada();
    
    
}
}
