package stepDefinitions;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import commonUtils.RestLogger;
import commonUtils.utils;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import resource.TestDataBuilder;

import static junit.framework.TestCase.assertEquals;

public class stepDefinitions extends utils {
    TestDataBuilder data = new TestDataBuilder();
    ObjectMapper objectMapper;
    JsonPath jsonPath;
    Response response;
    public static String payload;


    @Given("^Starting Test Case \"([^\"]*)\"$")
    public void startingTestCase(String testcase_name) {
        RestLogger.initLogger();
        RestLogger.startTestCase(testcase_name);

    }

    @Given("^Create Repo Payload name \"([^\"]*)\" and description \"([^\"]*)\"$")
    public void create_Repo_Payload_name_and_description(String name, String description) throws JsonProcessingException {
        objectMapper = new ObjectMapper();
        payload = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(data.createRepoPayload(name, description));
    }

    @When("^User calls Create API \"([^\"]*)\" Post API Call$")
    public void user_calls_Post_API_Call(String resourcePath){
        response = postRequest(resourcePath, payload);
    }

    @Then("^API Call got successful with status code (\\d+)$")
    public void api_Call_got_successful_with_status_code(int statusCode) {
            assertEquals(statusCode, response.getStatusCode());
            RestLogger.info("Status code verification is Done!");
    }

    @When("^User calls Delete API \"([^\"]*)\" Delete API Call$")
    public void user_calls_Delete_API_Delete_API_Call(String resourcePath) {
        response = deleteRequest(resourcePath, data.getRepoName());
        RestLogger.info("Delete Request Status code - " + response.getStatusCode());
    }


    @And("^Verify Repository \"([^\"]*)\" is \"([^\"]*)\"$")
    public void verifyRepositoryIs(String response_key, String repo_name) throws Throwable {
        jsonPath = new JsonPath(response.getBody().asString());
        String key_value = jsonPath.get(response_key);
        assertEquals(repo_name, key_value);
        RestLogger.info("Actual Repo Name - " + key_value);
        RestLogger.info("Expected Repo Name - " + repo_name);
    }

    @And("^Verify the Repository \"([^\"]*)\" is \"([^\"]*)\"$")
    public void verifyTheRepositoryIs(String response_key, String repo_description) {
        jsonPath = new JsonPath(response.getBody().asString());
        String key_value = jsonPath.get(response_key);
        assertEquals(repo_description, key_value);
        RestLogger.info("Actual Repo Description - " + key_value);
        RestLogger.info("Expected Repo Description - " + repo_description);
    }

    @And("^Ending Test Case$")
    public void endingTestCase() {
        RestLogger.endTestCase();
    }

}
