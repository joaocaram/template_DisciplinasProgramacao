public class Cardapio {

    private List<ItemCardapio> itensCardapio;

    public Cardapio() {
        this.itensCardapio = new ArrayList<>();
    }

    public void addItemCardapio(ItemCardapio itemCardapio) {
        this.itensCardapio.add(itemCardapio);
    }

    public void removeItemCardapio(ItemCardapio itemCardapio) {
        this.itensCardapio.remove(itemCardapio);
    }

    public List<ItemCardapio> getItensCardapio() {
        return this.itensCardapio;
    }

    public ItemCardapio getItemCardapio(int index) {
        return this.itensCardapio.get(index);
    }
}
