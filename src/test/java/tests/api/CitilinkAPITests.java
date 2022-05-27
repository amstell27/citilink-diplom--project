package tests.api;

import io.restassured.http.Cookies;
import models.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static io.qameta.allure.Allure.step;
import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
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
        step("Отправляем запрос на добавление услуги");
        StorageModel response =
                given()
                        .spec(request)
                        .cookie(Authcookie)
                        .body(data)
                        .when()
                        .post()
                        .then()
                        .spec(responseSpecService)
                        .extract().as(StorageModel.class);
        step("Проверяем добавление услуги в корзину");
        assertEquals(1, response.getStorage().getCart().getList().getProduct().getSubItems().getServiceName().getAmount());
    }


    @Test
    @DisplayName("Проверка на добавление товара в корзину")
    void addProductBusketTest() {

        step("Отправляем запрос на добавление товара");
        Cookies authCookie = given()
                .spec(requestProduct)
                .when()
                .get("/420251/?amount=1&parent_id=420251&")
                .then()
                .extract().detailedCookies();
        StorageModel response =
                given()
                        .spec(requestProduct)
                        .cookie(authCookie.toString())
                        .when()
                        .post("420251/?amount=5&parent_id=420251")
                        .then()
                        .spec(responseSpecProduct)
                        .extract().as(StorageModel.class);

        step("Проверяем добавление товара в корзину");
        assertEquals(5, response.getStorage().getCart().getList().getProductInformation().getAmount());
    }

    @Test
    @DisplayName("Проверка на добавление в корзину сверх возможного лимита")
    void limitProductBusketTest() {
        step("Отправляем запрос на добавление услуги");
        String amount = "100500",
                parent_id = "420251";

        Cookies authCookie = given()
                .spec(requestProduct)
                .when()
                .get(parent_id + "/?amount=" + amount + "&parent_id=" + parent_id)
                .then()
                .extract().detailedCookies();
        StorageModel response =
                given()
                        .spec(requestProduct)
                        .cookie(authCookie.toString())
                        .when()
                        .post(parent_id + "/?amount=" + amount + "&parent_id=" + parent_id)
                        .then()
                        .spec(responseSpecProduct)
                        .extract().as(StorageModel.class);

        step("Проверяем добавление услуги в корзину");
        assertNotEquals(amount, response.getStorage().getCart().getList().getProductInformation().getAmount());

    }
}
