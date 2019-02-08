package model;

public class Product  {

    private String name;
    private int id;
    private double price;


    public Product(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public double getPrice() {
        return price;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setPrice(double price) {
        this.price = price;
    }


    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        if (!super.equals(object)) return false;
        Product product = (Product) object;
        return id == product.id &&
                Double.compare(product.price, price) == 0 &&
                java.util.Objects.equals(name, product.name);
    }

    public int hashCode() {
        return java.util.Objects.hash(super.hashCode(), name, id, price);
    }
}
