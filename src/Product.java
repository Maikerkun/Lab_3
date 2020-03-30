public class Product {
    private int id;
    private String name;
    private double price;
    private String category;

    public Product(int id, String name, double price, String category) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.category = category;
    }
    public String getCategory(){
        return category;
    }

    @Override
    public String toString() {
        return id + " | " + name + " | " + category + " | " + price + "\n";
    }
}
