package io.crunch.catalog;

import jakarta.annotation.PostConstruct;
import jakarta.inject.Named;
import org.omnifaces.cdi.ViewScoped;
import org.primefaces.model.FilterMeta;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Named("catalogBean")
@ViewScoped
public class CatalogBean implements Serializable {

    private transient final ProductService productService;

    private List<Product> products;

    private List<Product> filteredProducts;

    private List<FilterMeta> filterBy;

    public CatalogBean(ProductService productService) {
        this.productService = productService;
    }

    public List<Product> getProducts() {
        return products;
    }

    public List<Product> getFilteredProducts() {
        return filteredProducts;
    }

    public void setFilteredProducts(List<Product> filteredProducts) {
        this.filteredProducts = filteredProducts;
    }

    public List<FilterMeta> getFilterBy() {
        return filterBy;
    }

    public void setFilterBy(List<FilterMeta> filterBy) {
        this.filterBy = filterBy;
    }

    @PostConstruct
    public void init() {
        this.products = productService.getProducts();
        filterBy = new ArrayList<>();
    }
}
