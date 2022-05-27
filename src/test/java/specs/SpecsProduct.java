package specs;

import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

import static helpers.CustomAllureListener.withCustomTemplates;
import static io.restassured.RestAssured.with;

public class SpecsProduct {

    public static RequestSpecification requestProduct = with()
            .filter(withCustomTemplates())
            .baseUri("https://www.citilink.ru/basket/add/product/")
            .log().body();

    public static ResponseSpecification responseSpecProduct = new ResponseSpecBuilder()
            .expectStatusCode(200)
            .build();
}
