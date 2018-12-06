import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ProductRepositoryTest {

    private ProductRepository productRepository = ProductRepository.INSTANCE;
    private Product product;


    @Before
    public void setup(){
        product = new Product("Ignition Coil", 250);
    }

    @After
    public void reset (){
        productRepository.deleteAll();
    }

    @Test
    public void create() {
        productRepository.create(product);
        assertEquals(1, productRepository.count());
    }

    @Test
    public void get() {
        productRepository.create(product);
        Product productTmp = productRepository.get(0);
        assertEquals(product.getName(), productTmp.getName());
        assertEquals(product.getPrice(), productTmp.getPrice(), 0);
    }

    @Test
    public void delete() {
        productRepository.create(product);
        productRepository.print();
        assertTrue(productRepository.delete(product));
       productRepository.print();
    }

    @Test
    public void update() {
        Product product2 = new Product("Engine liquid", 32);
        productRepository.create(product2);
        Product productTmp = new Product("Engine Super liquid", 42);
        productTmp.setId(2);
        Product updated = productRepository.update(productTmp);
        assertEquals(updated.getName(), productTmp.getName());
        assertEquals(updated.getPrice(), productTmp.getPrice(), 0);
    }

    @Test
    public void getById() {


       fail();
    }


}