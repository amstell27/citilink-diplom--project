package specs;

import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

import static helpers.CustomAllureListener.withCustomTemplates;
import static io.restassured.RestAssured.with;


public class SpecsService {

    public static RequestSpecification request = with()
            .filter(withCustomTemplates())
            .baseUri("https://www.citilink.ru/basket/product/add/service/")
            .log().body()
            .contentType("application/x-www-form-urlencoded; charset=UTF-8")
            .header("x-requested-with", "XMLHttpRequest");

    public static ResponseSpecification responseSpecService = new ResponseSpecBuilder()
            .expectStatusCode(200)
            .build();
}