package org.com.api.HW22.reqres_in.requests;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.com.api.HW22.reqres_in.specification.ReqSpecification;
import org.openqa.selenium.devtools.v125.fetch.model.AuthChallengeResponse;

import static io.restassured.RestAssured.given;

public class SendRequest {

    public static Response sendPostRequestLogin(RequestSpecification reqSpecification,
                                                Object bodyObject, String endpoint,
                                                int expectedStatusCode) {
return given()
        .spec(reqSpecification)
        .when()
        .body(bodyObject)
        .log().all()
        .post(endpoint)
        .then()
        .log().all()
        .statusCode(expectedStatusCode)
        .extract().response();
    }

    public static Response sendGetRequest(RequestSpecification reqSpecification,
                                                String endpoint,
                                                int expectedStatusCode) {
        return given()
                .spec(reqSpecification)
                .when()
                .log().all()
                .get(endpoint)
                .then()
                .log().all()
                .statusCode(expectedStatusCode)
                .extract().response();
    }
}
