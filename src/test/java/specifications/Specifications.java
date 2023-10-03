package specifications;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class Specifications {

    private static final String URL = "http://192.168.189.11:3040/";
    private static final String PATH = "api/v1/claim-register/register";
    private static final String USERNAME = "";
    private static final String PASSWORD = "";

    public static RequestSpecification requestSpec(){
        return new RequestSpecBuilder()
                .setBaseUri(URL)
                .setBasePath(PATH)
                .setAuth(RestAssured.preemptive().basic(USERNAME, PASSWORD))
                .log(LogDetail.ALL)
                .build();
    }

    public static ResponseSpecification responseSpec(int status){
        return new ResponseSpecBuilder()
                .expectStatusCode(status)
                .log(LogDetail.ALL)
                .build();
    }
    public static void installSpecification(RequestSpecification requestSpec, ResponseSpecification responseSpec){
        RestAssured.requestSpecification = requestSpec;
        RestAssured.responseSpecification = responseSpec;
    }

    public static void installSpecification(RequestSpecification requestSpec){
        RestAssured.requestSpecification =requestSpec;
    }
    public static void installSpecification(ResponseSpecification responseSpec){
        RestAssured.responseSpecification =responseSpec;
    }
}
