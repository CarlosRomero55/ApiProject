package com.testing.api.stepDefinitions;

import com.testing.api.models.Client;
import com.testing.api.requests.ClientRequest;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import org.junit.Assert;

public class ClientSteps {
    private ClientRequest clientRequest = new ClientRequest();
    private Response response;
    private Client client;

    @Given("there are at least 10 registered clients")
    public void thereAreAtLeastClients() {
        response = clientRequest.getClients();
        Assert.assertTrue(response.statusCode() == 200);
    }

    @When("I find the first client named Laura")
    public void iFindTheFirstClientNamedLaura() {
        response = clientRequest.getClients();
        client = response.jsonPath().getList("", Client.class).stream()
                .filter(c -> c.getName().equals("Laura"))
                .findFirst()
                .orElseThrow();
    }

    @When("I save her current phone number")
    public void iSaveHerCurrentPhoneNumber() {
        String currentPhone = client.getPhone();
        System.out.println("Current phone number of Laura: " + currentPhone);
    }

    @When("I update her phone number")
    public void iUpdateHerPhoneNumber() {
        String newPhoneNumber = "123-456-7890";
        client.setPhone(newPhoneNumber);
        response = clientRequest.updateClient(client, client.getId());
    }

    @Then("the phone number should be updated")
    public void thePhoneNumberShouldBeUpdated() {
        Assert.assertNotEquals("Original Phone Number", client.getPhone());
        Assert.assertEquals("123-456-7890", client.getPhone());
    }
}
