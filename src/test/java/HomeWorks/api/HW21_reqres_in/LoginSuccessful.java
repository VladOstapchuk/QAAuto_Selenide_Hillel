package HomeWorks.api.HW21_reqres_in;

import io.restassured.response.Response;
import org.apache.http.HttpStatus;
import org.com.api.HW22.reqres_in.pojo.bodyrequest.UserData;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.com.api.HW22.reqres_in.requests.SendRequest.sendPostRequestLogin;
import static org.com.api.HW22.reqres_in.specification.ReqSpecification.reqSpecification;
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

    @Test
    public void loginSuccessful2() {
        UserData userData =
                new UserData("eve.holt@reqres.in", "cityslicka");

        Response response = sendPostRequestLogin(
                reqSpecification,
                userData,
                "/api/login",
                HttpStatus.SC_OK);
        response
                .then()
                .body(containsString("token"))
                .body("token", notNullValue());

    }
}
