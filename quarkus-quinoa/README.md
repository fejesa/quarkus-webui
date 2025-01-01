# Quarkus Quinoa UI

This project demonstrates the integration of Angular UI components in a [Quarkus](https://quarkus.io/) application using the [Quinoa](https://github.com/quarkiverse/quarkus-quinoa) extension. It is a Single Page Application (SPA) that displays a product catalog, leveraging Angular's UI components.

## Project Structure
### Backend
Key Components of the Backend
* `ProductService`:
  * An `@ApplicationScoped` bean responsible for providing a list of products.
  * Interacts with a PostgreSQL database using the `PanacheRepository` interface.
* REST API
  * The backend exposes a REST API via the `ProductResource` class.
  * This API allows the Angular frontend to consume backend services, as direct access is not possible.
* Error Handling
  * An `ExceptionMapper` handles requests for REST resources not exposed by the backend.
  * Provides appropriate error responses to ensure graceful error management.

### Frontend
The frontend is implemented in the `src/main/webui` folder using Angular. The application is built with the Angular CLI and incorporates the [PrimeNG](https://primeng.org/) library for UI components. It is served by the [Quinoa Quarkus](https://github.com/quarkiverse/quarkus-quinoa) extension.
The frontend consists of a single page displaying products in a PrimeNG [DataTable](https://primeng.org/table) component. Users can filter and sort products by various columns.

Key files:
* `app.component.ts`: The main Angular component that manages the product catalog and user interactions, such as filtering and sorting. It delegates backend service calls implemented in the `catalog.service.ts` file.
* `app.component.html`: Defines the layout for the main component, including a simple header and content area.
* `index.html`: Defines the overall structure and layout of the Angular application.

**Note**: Model and service classes are generated from the OpenAPI specification, as defined in the `src/main/webui/api/catalog.yaml` file.

### Database
* The application uses PostgreSQL as its database.
* Database connection properties are configured in the `application.properties` file.
* During startup, the database is created and populated with sample products using the `import.sql` file.

**Note:** Product images are stored in the `src/main/resources/META-INF/resources/images` folder for this demo. In a production environment, images should be stored in a more appropriate location, such as a dedicated file storage service or CDN.

## Requirements
To build and run this project, you need the following tools:
- **Java 21**
- **Maven 3**

**Note**: no need to install [Node.js](https://nodejs.org/) or Angular CLI, as the Quinoa extension downloads and installs them automatically.

## Building and Running the Application
Follow these steps to build and run the application locally:
1. Clone the repository.
2. To build and run the application, run the following command:
```shell
mvn clean quarkus:dev
```
3. Access the application at `http://localhost:8081`. Alternatively, you can access the Angular frontend at `http://localhost:4200` as well. The REST API is available at `http://localhost:8081/api/product`.

## Testing the Application
Run the following command to build the project and execute tests:
```shell
mvn clean verify
```

## Configuration
The application ports and database connection properties are configured in the `application.properties` file. Additional key properties include:
```properties
# Base URI for all JAX-RS resource URIs defined by @Path annotations
quarkus.rest.path = /api
# Name of the generated OpenAPI schema files; defaults are openapi.json and openapi.yaml
quarkus.smallrye-openapi.store-schema-file-name = catalog
# Directory where the generated OpenAPI schema files are stored during the build
quarkus.smallrye-openapi.store-schema-directory = src/main/webui/api
# Enables package manager installation, overriding the "package-manager" configuration
quarkus.quinoa.package-manager-install = true
# Enables Single Page Application (SPA) routing, allowing all relevant requests to be re-routed to index.html
quarkus.quinoa.enable-spa-routing = true
# Enables the CORS filter, allowing the Angular client to access the Quarkus API
quarkus.http.cors = true
```

During the application's startup, Quarkus generates the OpenAPI schema and stores it in the `src/main/webui/api` directory.
### OpenAPI Dependency
To enable OpenAPI schema generation, add the following dependency to the `pom.xml` file:
```xml
<dependency>
    <groupId>io.quarkus</groupId>
    <artifactId>quarkus-smallrye-openapi</artifactId>
</dependency>
```
### Generating the Angular Client
The Angular client to access the REST API, is generated using the [Oval](https://orval.dev/) library. The Orval configuration is defined in the `orval.config.ts` file:
```typescript
export default defineConfig({
    catalog: {
        /** The path of the generated OpenAPI scheme */
        input: 'api/catalog.yaml',
        output: {
            /** Generates schema and client implementation in separate files */
            mode: 'split',
            /**  Path to the folder where models will be generated */
            schemas: 'src/app/api/model',
            /** Path to the file containing the client implementation */
            target: 'src/app/api/service/catalog.ts',
            /** Type of client implementation */
            client: 'angular',
            /** Base URL of the API, included in the generated client */
            baseUrl: 'http://localhost:8081'
        },
        hooks: {
            /** Formats generated files with Prettier after generation */
            afterAllFilesWrite: 'prettier --write',
        },
    },
});
```
To generate the client, run the following command:
```shell
npm run-script build
```
**Note**: Refer to the `package.json` file for available scripts.
### Alternative Libraries
You can use other libraries, such as [OpenAPI Generator](https://openapi-generator.tech/), to generate the client implementation if needed.

