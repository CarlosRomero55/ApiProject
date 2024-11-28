package com.testing.api;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

public class ResourceCreationTest {

    private static final String BASE_URL = "https://673bdac096b8dcd5f3f7afdb.mockapi.io/api/v1/";

    @Test
    public void createMultipleResources() {
        for (int i = 1; i <= 15; i++) {
            String resourceName = "Resource_" + i;
            String resourceStatus = i % 2 == 0 ? "active" : "inactive"; // Alterna entre activo e inactivo

            // Construir el cuerpo de la solicitud
            String resourcePayload = String.format("{\"name\": \"%s\", \"status\": \"%s\"}", resourceName, resourceStatus);

            // Enviar la solicitud POST para crear el recurso
            Response response = RestAssured.given()
                    .baseUri(BASE_URL)
                    .contentType(ContentType.JSON)
                    .body(resourcePayload)
                    .when()
                    .post("resources");

            // Verificar que la respuesta sea 201 (creación exitosa)
            response.then().statusCode(201);

            // Verificar que el recurso fue creado correctamente
            System.out.println("Created resource: " + resourceName);
        }
    }
}
