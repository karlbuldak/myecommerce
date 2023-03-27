package pl.kbuldak.productcatalog;

import org.junit.jupiter.api.Test;

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
    void itAllowsToChangePrice(){

    }

    @Test
    void itAllowsToEditProduct() {

    }

    @Test
    void  itAllowsToAssign(){}
}
