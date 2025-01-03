package io.crunch.catalog;

import jakarta.ws.rs.WebApplicationException;
import jakarta.ws.rs.core.Response;
import org.jboss.resteasy.reactive.server.ServerExceptionMapper;

/**
 * A class to handle exceptions in a Jakarta RESTful Web Services application.
 * This class defines custom behavior for specific exceptions by mapping them to HTTP responses.
 *
 * <p>
 * This mapper handles exceptions globally, similar to regular JAX-RS {@code ExceptionMapper} implementations.
 * If a client refers to a specific resource that does not exist, the server will return a
 * <strong>404 Page Not Found</strong> response.
 * </p>
 *
 * <h3>Example Usage</h3>
 * <p>
 * Consider the following URLs:
 * </p>
 * <ul>
 *   <li><code>http://localhost:8081/api/product</code> - REST response served successfully by the API.</li>
 *   <li><code>http://localhost:8081/api/foo</code> - Returns a <strong>404 Page Not Found</strong> response, served by this Exception Mapper.</li>
 * </ul>
 *
 * <p>
 * Using this global exception mapper improves user experience by providing consistent error handling for
 * undefined routes or missing resources.
 * </p>
 */
public class ExceptionMappers {

    @ServerExceptionMapper
    public Response handleExceptions(WebApplicationException exception) {
        return Response.fromResponse(exception.getResponse()).entity("404 Page Not Found").build();
    }

}
