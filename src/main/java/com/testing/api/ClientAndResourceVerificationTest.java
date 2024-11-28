package com.testing.api;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class ClientAndResourceVerificationTest {

    private static final String BASE_URL = "https://673bdac096b8dcd5f3f7afdb.mockapi.io/api/v1/";

    @Test
    public void verifyClientsAndResources() {
        // Verificar clientes
        Response clientsResponse = RestAssured.given()
                .baseUri(BASE_URL)
                .when()
                .get("clients");

        clientsResponse.then().statusCode(200);
        assertThat(clientsResponse.jsonPath().getList("$"), hasSize(15));  // Verificar que haya 15 clientes

        // Verificar recursos
        Response resourcesResponse = RestAssured.given()
                .baseUri(BASE_URL)
                .when()
                .get("resources");

        resourcesResponse.then().statusCode(200);
        assertThat(resourcesResponse.jsonPath().getList("$"), hasSize(15));  // Verificar que haya 15 recursos
    }
}
