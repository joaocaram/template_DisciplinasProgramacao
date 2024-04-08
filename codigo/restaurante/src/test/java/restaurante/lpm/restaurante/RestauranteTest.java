package restaurante.lpm.restaurante;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import restaurante.lpm.mesa.Mesa;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class RestauranteTest {

    private Restaurante restaurante;

    @BeforeEach
    void setUp() {
        restaurante = new Restaurante();
    }

    @Test
    void testeChecarDisponibilidadeMesa() {
        // Arrange
        Mesa mesaDisponivel = new Mesa(4, true); // Supondo que a capacidade da mesa seja 4 e esteja disponível
        Mesa[] mesas = {mesaDisponivel};
        restaurante.setMesas(mesas);

        // Act
        Optional<Mesa> mesa = restaurante.checarDisponibilidadeMesas(3);

        // Assert
        assertTrue(mesa.isPresent());
        assertEquals(mesaDisponivel, mesa.get());
    }

    @Test
    void testeChecarIndisponibilidadeMesa() {
        // Arrange
        Mesa mesaOcupada = new Mesa(2, false);
        Mesa[] mesas = {mesaOcupada};
        restaurante.setMesas(mesas);

        // Act
        Optional<Mesa> mesa = restaurante.checarDisponibilidadeMesas(3);

        // Assert
        assertFalse(mesa.isPresent());
    }

    @Test
    void testeAlocarMesa() throws Exception {
        // Arrange
        Mesa mesaDisponivel = new Mesa(4, true);
        Mesa[] mesas = {mesaDisponivel};
        restaurante.setMesas(mesas);

        // Act
        restaurante.alocarMesa(1, mesaDisponivel);

        // Assert
        assertTrue(mesaDisponivel.checarDisponibilidade());
    }

    @Test
    void testeNaoAlocarMesa() {
        // Arrange
        Mesa mesaOcupada = new Mesa(2, false);
        Mesa[] mesas = {mesaOcupada};
        restaurante.setMesas(mesas);

        // Act & Assert
        assertThrows(Exception.class, () -> restaurante.alocarMesa(1, mesaOcupada));
    }

    @Test
    void testeDesalocarMesa() {
        // Arrange
        // Act
        // Assert
    }

    @Test
    void testeNaoDesalocarMesa() {
        // Arrange
        Mesa mesaDesalocada = new Mesa(2, true); // Mesa inicialmente disponível
        Mesa[] mesas = {mesaDesalocada};
        restaurante.setMesas(mesas);

        // Act & Assert
        assertThrows(Exception.class, () -> restaurante.desalocarMesa(1));
    }
}
