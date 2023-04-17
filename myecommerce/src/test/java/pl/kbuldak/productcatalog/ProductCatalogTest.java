package pl.kbuldak.productcatalog;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


import java.math.BigDecimal;
import java.util.List;

public class ProductCatalogTest {
    @Test
    void itExposeEmptyProductList(){
        ProductCatalog catalog = thereIsProductCatalog();
        List<Product> products = catalog.allProducts();
        assertEmptyList(products);
    }

    private void assertEmptyList(List<Product> products) {
        assert 0 == products.size();
    }

    private ProductCatalog thereIsProductCatalog() {
        return new ProductCatalog();
    }

    @Test
    void itAllowsToAddProduct(){
        //Arrange
        ProductCatalog catalog = thereIsProductCatalog();
        //Act
        String productId = catalog.addProduct("lego 8398", "nice one");
        //Assert
        List<Product> products = catalog.allProducts();
        assert 1 == products.size();
    }

    @Test
    void itAllowsToLoadProductDetails(){
        ProductCatalog catalog = thereIsProductCatalog();
        String productId = catalog.addProduct("lego 8298", "nice one");

        Product loaded = catalog.loadById(productId);
        assert productId.equals(loaded.getId());
    }

    @Test
    void itAllowsToChangePrice(){
        ProductCatalog catalog = thereIsProductCatalog();
        String productId = catalog.addProduct("lego 8298", "nice one");

        catalog.changePrice(productId, BigDecimal.valueOf(20.20));
        Product loaded = catalog.loadById(productId);
        assertEquals(BigDecimal.valueOf(20.20), loaded.getPrice());
    }

    @Test
    void itAllowsToEditProduct() {

    }

    @Test
    void  itAllowsToAssign(){}
}
