package tests;
import io.qameta.allure.Description;
import io.qameta.allure.Step;

import java.time.Duration;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.switchTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
public class BaseSteps {
    @Step("Log-е")
    static void login() {
        Locators.input.shouldBe(visible).val("demo");
        Locators.passwordInput.shouldBe(visible).val("demo");
        Locators.logInButton.shouldBe(visible).click();
        Locators.logoImg.shouldBe(visible);
        Locators.smsInput.shouldBe(visible).val("0000");
        Locators.codeButton.shouldBe(visible).click();
        Locators.logoIn.shouldBe(visible);
        Locators.appName.shouldBe(visible, Duration.ofSeconds(11));
        assertThat("Не соответствует текст", Locators.appName.getText(), containsString("Интернет-банк"));
    }
    @Step
    static void login2() {
        Locators.input.shouldBe(visible).val("demo");
        Locators.logInButton.shouldBe(visible).click();
        Locators.logoImg.shouldBe(visible);
        Locators.smsInput.shouldBe(visible).val("0000");
        Locators.codeButton.shouldBe(visible).click();
        Locators.logoIn.shouldBe(visible);
        Locators.appName.shouldBe(visible, Duration.ofSeconds(11));
        assertThat("Не соответствует текст", Locators.appName.getText(), containsString("Интернет-банк"));
    }
    @Step
    @Description("Выбор Аватарки")
    static void selectAva() {
        Locators.clickAvatar.shouldBe(visible).click();
        switchTo().frame(Locators.iframe);
        Locators.selectImg.shouldBe(visible).click();
        Locators.saveButton.shouldHave(text("Сохранить")); //Матчер, если не выполняется, то тест падает
        Locators.saveButton.click();
    }
    @Step
    static void blockinCard()
    {
        Locators.selectCard.shouldBe(visible).click();
        Locators.checkCardOn.shouldHave(text("Действует"));
        Locators.panelBlockCard.shouldBe(visible).click();
        Locators.blockCard.shouldBe(visible).click();
        switchTo().frame($x("//iframe[@id='confirmation-frame']"));
        Locators.confirmCard.shouldBe(visible).click();
    }
    @Step
        static void unBlockinCard() {
        switchTo().frame($x("//iframe"));
        Locators.confirmCard.shouldBe(visible).click();
    }
    @Step
    static void switchPanelCard()
    {
        Locators.selectCard.shouldBe(visible).click();
        Locators.checkCardOff.shouldBe(visible).shouldHave(text("Заблокирована"));
        Locators.panelUnblockCard.shouldBe(visible).click();
    }


}
