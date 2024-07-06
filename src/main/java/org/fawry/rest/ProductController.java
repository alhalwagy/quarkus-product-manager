package org.fawry.rest;

import io.quarkus.vertx.core.runtime.config.VertxConfiguration;
import io.vertx.core.Vertx;
import jakarta.inject.Inject;
import jakarta.inject.Singleton;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import java.util.List;
import org.fawry.model.Product;
import org.fawry.service.ProductService;

@Path("products")
@Singleton
public class ProductController {

    @Inject
    ProductService productService;

    @GET
    @Path("")
    @Produces({MediaType.APPLICATION_JSON})
    public List<Product> getAllProducts() {

        return productService.getAllProducts();
    }

    @POST
    @Path("")
    @Produces({MediaType.APPLICATION_JSON})
    public Response createProduct( Product product) {
        productService.addProduct(product);
        return Response.status(201).entity(product).build();
    }

    @GET
    @Path("{id}")
    @Produces({MediaType.APPLICATION_JSON})
    public Product getProduct(@PathParam("id") int id) {
        return productService.getProductById(id);
    }

    @PUT
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Product updateProduct(@PathParam("id") int id, Product product) {

        return productService.updateProduct(id, product);
    }

    @DELETE
    @Path("{id}")
    @Produces({MediaType.APPLICATION_JSON})
    public Response deleteProduct(@PathParam("id") int id) {
        productService.deleteProduct(id);
        return Response.status(204).build();
    }

    @GET
    @Path("/search")
    @Produces({MediaType.APPLICATION_JSON})
    public Response getProductByName(@QueryParam("name") String name) {

        Vertx vertx = new io.vertx.mutiny.core.Vertx().createHttpServer().se
        return Response.status(200).entity(productService.getProductByName(name)).build();
    }


}
