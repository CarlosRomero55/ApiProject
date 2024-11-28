package com.testing.api.requests;

import com.testing.api.models.Client;
import com.testing.api.utils.Constants;
import io.restassured.response.Response;

public class ClientRequest extends BaseRequest {

    private String endpoint;

    public Response getClients() {
        endpoint = String.format(Constants.URL, Constants.CLIENTS_PATH);
        return requestGet(endpoint, createBaseHeaders());
    }

    public Response getClient(String clientId) {
        endpoint = String.format(Constants.URL_WITH_PARAM, Constants.CLIENTS_PATH, clientId);
        return requestGet(endpoint, createBaseHeaders());
    }

    public Response createClient(Client client) {
        endpoint = String.format(Constants.URL, Constants.CLIENTS_PATH);
        return requestPost(endpoint, createBaseHeaders(), client);
    }

    public Response updateClient(Client client, String clientId) {
        endpoint = String.format(Constants.URL_WITH_PARAM, Constants.CLIENTS_PATH, clientId);
        return requestPut(endpoint, createBaseHeaders(), client);
    }

    public Response deleteClient(String clientId) {
        endpoint = String.format(Constants.URL_WITH_PARAM, Constants.CLIENTS_PATH, clientId);
        return requestDelete(endpoint, createBaseHeaders());
    }
}
