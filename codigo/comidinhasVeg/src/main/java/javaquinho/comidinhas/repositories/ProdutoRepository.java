package javaquinho.comidinhas.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javaquinho.comidinhas.models.Produto;

@Repository
public interface ProdutoRepository  extends JpaRepository<Produto, Long>{
    
}
