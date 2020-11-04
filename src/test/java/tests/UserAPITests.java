package tests;

import classes.Endpoints;
import classes.TestConfig;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;

public class UserAPITests extends TestConfig implements Endpoints {

    @Test (description = "Create an user")
    public void createNewUser() {
        Map<String, String> request = new HashMap<>();
        request.put("name", "QA tester");
        request.put("job", "best job");

        given().spec(requestSpecification).
            body(request).
        when().
            post(Endpoints.USER_ENDPOINT).
        then().
            assertThat().statusCode(201).
            body("name", equalTo("QA tester"),
                "job", is("best job"));
    }

    @Test (description = "Get user by id")
    public void getUserByID() {
        given().spec(requestSpecification).
                pathParam("userID",12).
                log().ifValidationFails().
        when().
                 get(Endpoints.USER_ENDPOINT + "/{userID}")
        .then()
                .log().body()
                .statusCode(200)
                .body("data.first_name", equalTo("Rachel"),
                        "data.last_name", is("Howell"));
    }


    @Test(description = "Update user with Put request")
    public void updateUserWithPut() {
        Map<String, String> request = new HashMap<>();
        request.put("name", "QA tester");
        request.put("job", "best job");

        given().spec(requestSpecification).
                body(request).
        when().
                put(Endpoints.UPDATE_USER_ENDPOINT).
        then().
                assertThat().statusCode(200).
                body("name", equalTo("QA tester"),
                        "job", is("best job"));

    }
    @Test(description = "Update user with Patch request")
    public void updateUserWithPatch() {
        Map<String, String> request = new HashMap<>();
        request.put("name", "QA tester");
        request.put("job", "best job");

        given().spec(requestSpecification).
                body(request).
        when().
                patch(Endpoints.UPDATE_USER_ENDPOINT).
        then().
                assertThat().statusCode(200).
                body("name", equalTo("QA tester"),
                        "job", is("best job"));

    }

    @Test (description = "Delete user by ID")
    public void deletePetById() {
                given().spec(requestSpecification).
                pathParam("userID",12).
                log().ifValidationFails().
        when().
                 delete(Endpoints.USER_ENDPOINT + "/{userID}")
        .then()
                .log().body()
                .statusCode(204);
    }
}



