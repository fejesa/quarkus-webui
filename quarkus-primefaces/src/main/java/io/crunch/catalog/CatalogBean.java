package io.crunch.catalog;

import jakarta.annotation.PostConstruct;
import jakarta.inject.Named;
import jakarta.faces.view.ViewScoped;
import org.primefaces.model.FilterMeta;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * A Jakarta Faces (JSF) managed bean for displaying and managing a list of {@link Product} entities.
 * <p>
 * This bean is responsible for fetching the product list from the {@link ProductService},
 * providing it to the user interface for display, and supporting filtering and other UI
 * operations. It leverages PrimeFaces for rich UI components and OmniFaces for enhanced
 * CDI scoping with {@link ViewScoped}.
 * </p>
 *
 * <h2>Features</h2>
 * <ul>
 *   <li>Product listing: Retrieves and holds the list of all products to display in the UI.</li>
 *   <li>Filtering: Supports filtering of products using PrimeFaces {@link FilterMeta}.</li>
 *   <li>View scope: Maintains the bean state for the duration of the user's interaction with the view.</li>
 * </ul>
 *
 * <h2>Dependencies</h2>
 * <ul>
 *   <li>{@link ProductService}: Used for fetching product data.</li>
 *   <li>PrimeFaces: Provides components like data tables with filtering capabilities.</li>
 *   <li>OmniFaces: Enhances CDI scoping for view-related lifecycle management.</li>
 * </ul>
 *
 * <h2>Lifecycle</h2>
 * <p>The {@link #init()} method is annotated with {@link PostConstruct} to ensure that the product list
 * is initialized when the bean is created.</p>
 *
 * @see Product
 * @see ProductService
 * @see FilterMeta
 * @see ViewScoped
 * @see Named
 * @see Serializable
 */
@Named("catalogBean")
@ViewScoped
public class CatalogBean implements Serializable {

    /**
     * Service for managing {@link Product} entities.
     * Injected via the constructor for dependency management.
     */
    private transient final ProductService productService;

    /**
     * List of all products retrieved from the {@link ProductService}.
     */
    private transient List<Product> products;

    /**
     * List of filtered products for display in the UI.
     */
    private transient List<Product> filteredProducts;

    /**
     * List of filter metadata for PrimeFaces data table filtering.
     */
    private transient List<FilterMeta> filterBy;

    /**
     * Constructs a new {@code CatalogBean} with the specified {@link ProductService}.
     *
     * @param productService the service used for fetching product data
     */
    public CatalogBean(ProductService productService) {
        this.productService = productService;
    }

    /**
     * Retrieves the list of all products.
     *
     * @return the list of products
     */
    public List<Product> getProducts() {
        return products;
    }

    /**
     * Retrieves the list of filtered products for display.
     *
     * @return the list of filtered products
     */
    public List<Product> getFilteredProducts() {
        return filteredProducts;
    }

    /**
     * Sets the list of filtered products for display.
     *
     * @param filteredProducts the list of filtered products
     */
    public void setFilteredProducts(List<Product> filteredProducts) {
        this.filteredProducts = filteredProducts;
    }

    /**
     * Retrieves the list of filter metadata for PrimeFaces filtering.
     *
     * @return the list of filter metadata
     */
    public List<FilterMeta> getFilterBy() {
        return filterBy;
    }

    /**
     * Sets the list of filter metadata for PrimeFaces filtering.
     *
     * @param filterBy the list of filter metadata
     */
    public void setFilterBy(List<FilterMeta> filterBy) {
        this.filterBy = filterBy;
    }

    /**
     * Initializes the bean by fetching the product list and setting up filtering metadata.
     * <p>
     * This method is called automatically after the bean is constructed and dependencies are injected.
     * </p>
     */
    @PostConstruct
    public void init() {
        this.products = productService.getProducts();
        filterBy = new ArrayList<>();
    }
}
