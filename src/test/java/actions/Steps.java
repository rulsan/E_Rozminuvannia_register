package actions;

import io.qameta.allure.Step;
import io.restassured.http.ContentType;
import pojo.Claim;
import pojo.Response;
import pojo.ResponseWithErrors;
import specifications.Specifications;

import static io.restassured.RestAssured.given;

public class Steps {

    @Step("register claim step")
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

    @Step("register claim step with validation errors")
    public static ResponseWithErrors registerClaimWithValidationErrors(Claim claim){
        Specifications.installSpecification(Specifications.requestSpec());
        return given()
                .contentType(ContentType.JSON)
                .body(claim)
                .when()
                .post()
                .then()
                .extract().as(ResponseWithErrors.class);
    }
}
