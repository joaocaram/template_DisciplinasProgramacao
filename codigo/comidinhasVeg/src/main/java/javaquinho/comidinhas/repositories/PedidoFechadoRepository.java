package javaquinho.comidinhas.repositories;

import javaquinho.comidinhas.models.PedidoFechado;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface PedidoFechadoRepository extends JpaRepository<PedidoFechado, Long> {

    @Query("SELECT p FROM Pedido p WHERE p.cliente.id = :clienteId")
    List<PedidoFechado> findByClienteId(@Param("clienteId") Long clienteId);
}