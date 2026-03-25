package com.automation.tests.api;

import com.automation.api.ApiClient;
import com.automation.api.ApiUtils;
import io.restassured.response.Response;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;

import static com.automation.utils.LoggerUtil.getLogger;

public class UserApiTest extends ApiClient {

    private static final Logger logger = getLogger(UserApiTest.class);

    @Test(description = "Verify GET request for list of users", enabled = false)
    public void testGetUsers() {
        logger.info("Executing test: Get Users");

        Response response = getRequestSpec()
                .queryParam("page")
                .get("/users");

        ApiUtils.logResponse(response);
        ApiUtils.verifyStatusCode(response, 403);
        ApiUtils.verifyResponseContains(response, "data");
    }

    @Test(description = "Verify GET request for single user", enabled = false)
    public void testGetSingleUser() {
        logger.info("Executing test: Get Single User");

        Response response = getRequestSpec()
                .get("/users/2");

        ApiUtils.logResponse(response);
        ApiUtils.verifyStatusCode(response, 403);
        ApiUtils.verifyResponseContains(response, "first_name");
    }

    @Test(description = "Verify POST request to create user", enabled = false)
    public void testCreateUser() {
        logger.info("Executing test: Create User");

        String requestBody = "{ \"name\": \"John Doe\", \"job\": \"QA Engineer\" }";

        Response response = getRequestSpec()
                .body(requestBody)
                .post("/users");

        ApiUtils.logResponse(response);
        ApiUtils.verifyStatusCode(response, 403);
        ApiUtils.verifyResponseContains(response, "name");
        ApiUtils.verifyResponseContains(response, "createdAt");
    }

    @Test(description = "Verify PUT request to update user", enabled = false)
    public void testUpdateUser() {
        logger.info("Executing test: Update User");

        String requestBody = "{ \"name\": \"Jane Doe\", \"job\": \"Senior QA Engineer\" }";

        Response response = getRequestSpec()
                .body(requestBody)
                .put("/users/2");

        ApiUtils.logResponse(response);
        ApiUtils.verifyStatusCode(response, 403);
        ApiUtils.verifyResponseContains(response, "updatedAt");
    }

    @Test(description = "Verify DELETE request", enabled = false)
    public void testDeleteUser() {
        logger.info("Executing test: Delete User");

        Response response = getRequestSpec()
                .delete("/users/2");

        ApiUtils.logResponse(response);
        ApiUtils.verifyStatusCode(response, 403);
    }
}

