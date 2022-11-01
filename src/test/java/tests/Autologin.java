package tests;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.junit.jupiter.api.Test;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
public class Autologin extends BaseSteps{
    @Step("Изменить аватар")
    @Test
    void selectAva() {
        Locators.clickAvatar.shouldBe(visible).click();
        switchTo().frame($x("(//div[@id='contentbar']/iframe)"));
        Locators.selectImg.shouldBe(visible).click();
        Locators.saveButton.shouldHave(text("Сохранить")); //Матчер, если не выполняется, то тест падает
        Locators.saveButton.click();
    }
    @Step("Блокировка-Разблокировка")
    @Test
    void blockinCard() {
        Locators.selectCard.shouldBe(visible).click();
        Locators.checkCardOn.shouldHave(text("Действует"));
        Locators.panelBlockCard.shouldBe(visible).click();
        Locators.blockCard.shouldBe(visible).click();
        switchTo().frame($x("//iframe[@id='confirmation-frame']"));
        Locators.confirmCard.shouldBe(visible).click();

        Locators.checkCardOff.shouldBe(visible);
        Locators.checkCardOff.shouldHave(text("Заблокирована"));
        Locators.panelUnblockCard.shouldBe(visible).click();
        switchTo().frame($x("//iframe"));
        Locators.confirmCard.shouldBe(visible).click();
    }
    /*void appCheckAlert() {
        final SelenideElement alert = $x("//div[@class='alert alert-error']");
        assertThat("Не соответствует текст", alert.getText(), containsString("Демо-пользователь не может менять настройки."));
    }

    void appCheckName() {
        //appName.shouldHave(text("bank")); // матчеры интегрированные в селенид. Делает скриншот
         // матчеры как отдельная библиотека. Не делает скриншот
    }
    void frameOut() {
        switchTo().defaultContent();
        Locators.logoImg.shouldBe(visible).click();
    }*/

}
