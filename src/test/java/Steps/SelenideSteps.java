package Steps;

import PageObject.*;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import cucumber.api.java.en.When;
import org.junit.After;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.Keys;

import java.time.Duration;

import static com.codeborne.selenide.Condition.visible;

public class SelenideSteps {

    PageObject.AddRemoveElements addRemoveElements = new AddRemoveElements();
    FormAuthentication formAuthentication = new FormAuthentication();
    KeyPresses keyPresses = new KeyPresses();
    String keyGlobal;

    @BeforeAll
    public static void setBrowConf() {
        Configuration.browser = "chrome";
        Configuration.startMaximized = true;
    }

    @When("^проверить что добавились элементы в количестве (.*), которое передали на вход$")
    public void AddRemoveElementsTest(int count)  {
        Selenide.open(addRemoveElements.getUrl());
        for (int i = 0; i < count; i++) {
            addRemoveElements.getAddElementButton()
                    .shouldBe(Condition.enabled, visible)
                    .click();
        }
        Assert.assertEquals("Текст не совпал", count, addRemoveElements.getDeleteButton().size());
    }

    @When("^проверить возможность авторизации с правильными логином/паролем$")
    public void FormAuthenticationTest() {
        Selenide.open(formAuthentication.getUrl());
        formAuthentication.getUsername().sendKeys("tomsmith");
        formAuthentication.getPassword().sendKeys("SuperSecretPassword!");
        formAuthentication.getLoginButton().click();
        Assert.assertTrue("кнопка Logout не отображается ", formAuthentication.getLogoutButton().isDisplayed());
    }

    @When("^проверить возможность авторизации с неправильными логином/паролем$")
    public void FormAuthenticationTestNegative() {
        Selenide.open("http://the-internet.herokuapp.com/login");
        formAuthentication.getUsername().sendKeys("wrongName");
        formAuthentication.getPassword().sendKeys("wrongPassword");
        formAuthentication.getLoginButton().click();
        Assert.assertFalse("нет сообщения о неправильном логине ",
                formAuthentication.getLogoutButton().isDisplayed());
    }

    @When("^проверить что при наведении курсора на одного из аватаров пользователя отображается текст$")
    public void HoversTest() {
        Hovers hovers = new Hovers();
        Selenide.open(hovers.getUrl());
        hovers.getHovers().get(0).hover();
        Assert.assertTrue("не отображается текст при наведении на пользователя ", hovers.getUser1Text().isDisplayed());
        hovers.getHovers().get(1).hover();
        Assert.assertTrue("не отображается текст при наведении на пользователя ", hovers.getUser2Text().isDisplayed());
        hovers.getHovers().get(2).hover();
        Assert.assertTrue("не отображается текст при наведении на пользователя ", hovers.getUser3Text().isDisplayed());
    }

    @When("^проверить что динамически загружаемый элемент отображается на странице$")
    public void DynamicallyLoadedPageElementsTest() {
        DynamicallyLoadedPageElements dynamicallyLoadedPageElements = new DynamicallyLoadedPageElements();
        Selenide.open(dynamicallyLoadedPageElements.getUrl());
        dynamicallyLoadedPageElements.getStartButton().click();
        Assert.assertTrue("Нужный текст не найден",
                dynamicallyLoadedPageElements.getFinishText().should(Condition.visible, Duration.ofSeconds(15)).isEnabled());
    }
    @When("^ввести команду (.*)$")
    public void KeyPresses(String key) {
        keyGlobal = key;
        Selenide.open(keyPresses.getUrl());
        keyPresses.getInputField().sendKeys(Keys.valueOf(key));
    }
    @When("^проверить что команда введена$")
    public void KeyPressesTestCheck() {
        String text = "You entered: " + keyGlobal;
        Assert.assertEquals("Текст не совпал", text, keyPresses.getResultField().getText());
    }

    @When("^проверить что нажат Checkboxes$")
    public void checkbox() throws InterruptedException {
        Checkbox checkbox = new Checkbox();
        Selenide.open(checkbox.getUrl());
        checkbox.getCheckbox1().click();
        Assert.assertTrue(checkbox.getCheckbox1().isSelected());
        checkbox.getCheckbox2().click();
        Assert.assertFalse(checkbox.getCheckbox2().isSelected());
    }

    @After
    public void after() {
        Selenide.closeWebDriver();
    }
}
