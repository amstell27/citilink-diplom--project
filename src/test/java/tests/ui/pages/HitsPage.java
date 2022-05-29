package tests.ui.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

public class HitsPage {

    private final SelenideElement
            top = $("[class='TopHundred']");

    public HitsPage topProduct() {
        top.shouldHave(text("Популярное в Топ 100"));
        return this;
    }
}
