package org.com.api.HW22.reqres_in.specification;

import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;


public class ReqSpecification {

    public static RequestSpecification reqSpecification =
            new RequestSpecBuilder()
                    .setBaseUri("https://reqres.in")
                    .setContentType(ContentType.JSON)
                    .setAccept("application/json")
                    .addHeader("User-Agent", "QAAutoTest")
                    .log(LogDetail.ALL)
                    .build()
                    .filter(new AllureRestAssured());
}
