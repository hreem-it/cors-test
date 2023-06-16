package org.acme;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.UriBuilder;

import java.net.URI;

@Path("/hello")
public class GreetingResource {

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Response hello() {
        URI location = UriBuilder
                .fromResource(GreetingResource.class)
                .path("{id}")
                .resolveTemplate("id", "my-greeting")
                .build();
        return Response
                .created(location)
                .entity("Hello")
                .build();
    }
}
