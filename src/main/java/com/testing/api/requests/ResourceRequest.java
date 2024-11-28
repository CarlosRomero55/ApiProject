package com.testing.api.requests;

import com.testing.api.models.Resource;
import io.restassured.RestAssured;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.response.Response;
import com.testing.api.utils.Constants;
import java.io.File;

public class ResourceRequest {

    private static final String RESOURCE_PATH = Constants.RESOURCES_PATH;

    // Obtener todos los recursos
    public Response getResources() {
        return RestAssured.given()
                .baseUri(Constants.BASE_URL)
                .get(RESOURCE_PATH);
    }

    // Obtener un solo recurso por ID
    public Response getResource(String resourceId) {
        return RestAssured.given()
                .baseUri(Constants.BASE_URL)
                .get(RESOURCE_PATH + "/" + resourceId);
    }

    // Crear un recurso
    public Response createResource(Resource resource) {
        return RestAssured.given()
                .baseUri(Constants.BASE_URL)
                .contentType(Constants.VALUE_CONTENT_TYPE)
                .body(resource)
                .post(RESOURCE_PATH);
    }

    // Actualizar un recurso por ID
    public Response updateResource(Resource resource, String resourceId) {
        return RestAssured.given()
                .baseUri(Constants.BASE_URL)
                .contentType(Constants.VALUE_CONTENT_TYPE)
                .body(resource)
                .put(RESOURCE_PATH + "/" + resourceId);
    }

    // Eliminar un recurso por ID
    public Response deleteResource(String resourceId) {
        return RestAssured.given()
                .baseUri(Constants.BASE_URL)
                .delete(RESOURCE_PATH + "/" + resourceId);
    }

    // Validar el esquema JSON del recurso
    public boolean validateSchema(Response response, String schemaPath) {
        try {
            File schemaFile = new File(getClass().getClassLoader().getResource(schemaPath).toURI());
            response.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(schemaFile));
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
