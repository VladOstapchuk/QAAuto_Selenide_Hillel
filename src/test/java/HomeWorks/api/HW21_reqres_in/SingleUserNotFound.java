package HomeWorks.api.HW21_reqres_in;

import io.restassured.response.Response;
import org.apache.http.HttpStatus;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.com.api.HW22.reqres_in.requests.SendRequest.sendGetRequest;
import static org.com.api.HW22.reqres_in.specification.ReqSpecification.reqSpecification;
import static org.hamcrest.Matchers.equalTo;

public class SingleUserNotFound {

    String baseUrl = "https://reqres.in";

    @Test
    public void singleUserNotFound() {

        given()
                .log().all()
                .contentType("application/json")
                .when()
                .get(baseUrl + "/api/users/23")
                .then()
                .statusCode(HttpStatus.SC_NOT_FOUND)
                .log().body()
                .body(equalTo("{}"));
    }

    @Test
    public void singleUserNotFound2() {
        Response response = sendGetRequest(
                reqSpecification,
                "/api/users/23",
                HttpStatus.SC_NOT_FOUND);
        response
                .then()
                .body(equalTo("{}"));
    }
}
