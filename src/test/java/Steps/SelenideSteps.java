package Steps;

import PageObject.SelenideAddRemoveElements;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class SelenideSteps {
    @BeforeAll
    public static void setBrowConf() {
        Configuration.browser = "chrome";
        Configuration.startMaximized = true;
    }

    @When("^проверить через selenide что добавились элементы в количестве (.*), которое передали на вход$")
    public void AddRemoveElementsTest(int count) throws InterruptedException {
        SelenideAddRemoveElements selenideAddRemoveElements = new SelenideAddRemoveElements();
        Selenide.open(selenideAddRemoveElements.getUrl());
        for (int i = 0; i < count; i++) {
            selenideAddRemoveElements.getAddElementButton()
                    .shouldBe(Condition.enabled, Condition.visible)
                    .click();
            Thread.sleep(500);
        }
        Assert.assertEquals("Текст не совпал", count, selenideAddRemoveElements.getDeleteButton().size());
        Thread.sleep(1000);
    }
}
