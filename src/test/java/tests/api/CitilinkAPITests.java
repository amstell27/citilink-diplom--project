package tests.api;


import org.hamcrest.Matchers;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import tests.ui.TestBase;


import static io.restassured.RestAssured.given;
import static io.restassured.http.ContentType.JSON;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.is;


public class CitilinkAPITests{

    @Test
    @Disabled
    @DisplayName("Check to add the service in the basket")
    void getServiceBusketTest() {
        String data = "productId=1617484&serviceId=J5437&serviceType=cardifService&serviceQty=1";
        given()
                .contentType(JSON)
                .contentType("application/x-www-form-urlencoded; charset=UTF-8")
                .header("x-requested-with", "XMLHttpRequest")
                .cookie("_ym_uid=1608259004176543918; flixgvid=flix60027b4e000000.58023292; inptime0_5759_ru=0; old_design=0; _tuid=262f589b2fab382ec89a17ff82a0aa33e97cffa7; _dy_csc_ses=t; _dyjsession=24d2795e7f830bf648844799a618e406; _ga=GA1.2.43253941.1640235144; _ym_d=1640235144; _gcl_au=1.1.1873281959.1650206167; userId=IL05880548; clientId=43253941.1640235144; check_push=1; ecommerce_yandex=1; _dy_c_exps=; _dy_c_att_exps=; _dycnst=dg; _dyid=-8174032458781712761; _dycst=dk.w.o.ws.; _dy_user_has_affinity=true; _dy_cs_cookie_items=_dy_user_has_affinity; __ttl__widget__ui=1652249031025-9a626c1ecf84; infoCookieUses=true; isWebMobile=false; dy_fs_page=www.citilink.ru; _dy_geo=RU.EU.RU_NVS.RU_NVS_Novosibirsk; _dy_df_geo=Russia..Novosibirsk; _space=kzn_cl%3A; _dy_toffset=-1; is_show_welcome_mechanics=1; ab_test=90x10v4%3A1%7Creindexer%3A2%7Cnew_designv10%3A2%7Cnew_designv13%3A1%7Cproduct_card_design%3A3%7Cdynamic_yield%3A3%7Cwelcome_mechanics%3A4%7Cdummy%3A10; ab_test_analytics=90x10v4%3A1%7Creindexer%3A2%7Cnew_designv10%3A2%7Cnew_designv13%3A1%7Cproduct_card_design%3A3%7Cdynamic_yield%3A3%7Cwelcome_mechanics%3A4%7Cdummy%3A10; _dy_ses_load_seq=32050%3A1652681997873; _dy_lu_ses=24d2795e7f830bf648844799a618e406%3A1652681999180; _gid=GA1.2.575387803.1652681999; _ym_isad=1; _dy_soct=1017570.1030352.1652681997*1033770.1068198.1652681997*1036008.1075335.1652681997*1046273.1214460.1652681997*1071708.1227551.1652681997*1008131.1012968.1652681997*1015299.1026209.1652681997*1060477.1210873.1652681997*1015300.1026211.1652681999*1041134.1093514.1652682000*1044459.1102992.1652682000")
                .body(data)
                .when()
                .post("https://www.citilink.ru/basket/product/add/service/")
                .then()
                .log().body()
                .statusCode(200)
                .body("storage.cart.list.1617484.amount", is(1));;

    }

    @Test
    @DisplayName("Check to add the product in the basket")
    void getProductBusketTest() {
        String amount = "1",
                parent_id = "420251";

        given()
                .contentType(JSON)
                .log().uri()
                .log().body()
                .when()
                .get("https://www.citilink.ru/basket/add/product/" + parent_id + "/?amount=" + amount + "&parent_id=" + parent_id)
                .then()
                .log().status()
                .log().body()
                .statusCode(200)
                .body("storage.cart.list." + parent_id + ".amount", is(1));

    }

    @Test
    @Disabled
    @DisplayName("Check to add the product in the basket with cookie")
    void addProductBusketTest() {
        String amount = "5",
                parent_id = "420251";

        given()
                .contentType(JSON)
                .cookie("_tuid=4501b28718a8c0feb106d36bbbca3d3ac0137fc1;")
                .log().uri()
                .log().body()
                .when()
                .get("https://www.citilink.ru/basket/add/product/" + parent_id + "/?amount=" + amount + "&parent_id=" + parent_id)
                .then()
                .log().status()
                .log().body()
                .statusCode(200)
                .body("storage.cart.list." + parent_id + ".amount", greaterThan(6));

    }

    @Test
    @Disabled
    @DisplayName("Check to add the product in the basket over max limit")
    void limitProductBusketTest() {
        String amount = "105",
                parent_id = "420251";

        given()
                .contentType(JSON)
                .cookie("_tuid=4501b28718a8c0feb106d36bbbca3d3ac0137fc1;")
                .log().uri()
                .log().body()
                .when()
                .get("https://www.citilink.ru/basket/add/product/" + parent_id + "/?amount=" + amount + "&parent_id=" + parent_id)
                .then()
                .statusCode(200)
                .body("storage.cart.list." + parent_id + ".amount", Matchers.not(105));

    }


}
