package implementationChange;

public class ShoppingCart {
    private Price price;

    public void add(Price price) {
        this.price = price;
    }

    public Price calculateTotalPrice() {
        return price;
    }

    public boolean hasDiscount() {
        return price.getPrice() >= 100;
    }

    public int numberOfProducts() {
        return 1;
    }
}
