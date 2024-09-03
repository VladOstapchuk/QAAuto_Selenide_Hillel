package HomeWorks.api.HW21_reqres_in;

import io.restassured.response.Response;
import org.apache.http.HttpStatus;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.com.api.HW22.reqres_in.requests.SendRequest.sendGetRequest;
import static org.com.api.HW22.reqres_in.requests.SendRequest.sendPostRequestLogin;
import static org.com.api.HW22.reqres_in.specification.ReqSpecification.reqSpecification;
import static org.hamcrest.Matchers.*;

public class SingleUser {

    String baseUrl = "https://reqres.in";
    String expcetedResponce = "{id=2, email=janet.weaver@reqres.in, first_name=Janet, last_name=Weaver, avatar=https://reqres.in/img/faces/2-image.jpg}";
    String body = "{\n" +
            " \"data\": {\n" +
            "  \"id\": 2,\n" +
            "         \"email\": \"janet.weaver@reqres.in\",\n" +
            "    \"first_name\": \"Janet\",\n" +
            "   \"last_name\": \"Weaver\",\n" +
            "   \"avatar\": \"https://reqres.in/img/faces/2-image.jpg\"\n" +
            "},\n" +
            " \"support\": {\n" +
            "  \"url\": \"https://reqres.in/#support-heading\",\n" +
            "   \"text\": \"To keep ReqRes free, contributions towards server costs are appreciated!\"\n" +
            "}\n" +
            "}\n";

    @Test
    public void singleUser() {

        given()
                .log().all()
                .contentType("application/json")
                //.body(body)
                .when()
                .get(baseUrl + "/api/users/2")
                .then()
                .statusCode(HttpStatus.SC_OK)
                .body(containsString("data"))
                .body(containsString("support"))
                .body("data.id", equalTo(2))
                .body("data.email", equalTo("janet.weaver@reqres.in"))
                .body("data.first_name", equalTo("Janet"))
                .body("data.last_name", equalTo("Weaver"))
                .body("data.avatar", equalTo("https://reqres.in/img/faces/2-image.jpg"));
    }

    @Test
    public void singleUser2() {
        Response response = sendGetRequest(
                reqSpecification,
                "/api/users/2",
                HttpStatus.SC_OK);
        response
                .then()
                .body(containsString("data"))
                .body(containsString("support"))
                .body("data.id", equalTo(2))
                .body("data.email", equalTo("janet.weaver@reqres.in"))
                .body("data.first_name", equalTo("Janet"))
                .body("data.last_name", equalTo("Weaver"))
                .body("data.avatar", equalTo("https://reqres.in/img/faces/2-image.jpg"));
    }
}
