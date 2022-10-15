package com.domike.reading;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

@QuarkusTest
public class ReadingsTest {

    @Test
    public void testHelloEndpoint() {
        Reading reading = new Reading();

        given().when().get("/readings")
                .then()
                .statusCode(200)
                .body("size()", is(1));
    }

}