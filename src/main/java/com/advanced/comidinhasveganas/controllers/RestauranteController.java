public class RestauranteController {

    private final Restaurante restaurante;

    public RestauranteController() {
        this.restaurante = new Restaurante();
        restaurante.iniciarRestaurante();
    }

    public String listarMesas() {
        return restaurante.printListaMesas();
    }

    public String listarRequisicoes() {
        return restaurante.printListaRequisicoes();
    }

}
