package comidinhasVeg.src.test.java.javaquinho.comidinhasVeg;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;

public class RestauranteTest {
    Cliente cliente;
    Restaurante restaurante;
    Requisicao requisicao;

    @BeforeEach
    public void setUp(){
        cliente = new Cliente("Roberta", "3199999999", "12345678912");
        restaurante = new Restaurante();
    }

    @Test
    public void testCriarRequisicao(){
        restaurante.criarRequisicao("12345678912", 4);
    }

}
