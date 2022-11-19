package tests;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;
public class BaseTest {
    @BeforeAll
    static void beforeConfig() {
        SelenideLogger.addListener("listenerAllure",new AllureSelenide().screenshots(true).savePageSource(false));
        Configuration.timeout = 3000; // Умное ожидание появление элемента на странице
        Configuration.browserSize = "1920x1080";
    }
    @BeforeEach
    void before() {
        Selenide.open(Locators.baseUrl);
        Locators.logoImg.shouldBe(visible);
        // BaseSteps.login();
    }
    @AfterEach
    void after() {
        closeWebDriver();
    }
}
