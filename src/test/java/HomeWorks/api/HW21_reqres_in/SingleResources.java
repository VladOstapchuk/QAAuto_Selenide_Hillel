package HomeWorks.api.HW21_reqres_in;

import io.restassured.response.Response;
import org.apache.http.HttpStatus;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.com.api.HW22.reqres_in.requests.SendRequest.sendGetRequest;
import static org.com.api.HW22.reqres_in.specification.ReqSpecification.reqSpecification;
import static org.hamcrest.Matchers.*;

public class SingleResources {

    String baseUrl = "https://reqres.in";

    @Test
    public void singleResources() {
        given()
                .log().all()
                .contentType("application/json")
                .when()
                .get(baseUrl + "/api/unknown/2")
                .then()
                .statusCode(HttpStatus.SC_OK)
                .body(containsString("data"))
                .body(containsString("support"))
                .body("data.id", equalTo(2))
                .body("data.name", equalTo("fuchsia rose"))
                .body("data.year", equalTo(2001))
                .body("data.color", equalTo("#C74375"))
                .body("data.pantone_value", equalTo("17-2031"))
                .log().body();
    }

    @Test
    public void singleResources2() {
        Response response = sendGetRequest(
                reqSpecification,
                "/api/unknown/2",
                HttpStatus.SC_OK);
        response
                .then()
                .body(containsString("data"))
                .body(containsString("support"))
                .body("data.id", equalTo(2))
                .body("data.name", equalTo("fuchsia rose"))
                .body("data.year", equalTo(2001))
                .body("data.color", equalTo("#C74375"))
                .body("data.pantone_value", equalTo("17-2031"))
                .log().body();
    }
}
