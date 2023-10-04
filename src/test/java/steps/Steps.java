package steps;

import io.qameta.allure.Step;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import pojo.Claim;
import pojo.Response;
import pojo.ResponseWithErrors;
import specifications.Specifications;

import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static specifications.Specifications.installSpecification;
import static utils.Utils.executeQuery;

public class Steps {

    private final static Logger logger = LogManager.getLogger();

    @Step("register claim step")
    public static Response registerClaim(Claim claim){
        installSpecification(Specifications.requestSpec(), Specifications.responseSpec(200));
        return given()
                .body(claim)
                .when()
                .post()
                .then()
                .extract().as(Response.class);
    }

    @Step("register claim step with validation errors")
    public static ResponseWithErrors registerClaimWithValidationErrors(Claim claim){
        installSpecification(Specifications.requestSpec(), Specifications.responseSpec(200));
        return given()
                .body(claim)
                .when()
                .post()
                .then()
                .extract().as(ResponseWithErrors.class);
    }

    @Step("get data from DB")
    public static List<Map<String,Object>> getDataFromDB(String query){
        List<Map<String,Object>> response = executeQuery(query);
        logger.info(response);
        return response;
    }
}
