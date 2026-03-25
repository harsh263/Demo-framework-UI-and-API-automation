package com.automation.api;

import com.automation.config.ConfigFactory;
import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

public class ApiClient {

    protected RequestSpecification requestSpec;

    public ApiClient() {
        RestAssured.baseURI = ConfigFactory.getConfig().apiBaseUrl();

        requestSpec = new RequestSpecBuilder()
                .setContentType(ContentType.JSON)
                .setAccept(ContentType.JSON)
                .addFilter(new AllureRestAssured())
                .build();
    }

    public RequestSpecification getRequestSpec() {
        return RestAssured.given().spec(requestSpec);
    }
}

