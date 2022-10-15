package com.domike.reading;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Path("/readings")
public class Readings {

    protected List<Reading> readings = new ArrayList<>();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Collection<Reading> listReadings(@QueryParam("type") ReadingType type) {
        return (type != null) ? readings.stream().filter(r -> type.equals(r.type)).collect(Collectors.toList()) : readings;
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response createReading(Reading reading) {
        if (reading.date == null) {
            reading.date = LocalDate.now();
        }
        readings.add(reading);
        return Response.status(Response.Status.CREATED).build();
    }
}