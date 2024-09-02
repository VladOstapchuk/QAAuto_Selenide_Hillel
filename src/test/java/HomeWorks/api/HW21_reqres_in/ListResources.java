package HomeWorks.api.HW21_reqres_in;

import org.apache.http.HttpStatus;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class ListResources {

    String baseUrl = "https://reqres.in";

    @Test
    public void listResources() {
        given()
                .log().all()
                .contentType("application/json")
                .when()
                .get(baseUrl + "/api/unknown")
                .then()
                .statusCode(HttpStatus.SC_OK)
                .body(containsString("page"))
                .body(containsString("per_page"))
                .body(containsString("total"))
                .body(containsString("total_pages"))
                .body(containsString("data"))
                .body("data", everyItem(hasKey("id")))
                .body("data", everyItem(hasKey("name")))
                .body("data", everyItem(hasKey("year")))
                .body("data", everyItem(hasKey("color")))
                .body("data", everyItem(hasKey("pantone_value")))
                .log().body();
    }
}
