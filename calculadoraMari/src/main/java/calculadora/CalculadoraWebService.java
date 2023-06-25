package calculadora;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@WebService
public interface CalculadoraWebService {
    @WebMethod
    @GET
    @Path("/add/{a}/{b}")
    @Produces(MediaType.TEXT_PLAIN)
    int add(@PathParam("a") int a, @PathParam("b") int b);

    @WebMethod
    @GET
    @Path("/sub/{a}/{b}")
    @Produces(MediaType.TEXT_PLAIN)
    int sub(@PathParam("a") int a, @PathParam("b") int b);

    @WebMethod
    @GET
    @Path("/mul/{a}/{b}")
    @Produces(MediaType.TEXT_PLAIN)
    int mul(@PathParam("a") int a, @PathParam("b") int b);

    @WebMethod
    @GET
    @Path("/div/{a}/{b}")
    @Produces(MediaType.TEXT_PLAIN)
    double div(@PathParam("a") int a, @PathParam("b") int b);
}
