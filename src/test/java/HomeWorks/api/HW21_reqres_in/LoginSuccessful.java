package HomeWorks.api.HW21_reqres_in;

import org.apache.http.HttpStatus;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class LoginSuccessful {

    String baseUrl = "https://reqres.in";
    String body = "{\n" +
            "    \"email\": \"eve.holt@reqres.in\",\n" +
            "    \"password\": \"cityslicka\"\n" +
            "}";

    @Test
    public void loginSuccessful() {
        given()
                .log().all()
                .contentType("application/json")
                .body(body)
                .when()
                .post(baseUrl + "/api/login")
                .then()
                .statusCode(HttpStatus.SC_OK)
                .body(containsString("token"))
                .body("token", notNullValue());
    }
}
