package pl.kbuldak.productcatalog;

import java.util.*;
import java.util.stream.Collectors;

public class ProductCatalog {

    //Biznes

    //Tech

    private Map<String, Product> products;

    public ProductCatalog(){
        this.products = new HashMap<>();
    }

    public String addProduct(String name, String desc) {
        Product newOne = new Product(
                UUID.randomUUID(),
                name,
                desc
        );
        return newOne.getId();
    }

    public List<Product> allProducts(){
        return products.values()
                .stream()
                .collect(Collectors.toList());
    }

    public List<Product> allPublishedProducts(){
        return Collections.emptyList();
    }

    public Product loadById(String productId){
        return products.get(productId);
    }



}
