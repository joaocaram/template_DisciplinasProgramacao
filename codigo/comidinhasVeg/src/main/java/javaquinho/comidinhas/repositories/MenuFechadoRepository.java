package javaquinho.comidinhas.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import javaquinho.comidinhas.models.Menu;
import javaquinho.comidinhas.models.MenuFechado;

@Repository
public interface MenuFechadoRepository extends JpaRepository<MenuFechado, Long> {
}
