package javaquinho.comidinhas.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import javaquinho.comidinhas.models.Menu;

@Repository
public interface MenuRepository extends JpaRepository<Menu, Long> {
}
