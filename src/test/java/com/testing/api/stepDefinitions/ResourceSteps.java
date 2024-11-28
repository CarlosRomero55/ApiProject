package com.testing.api.stepDefinitions;

import com.testing.api.models.Resource;
import com.testing.api.requests.ResourceRequest;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import org.junit.Assert;

public class ResourceSteps {
    private ResourceRequest resourceRequest = new ResourceRequest();
    private Response response;

    @Given("there are at least 5 active resources")
    public void thereAreAtLeast5ActiveResources() {
        response = resourceRequest.getResources();
        Assert.assertTrue(response.statusCode() == 200);
    }

    @When("I find all active resources")
    public void iFindAllActiveResources() {
        response = resourceRequest.getResources();
        Assert.assertTrue(response.jsonPath().getList("", Resource.class).stream().allMatch(Resource::isActive));
    }

    @When("I update resources to inactive")
    public void iUpdateResourcesToInactive() {
        response.jsonPath().getList("", Resource.class).forEach(resource -> {
            resource.setActive(false);
            resourceRequest.updateResource(resource, resource.getId());
        });
    }

    @Then("the resources should be inactive")
    public void theResourcesShouldBeInactive() {
        response.jsonPath().getList("", Resource.class).forEach(resource -> Assert.assertFalse(resource.isActive()));
    }
}
