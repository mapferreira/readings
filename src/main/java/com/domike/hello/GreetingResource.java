package com.domike.hello;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/hello")
public class GreetingResource {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Hello hello() {
        Hello hello = new Hello("Hello from RESTEasy Reactive");
        return hello;
    }
}