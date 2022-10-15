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
    void whenGetReadingsWithNoFilter_thenGetAllAvailableReadings() {
        given().when().get("/readings")
                .then()
                .statusCode(200)
                .body("size()", is(4));
    }

    @Test
    void whenGetReadingsOfTypeGas_thenGetOnlyGasReadings() {
        given().when().queryParam("type", "GAS").get("/readings")
                .then()
                .statusCode(200)
                .body("size()", is(1));
    }

    @Test
    void whenGetReadingsOfTypeElectricity_thenGetOnlyElectricityReadings() {
        given().when().queryParam("type", "ELECTRICITY").get("/readings")
                .then()
                .statusCode(200)
                .body("size()", is(1));
    }

    @Test
    void whenGetReadingsOfTypeWater_thenGetOnlyWaterReadings() {
        given().when().queryParam("type", "WATER").get("/readings")
                .then()
                .statusCode(200)
                .body("size()", is(1));
    }
}