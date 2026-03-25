package com.automation.api;

import io.restassured.response.Response;
import org.apache.logging.log4j.Logger;

import static com.automation.utils.LoggerUtil.getLogger;
import static org.assertj.core.api.Assertions.assertThat;

public final class ApiUtils {

    private static final Logger logger = getLogger(ApiUtils.class);

    private ApiUtils() {
    }

    public static void verifyStatusCode(Response response, int expectedStatusCode) {
        int actualStatusCode = response.getStatusCode();
        logger.info("Expected Status Code: {} | Actual Status Code: {}", expectedStatusCode, actualStatusCode);
        assertThat(actualStatusCode)
                .as("Status code validation failed")
                .isEqualTo(expectedStatusCode);
    }

    public static void verifyResponseContains(Response response, String expectedText) {
        String responseBody = response.getBody().asString();
        logger.info("Verifying response contains: {}", expectedText);
        assertThat(responseBody)
                .as("Response body does not contain expected text")
                .contains(expectedText);
    }

    public static String getJsonValue(Response response, String jsonPath) {
        return response.jsonPath().getString(jsonPath);
    }

    public static void logResponse(Response response) {
        logger.info("Response Status Code: {}", response.getStatusCode());
        logger.info("Response Body: {}", response.getBody().asString());
        logger.info("Response Time: {} ms", response.getTime());
    }
}

