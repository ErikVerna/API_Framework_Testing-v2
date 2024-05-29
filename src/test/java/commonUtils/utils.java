package commonUtils;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;


public class utils {

    RequestSpecification requestSpecification;
    Response response;

    String bearer_token = "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"; // here goes the bearer token to get the API call
    String baseURI = "https://api.github.com";

    public Response postRequest(String resourcePath, String payload) {
        RestLogger.info("Base URI is - " + baseURI);
        RestLogger.info("Resource Path is - " + resourcePath);
        RestLogger.info("Request Payload is - " + payload);
        requestSpecification = RestAssured.given().body(payload);
        requestSpecification.contentType(ContentType.JSON);
        requestSpecification.header("Authorization", "Bearer " + bearer_token);
        response = requestSpecification.post(baseURI + resourcePath);
        RestLogger.info("Response of Request is - " + response.getBody().asString());
        return response;
    }

    public Response deleteRequest(String resourcePath, String repo_name) {
        String requestURI = baseURI + resourcePath + repo_name;
        RestLogger.info("Delete URI is - " + requestURI);
        RequestSpecification requestSpecification = RestAssured.given();
        requestSpecification.contentType(ContentType.JSON);
        requestSpecification.header("Authorization", "Bearer " + bearer_token);
        response = requestSpecification.delete(requestURI);
        return response;
    }
}