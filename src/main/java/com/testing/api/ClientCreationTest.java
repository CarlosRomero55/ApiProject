package com.testing.api;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.Test;

public class ClientCreationTest {

    private static final String BASE_URL = "https://673bdac096b8dcd5f3f7afdb.mockapi.io/api/v1/";

    @Test
    public void createMultipleClients() {
        for (int i = 1; i <= 15; i++) {
            String clientName = "Client_" + i;
            String phoneNumber = "555-010" + i;

            // Construir el cuerpo de la solicitud
            String clientPayload = String.format("{\"name\": \"%s\", \"phone\": \"%s\"}", clientName, phoneNumber);

            // Enviar la solicitud POST para crear el cliente
            Response response = RestAssured.given()
                    .baseUri(BASE_URL)
                    .contentType(ContentType.JSON)
                    .body(clientPayload)
                    .when()
                    .post("clients");

            // Verificar que la respuesta sea 201 (creación exitosa)
            response.then().statusCode(201);

            // Verificar que el cliente fue creado correctamente
            System.out.println("Created client: " + clientName);
        }
    }
}
