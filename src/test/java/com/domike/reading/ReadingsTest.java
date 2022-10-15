package com.domike.reading;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import javax.inject.Inject;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

@QuarkusTest
public class ReadingsTest {

    @Test
    public void testHelloEndpoint() {
        given().when().get("/readings")
                .then()
                .statusCode(200)
                .body("size()", is(1));
    }

    @Test
    public void testGetReadings_Gas() {
        given().when().queryParam("type", "GAS").get("/readings")
                .then()
                .statusCode(200)
                .body("size()", is(0));
    }

    @Test
    public void testGetReadings_Electricity() {
        given().when().queryParam("type", "ELECTRICITY").get("/readings")
                .then()
                .statusCode(200)
                .body("size()", is(1));
    }
}