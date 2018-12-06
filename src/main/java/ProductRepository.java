import java.util.ArrayList;
import java.util.List;

public class ProductRepository implements Repository<Product> {
    private List<Product> productList = new ArrayList<>();
    public static ProductRepository INSTANCE = new ProductRepository();

    private int id = 0;


    @Override
    public void deleteAll() {
        productList.clear();
    }

    public void print() {
        productList.forEach((Product e) -> System.out.println("Id: " + e.getId() +
                " | ProductName: " + e.getName() + " | Price: " + e.getPrice()));
    }



    public Product getById(int id) {
        Product productFromDB = productList.stream()
                .filter(product1 -> product1.getId() == id)
                .findAny()
                .orElse(null);

        if (productFromDB == null) {
            throw new IllegalArgumentException("Product doesn't exist");
        }
        return  productFromDB;
    }




    @java.lang.Override
    public boolean create(Product product) {
        product.setId(id++);
        return productList.add(product);
    }

    @java.lang.Override
    public Product get(int index) {
        return productList.get(index);
    }

    @java.lang.Override
    public boolean delete(Product product) {
        return productList.remove(product);
    }

    @java.lang.Override
    public Product update(Product product) {
        Product productFromDB = productList.stream()
                .filter(product1 -> product1.getId() == product.getId())
                .findAny()
                .orElse(null);

        if (productFromDB == null) {
            throw new IllegalArgumentException("Product doesn't exist");
        }

        productList.remove(productFromDB);
        productList.add(product);

        return productList.get(productList.size()-1);
    }

    @Override
    public int count() {
        return productList.size();
    }
}




















