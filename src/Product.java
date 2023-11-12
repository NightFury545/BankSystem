public class Product {

    private final String productName;
    private final double price;

    private final int indexInTheList;

    public Product(String productName, double price, int indexInTheList) {
        this.productName = productName;
        this.price = price;
        this.indexInTheList = indexInTheList;
    }

    @Override
    public String toString() {
        return indexInTheList + ". " + "Назва продукту: " + productName + "; Ціна продукту: "
            + price;
    }

    public String getProductName() {
        return productName;
    }

    public double getPrice() {
        return price;
    }

    public int getIndexInTheList() {
        return this.indexInTheList;
    }

}
