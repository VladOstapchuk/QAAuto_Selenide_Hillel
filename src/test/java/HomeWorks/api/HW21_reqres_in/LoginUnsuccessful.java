package HomeWorks.api.HW21_reqres_in;

import io.restassured.RestAssured;
import org.apache.http.HttpStatus;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class LoginUnsuccessful {

   // String baseUrl = "https://reqres.in";
    String body = "{\n" +
            "\n" +
            "  \"email\": \"eve.holt@reqres.in\"\n" +
            "\n" +
            "}";

    @Test
    public void loginUnsuccessful() {

        RestAssured.baseURI = "https://reqres.in";

        given()
                .log().all()
                .contentType("application/json")
                .body(body)
                .when()
                .post( "/api/login")
                .then()
                .statusCode(HttpStatus.SC_BAD_REQUEST)
                .body(containsString("error"))
                .body("error", equalTo("Missing password"));
    }
}
