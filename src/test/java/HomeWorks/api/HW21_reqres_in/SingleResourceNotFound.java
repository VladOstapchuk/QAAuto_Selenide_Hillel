package HomeWorks.api.HW21_reqres_in;

import io.restassured.response.Response;
import org.apache.http.HttpStatus;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.com.api.HW22.reqres_in.requests.SendRequest.sendGetRequest;
import static org.com.api.HW22.reqres_in.specification.ReqSpecification.reqSpecification;
import static org.hamcrest.Matchers.equalTo;

public class SingleResourceNotFound {

    String baseUrl = "https://reqres.in";

    @Test
    public void singleResourceNotFound() {
        given()
                .log().all()
                .contentType("application/json")
                .when()
                .get(baseUrl + "/api/unknown/23")
                .then()
                .statusCode(HttpStatus.SC_NOT_FOUND)
                .body(equalTo("{}"));
    }

    @Test
    public void singleResourceNotFound2() {
        Response response = sendGetRequest(
                reqSpecification,
                "/api/unknown/23",
                HttpStatus.SC_NOT_FOUND);
        response
                .then()
                .body(equalTo("{}"));
    }
}
