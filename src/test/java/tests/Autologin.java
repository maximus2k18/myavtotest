package tests;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static com.codeborne.selenide.Condition.visible;

public class Autologin extends BaseTest {
// сделать приоритет выполнения тестов
    @Override
    @BeforeEach
    void before() {
        super.before();
        Selenide.open(Locators.baseUrl);
        Locators.logoImg.shouldBe(visible);
        BaseSteps.login();
    }

    @Test
    void selectAva1()
    {
        BaseSteps.selectAva();
    }
  //  @Test
    void loginsWithoutPassword()
    {
        BaseSteps.login();
    }
  //  @Test
     void loginWithoutPassword()
    {
        BaseSteps.login2();
    }
  //  @Test
    void blockinCard1()
    {
      //  BaseSteps.login();
        BaseSteps.blockinCard();

    }
 //   @Test
    void unBlockinCard1()
    {
      //  BaseSteps.login();
        BaseSteps.switchPanelCard();
        BaseSteps.unBlockinCard();
      //  $(byTagAndText("h1", "Hello world")).shouldHave(Condition.attribute("Hello World"));
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
