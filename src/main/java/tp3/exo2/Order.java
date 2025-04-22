package tp3.exo2;

public class Order {
    private Long id;
    private String item;

    public Order(Long id, String item) {
        this.id = id;
        this.item = item;
    }

    public Long getId() {
        return id;
    }

    public String getItem() {
        return item;
    }
}
