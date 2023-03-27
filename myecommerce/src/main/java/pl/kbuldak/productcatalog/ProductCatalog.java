package pl.kbuldak.productcatalog;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class ProductCatalog {
    private ArrayList<Product> products;

    public ProductCatalog(){
        this.products = new ArrayList<>();
    }

    public List<Product> allProducts(){
        return products;
    }

    public String addProduct(String name, String desc) {
        Product newOne = new Product(
                UUID.randomUUID(),
                name,
                desc
        );
        return newOne.getId();
    }
}
