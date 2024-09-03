package HomeWorks.api.HW21_reqres_in;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.apache.http.HttpStatus;
import org.com.api.HW22.reqres_in.pojo.bodyrequest.UserData;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.com.api.HW22.reqres_in.requests.SendRequest.sendPostRequestLogin;
import static org.com.api.HW22.reqres_in.specification.ReqSpecification.reqSpecification;
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

    @Test
    public void loginUnsuccessful2() {
        UserData userData =
                new UserData("eve.holt@reqres.in");

        Response response = sendPostRequestLogin(
                reqSpecification,
                userData,
                "/api/login",
                HttpStatus.SC_BAD_REQUEST);
        response
                .then()
                .body(containsString("error"))
                .body("error", equalTo("Missing password"));



    }
}
