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


    public boolean desocupar(){
        this.requisicao = null;
        this.setOcupada(false); 
        return !estaOcupada();
    }
    public boolean ocupar(Requisicao requisicao){
       
        this.requisicao = requisicao;
        this.setOcupada(true); 
        return estaOcupada();
    
    
}
}
