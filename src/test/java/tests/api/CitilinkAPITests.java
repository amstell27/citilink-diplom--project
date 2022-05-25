package tests.api;

import io.restassured.http.Cookies;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.is;

@Tag("API")
public class CitilinkAPITests {

    @Test
    @DisplayName("Check to add the service in the basket")
    void getServiceBusketTest() {

        String Authcookie = "_tuid=262f589b2fab382ec89a17ff82a0aa33e97cffa7; userId=IL05880548; clientId=43253941.1640235144;",
                data = "productId=1617484&serviceId=J5437&serviceType=cardifService&serviceQty=1";
        given()
                .contentType("application/x-www-form-urlencoded; charset=UTF-8")
                .header("x-requested-with", "XMLHttpRequest")
                .cookie(Authcookie)
                .body(data)
                .when()
                .post("https://www.citilink.ru/basket/product/add/service/")
                .then()
                .log().body()
                .statusCode(200)
                .body("storage.cart.list.1617484.amount", is(1));
    }

    @Test
    @DisplayName("Check to add the product in the basket")
    void getProductBusketTest() {
//        String amount = "1",
//                parent_id = "420251",
//                token = "1652783436497";
        given()
                .when()
                .post("https://www.citilink.ru/basket/add/product/420251/?amount=1&parent_id=420251&_=1652783436497")
                .then()
                .statusCode(200)
                .body("storage.cart.list.420251.amount", is(1));
    }

    @Test
    @DisplayName("Check to add the product in the basket with cookie")
    void addProductBusketTest() {

    Cookies authCookie = given()
            .when()
            .get("https://www.citilink.ru/basket/add/product/420251/?amount=1&parent_id=420251")
            .then()
            .extract().detailedCookies();
        given()
                .cookie(authCookie.toString())
                .when()
                .get("https://www.citilink.ru/basket/add/product/420251/?amount=5&parent_id=420251&_=1652783436497")
                .then()
                .statusCode(200)
                .body("storage.cart.list.420251.amount", is(5));
    }

    @Test
    @DisplayName("Check to add the product in the basket over max limit")
    void limitProductBusketTest() {
        String amount = "100500",
                parent_id = "420251";
        given()
                .when()
                .get("https://www.citilink.ru/basket/add/product/" + parent_id + "/?amount=" + amount + "&parent_id=" + parent_id)
                .then()
                .statusCode(200)
                .body("storage.cart.list." + parent_id + ".amount", Matchers.not(100500));
    }
}
