package org.acme;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;

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
