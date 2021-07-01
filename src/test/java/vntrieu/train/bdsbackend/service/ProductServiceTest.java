package vntrieu.train.bdsbackend.service;

import org.junit.Test;
import vntrieu.train.bdsbackend.model.Product;

import java.util.List;

import static org.junit.Assert.*;

public class ProductServiceTest {
    private ProductService productService;
    @Test
    public void filterByPriceRange() {
        Product p0 = new Product();
        Product p1 = new Product();
        Product p2 = new Product();
        Product p3 = new Product();
        Product p4 = new Product();

        p0.setPrice(450000000L);//450M
        p1.setPrice(400000000L);//400M
        p2.setPrice(750000000L);//750M
        p3.setPrice(900000000L);//900M
        p4.setPrice(5000000000L);//5B

        List<Product> data = List.of(p1,p2,p3,p4);

        //Filter(0: <=500M, 1: (500,1000], 2: (1000,1500], 3: (1500,2000], 4: (2000, infinity))
        List<Product> actualResult1 = productService.filterByPriceRange(data, 0);
        List<Product> actualResult2 = productService.filterByPriceRange(data, 1);

        for(Product p : actualResult1){
            assertEquals(true, p.getPrice()<=500000000);
        }
        for(Product p : actualResult2){
            assertEquals(true, p.getPrice()>500000000 && p.getPrice() <= 1000000000);
        }

    }

    @Test
    public void filterBySearchSTring() {
        Product p0 = new Product();
        Product p1 = new Product();
        Product p2 = new Product();
        Product p3 = new Product();
        Product p4 = new Product();

    }
}