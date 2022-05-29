package tests.mobile.pages;

import com.codeborne.selenide.SelenideElement;
import io.appium.java_client.AppiumBy;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

public class CartPage {

    private final SelenideElement
            checkProduct = $(AppiumBy.id("ru.citilink:id/constraintLayoutCartProduct"))
            .$(AppiumBy.id("ru.citilink:id/textViewCartProductName"));

    public CartPage checkToAddProduct(String product) {
        checkProduct.shouldHave(text(product));
        return this;
    }
}
