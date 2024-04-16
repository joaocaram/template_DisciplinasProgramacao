public class reserva {
    private String id;
    private String clienteId;
    private String restauranteId;
    private Date data;
    private int numeroDePessoas;

    public reserva(String id, String clienteId, String restauranteId, Date data, int numeroDePessoas) {
        this.id = id;
        this.clienteId = clienteId;
        this.restauranteId = restauranteId;
        this.data = data;
        this.numeroDePessoas = numeroDePessoas;
    }
}


public class TesteReserva {
    public static void main(String[] args) {
        reserva reserva = new reserva("1", "cliente1", "restaurante1", new Date(), 4);
        System.out.println("Reserva criada com sucesso!");
    }
}
