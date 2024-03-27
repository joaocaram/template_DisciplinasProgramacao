
public class Cliente {
    private String nome;
    private int numeroDeAcompanhantes;
    

    public Cliente(String nome, int numeroDeAcompanhantes) {
        this.numeroDeAcompanhantes = numeroDeAcompanhantes;
        this.nome = nome;

    }

    public String getNome(){
        return nome;
    }
    public void setNome(String nome){
        this.nome = nome;
    }

    public int getNumeroAcompanhantes() {
        return numeroDeAcompanhantes;
    }

    public void setNumeroAcompanhantes(int numeroDeAcompanhantes) {
        this.numeroDeAcompanhantes = numeroDeAcompanhantes;
    }
    
}
