package HomeWorks.api.HW21_reqres_in;

import org.apache.http.HttpStatus;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class LoginUnsuccessful {

    String baseUrl = "https://reqres.in";
    String body = "{\n" +
            "\n" +
            "  \"email\": \"eve.holt@reqres.in\"\n" +
            "\n" +
            "}";

    @Test
    public void loginUnsuccessful() {
        given()
                .log().all()
                .contentType("application/json")
                .body(body)
                .when()
                .post(baseUrl + "/api/login")
                .then()
                .statusCode(HttpStatus.SC_BAD_REQUEST)
                .body(containsString("error"))
                .body("error", equalTo("Missing password"));
    }
}
