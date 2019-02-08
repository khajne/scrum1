package repositories;

import model.Product;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import repositories.ProductRepository;

import java.util.List;

import static org.junit.Assert.*;

public class ProductRepositoryTest {

    private static final String PRODUCT_TEST_NAME = "Ignition Coil";
    private static final double PRODUCT_TEST_PRICE = 250;
    private ProductRepository productRepository = ProductRepository.INSTANCE;
    private Product product;



    @Before
    public void setup(){
        productRepository = new ProductRepository();
        product = new Product(PRODUCT_TEST_NAME, PRODUCT_TEST_PRICE);
        productRepository.create(product);
    }

    @After
    public void reset (){
        productRepository.deleteAll();
    }

    @Test
    public void create() {
        assertEquals(1, productRepository.count());
    }

    @Test
    public void delete() {
        assertTrue(productRepository.delete(product));
    }

    @Test
    public void update() {
        Product product2 = new Product("Engine liquid", 32);
        productRepository.create(product2);
        Product productTmp = new Product("Engine Super liquid", 42);
        productTmp.setId(1);
        Product updated = productRepository.update(productTmp);
        assertEquals(updated.getName(), productTmp.getName());
        assertEquals(updated.getPrice(), productTmp.getPrice(), 0);
    }

    @Test
    public void getById() {
        List<Product> all = productRepository.getAll();
        int id = all.get(0).getId();
        Product productFromRepo = productRepository.getById(id);
        assertEquals(PRODUCT_TEST_NAME, productFromRepo.getName());
        assertEquals(PRODUCT_TEST_PRICE, productFromRepo.getPrice(), 0);
    }
}