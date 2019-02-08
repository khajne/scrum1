package repositories;

import model.Product;

import java.util.ArrayList;
import java.util.List;

public class ProductRepository implements Repository<Product> {
    public static ProductRepository INSTANCE = new ProductRepository();

    private int nextFreeId = 0;
    private List<Product> productsList= new ArrayList<>();





    public Product getById(int id) {
        Product productFromDB = productsList.stream()
                .filter(t1 -> t1.getId() == id)
                .findAny()
                .orElse(null);

        if (productFromDB == null) {
            throw new IllegalArgumentException("Object doesn't exist");
        }
        return  productFromDB;
    }

    @Override
    public List<Product> getAll() {
        return new ArrayList<>(productsList);
    }

    @Override
    public boolean delete(Product product) {
        return productsList.remove(product);
    }

    @Override
    public void deleteAll() {
        productsList.clear();
    }

    @Override
    public int count() {
        return productsList.size();
    }

    @Override
    public boolean create(Product product) {
        product.setId(nextFreeId++);
        return productsList.add(product);
    }

    @Override
    public Product update(Product product) {
        Product productFromDB = productsList.stream()
                .filter(t1 -> t1.getId() == product.getId())
                .findAny()
                .orElse(null);

        if (productFromDB == null) {
            throw new IllegalArgumentException("Object doesn't exist");
        }
        productsList.remove(productFromDB);
        productsList.add(product);

        return productsList.get(productsList.size()-1);
    }
}




















