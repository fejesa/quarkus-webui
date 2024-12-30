package io.crunch.catalog;

import io.quarkus.test.junit.QuarkusTest;
import jakarta.inject.Inject;
import org.apache.commons.lang3.StringUtils;
import org.junit.jupiter.api.Test;

import java.util.Objects;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@QuarkusTest
public class ProductServiceTest {

    @Inject
    ProductService productService;

    @Test
    public void shouldReturnAllProducts() {
        var products = productService.getProducts();
        assertThat(products).isNotNull();
        assertThat(products.size()).isPositive();
        assertThat(products.stream().map(Product::getImage).allMatch(StringUtils::isNotBlank)).isTrue();
        assertThat(products.stream().map(Product::getStatus).allMatch(Objects::nonNull)).isTrue();
    }
}
