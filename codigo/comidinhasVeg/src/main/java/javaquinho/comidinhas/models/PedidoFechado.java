package javaquinho.comidinhas.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import javaquinho.comidinhas.repositories.RequisicaoRepository;

import java.util.ArrayList;
import java.util.List;



@Entity
public class PedidoFechado extends Pedido {

    public double getSomarTotal(int qntPessoas) {
        return qntPessoas * 32;
    }

}
