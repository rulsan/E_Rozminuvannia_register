package actions;

import io.qameta.allure.Step;
import io.restassured.http.ContentType;
import pojo.Claim;
import pojo.Response;
import specifications.Specifications;

import static io.restassured.RestAssured.given;

public class Action {

//    @Step("register claim step")
    public static Response registerClaim(Claim claim){
        Specifications.installSpecification(Specifications.requestSpec());
        return given()
                .contentType(ContentType.JSON)
                .body(claim)
                .when()
                .post()
                .then()
                .extract().as(Response.class);
    }
}
