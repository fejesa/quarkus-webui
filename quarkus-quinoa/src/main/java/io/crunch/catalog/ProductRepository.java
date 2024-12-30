package io.crunch.catalog;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

/**
 * A repository class for managing {@link Product} entities.
 * <p>
 * This class implements the {@link PanacheRepository} interface,
 * which provides a convenient way to interact with the database
 * using the Panache ORM framework in Quarkus. It encapsulates
 * data access logic and is annotated with {@link ApplicationScoped}
 * to indicate that it is a CDI bean with a single shared instance
 * per application lifecycle.
 * </p>
 *
 * <h2>Features</h2>
 * <ul>
 *   <li>CRUD operations: Provides methods to perform create, read,
 *       update, and delete operations on {@link Product} entities.</li>
 *   <li>Query support: Includes methods for custom queries using JPQL,
 *       native SQL, or Panache-specific query mechanisms.</li>
 *   <li>Pagination and sorting: Supports pagination and sorting of
 *       query results.</li>
 *   <li>Transaction management: Automatically participates in transactions
 *       managed by Quarkus.</li>
 * </ul>
 *
 * <h2>Usage</h2>
 * <pre>
 * {@code
 * @Inject
 * ProductRepository productRepository;
 *
 * public void performOperations() {
 *     // Create a new product
 *     Product product = new Product();
 *     product.setModel("Example Product");
 *     productRepository.persist(product);
 *
 *     // Find a product by ID
 *     Product foundProduct = productRepository.findById(1L);
 *
 *     // Update a product
 *     foundProduct.setModel("Updated Product");
 *     productRepository.persist(foundProduct);
 *
 *     // Delete a product
 *     productRepository.deleteById(1L);
 * }
 * }
 * </pre>
 *
 * @see PanacheRepository
 * @see Product
 */
@ApplicationScoped
public class ProductRepository implements PanacheRepository<Product> {

}
