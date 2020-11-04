package classes;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.testng.annotations.BeforeMethod;

import static org.hamcrest.Matchers.lessThan;

public class TestConfig implements Endpoints {
    public static RequestSpecification requestSpecification;
    public static ResponseSpecification successResponseSpec;

    @BeforeMethod
    public static void setup(){

        requestSpecification = new RequestSpecBuilder().
                setBaseUri(Endpoints.BASE_URL).
                //setPort(8080).
                setBasePath("/api/").
                addHeader("Content-Type","application/json").
                addHeader("Accept","application/json").
                build();

        successResponseSpec = new ResponseSpecBuilder().
                expectStatusCode(200).
                expectResponseTime(lessThan(3000L)).
                build();
    }
}
