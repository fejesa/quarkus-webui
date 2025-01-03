# Quarkus Faces UI

This project demonstrates how to use [PrimeFaces](https://www.primefaces.org/) UI components in a [Quarkus](https://quarkus.io/) application. It is a Single Page Application (SPA) that displays a catalog of products with PrimeFaces UI components.

## Project Structure
### Backend
* The backend is represented by `ProductService`, an `@ApplicationScoped` bean that provides a list of products.
* It uses the `PanacheRepository` to interact with the database.

### Frontend
* The frontend is a single page where products are displayed in a [DataTable](https://www.primefaces.org/showcase/ui/data/datatable/filter.xhtml) component. Users can filter and sort the products by different columns.
* The backing bean, `CatalogBean`, is a `@ViewScoped` bean that:
  * Holds the products and filters.
  * Handles user interactions such as filtering and sorting.
  * Delegates calls to the backend service.
* The layout - `catalog.xhtml` - consists of a simple header and a content area, defined in an XHTML file.
* Based on the [PrimeFaces Quarkus](https://github.com/quarkiverse/quarkus-primefaces) extension, web resources are served from the `src/main/resources/META-INF/resources` folder.
* The `src/main/resources/META-INF/web.xml` file defines mappings between URL paths and the servlets handling requests.

### Database
* The application uses PostgreSQL as its database.
* Database connection properties are configured in the `application.properties` file.
* During startup, the database is created and populated with sample products using the `import.sql` file (thanks for Hibernate).

**Note:** Product images are stored in the `src/main/resources/META-INF/resources/images` folder for this demo. In a production environment, images should be stored in a more appropriate location, such as a dedicated file storage service or CDN.

## Requirements
To build and run this project, you need the following tools:
- **Java 21**
- **Maven 3**
- **Docker**

## Building and Running the Application
Follow these steps to build and run the application locally:
1. Clone the repository.
2. To build and run the application, run the following command:
```shell
mvn clean quarkus:dev
```
3. Access the application at `http://localhost:8080`.

## Testing the Application
Run the following command to build the project and execute tests:
```shell
mvn clean verify
```

## Configuration
Application ports and databases connection properties are set in the `application.properties` file.
