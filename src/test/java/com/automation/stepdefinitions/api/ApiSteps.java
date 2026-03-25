package com.automation.stepdefinitions.api;

import com.automation.api.ApiClient;
import com.automation.api.ApiUtils;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import org.apache.logging.log4j.Logger;

import java.util.Map;

import static com.automation.utils.LoggerUtil.getLogger;
import static org.assertj.core.api.Assertions.assertThat;

public class ApiSteps extends ApiClient {

    private static final Logger logger = getLogger(ApiSteps.class);
    private String endpoint;
    private Response response;

    @Given("I have the API endpoint {string}")
    public void iHaveTheAPIEndpoint(String endpoint) {
        this.endpoint = endpoint;
        logger.info("API Endpoint set to: {}", endpoint);
    }

    @When("I send GET request")
    public void iSendGETRequest() {
        logger.info("Sending GET request to: {}", endpoint);
        response = getRequestSpec().get(endpoint);
        ApiUtils.logResponse(response);
    }

    @When("I send GET request with page {string}")
    public void iSendGETRequestWithPage(String page) {
        logger.info("Sending GET request to: {} with page: {}", endpoint, page);
        response = getRequestSpec()
                .queryParam("page", page)
                .get(endpoint);
        ApiUtils.logResponse(response);
    }

    @When("I send POST request with following data")
    public void iSendPOSTRequestWithFollowingData(DataTable dataTable) {
        Map<String, String> data = dataTable.asMap(String.class, String.class);
        logger.info("Sending POST request to: {} with data: {}", endpoint, data);
        response = getRequestSpec()
                .body(data)
                .post(endpoint);
        ApiUtils.logResponse(response);
    }

    @Then("the response status code should be {int}")
    public void theResponseStatusCodeShouldBe(int expectedStatusCode) {
        logger.info("Verifying status code: {}", expectedStatusCode);
        ApiUtils.verifyStatusCode(response, expectedStatusCode);
    }

    @And("the response should contain {string}")
    public void theResponseShouldContain(String expectedText) {
        logger.info("Verifying response contains: {}", expectedText);
        ApiUtils.verifyResponseContains(response, expectedText);
    }

    @And("the response should contain user with id {string}")
    public void theResponseShouldContainUserWithId(String userId) {
        logger.info("Verifying user with id: {}", userId);
        String responseBody = response.getBody().asString();
        assertThat(responseBody).contains("\"id\":" + userId);
    }

    @And("user first name should be {string}")
    public void userFirstNameShouldBe(String expectedFirstName) {
        logger.info("Verifying user first name: {}", expectedFirstName);
        String actualFirstName = ApiUtils.getJsonValue(response, "data.first_name");
        assertThat(actualFirstName).isEqualTo(expectedFirstName);
    }
}

