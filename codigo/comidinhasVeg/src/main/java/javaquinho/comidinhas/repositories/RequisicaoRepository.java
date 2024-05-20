package javaquinho.comidinhas.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javaquinho.comidinhas.models.Requisicao;

@Repository
public interface RequisicaoRepository extends JpaRepository<Requisicao, Integer>{
    
}
