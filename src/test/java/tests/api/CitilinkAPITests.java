package tests.api;

import io.restassured.http.Cookies;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.is;
import static specs.SpecsProduct.requestProduct;
import static specs.SpecsProduct.responseSpecProduct;
import static specs.SpecsService.request;
import static specs.SpecsService.responseSpecService;

@Tag("API")
public class CitilinkAPITests {

    @Test
    @DisplayName("Проверка на добавление услуг в корзину")
    void getServiceBusketTest() {

        String Authcookie = "_tuid=262f589b2fab382ec89a17ff82a0aa33e97cffa7; userId=IL05880548; clientId=43253941.1640235144;",
                data = "productId=1617484&serviceId=J5437&serviceType=cardifService&serviceQty=1";
        given()
                .spec(request)
                .cookie(Authcookie)
                .body(data)
                .when()
                .post("")
                .then()
                .spec(responseSpecService)
                .body("storage.cart.list.1617484.subItems.J5437.amount", is(1));
    }


    @Test
    @DisplayName("Проверка на добавление в корзину")
    void addProductBusketTest() {

        Cookies authCookie = given()
                .spec(requestProduct)
                .when()
                .get("/420251/?amount=1&parent_id=420251&")
                .then()
                .extract().detailedCookies();
        given()
                .spec(requestProduct)
                .cookie(authCookie.toString())
                .when()
                .post("420251/?amount=5&parent_id=420251")
                .then()
                .spec(responseSpecProduct)
                .body("storage.cart.list.420251.amount", is(5));
    }

    @Test
    @DisplayName("Проверка на добавление в корзину сверх возможного лимита")
    void limitProductBusketTest() {

        String amount = "100500",
                parent_id = "420251";

        Cookies authCookie = given()
                .spec(requestProduct)
                .when()
                .get(parent_id + "/?amount=" + amount + "&parent_id=" + parent_id)
                .then()
                .extract().detailedCookies();

        given()
                .spec(requestProduct)
                .cookie(authCookie.toString())
                .when()
                .post(parent_id + "/?amount=" + amount + "&parent_id=" + parent_id)
                .then()
                .spec(responseSpecProduct)
                .body("storage.cart.list." + parent_id + ".amount", Matchers.not(100500));
    }
}
