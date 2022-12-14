package Steps;

import PageObject.AddRemoveElements;
import PageObject.Checkbox;
import PageObject.FormAuthentication;
import cucumber.api.java.en.And;
import cucumber.api.java.en.When;
import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class Steps {
    WebDriver webDriver;
    Checkbox checkbox = new Checkbox();
    FormAuthentication formAuthentication = new FormAuthentication();
    AddRemoveElements addRemoveElements = new AddRemoveElements();

    @When("^проверить что нажат Checkboxes$")
    public void checkbox() throws InterruptedException {
        webDriver = new ChromeDriver();
        webDriver.manage().window().maximize();
        webDriver.get("http://the-internet.herokuapp.com/checkboxes");
        WebElement checkbox1 = webDriver.findElement(checkbox.checkbox1);
        checkbox1.click();
        Assert.assertTrue(checkbox1.isSelected());
        Thread.sleep(500);

        WebElement checkbox2 = webDriver.findElement(checkbox.checkbox2);
        checkbox2.click();
        Assert.assertFalse(checkbox2.isSelected());
        Thread.sleep(1000);
        webDriver.quit();
    }

    @After
    public void after() {
        webDriver.quit();
    }

    @When("^проверить возможность авторизации с правильными логином/паролем$")
    public void FormAuthenticationTest() throws InterruptedException {
        webDriver = new ChromeDriver();
        webDriver.manage().window().maximize();
        webDriver.get("http://the-internet.herokuapp.com/login");
        WebElement usernameInput = webDriver.findElement(formAuthentication.username);
        WebElement passwordInput = webDriver.findElement(formAuthentication.password);
        WebElement buttonLogin = webDriver.findElement(formAuthentication.loginButton);
        usernameInput.sendKeys("tomsmith");
        passwordInput.sendKeys("SuperSecretPassword!");
        buttonLogin.click();
        WebElement buttonLogout = webDriver.findElement(formAuthentication.logoutButton);
        Assert.assertTrue("кнопка Logout не отображается ", buttonLogout.isDisplayed());
        Thread.sleep(1000);
    }

    @When("^проверить возможность авторизации с неправильными логином/паролем$")
    public void FormAuthenticationTestNegative() throws InterruptedException {
        webDriver = new ChromeDriver();
        webDriver.manage().window().maximize();
        webDriver.get("http://the-internet.herokuapp.com/login");
        WebElement usernameInput = webDriver.findElement(formAuthentication.username);
        WebElement passwordInput = webDriver.findElement(formAuthentication.password);
        WebElement buttonLogin = webDriver.findElement(formAuthentication.loginButton);
        usernameInput.sendKeys("wrongName");
        passwordInput.sendKeys("wrongPassword");
        buttonLogin.click();
        WebElement wrongLoginMessage = webDriver.findElement(formAuthentication.wrongLogin);
        Assert.assertTrue("нет сообщения о неправильном логине ", wrongLoginMessage.isDisplayed());
        Thread.sleep(1000);
    }

    @When("^проверить что при наведении курсора на одного из аватаров пользователя отображается текст$")
    public void HoversTest() throws InterruptedException {
        webDriver = new ChromeDriver();
        webDriver.manage().window().maximize();
        webDriver.get("http://the-internet.herokuapp.com/hovers");
        WebElement hovers1 = webDriver.findElement(By.xpath("(//*[@alt=\"User Avatar\"])[1]\n"));
        WebElement hovers2 = webDriver.findElement(By.xpath("(//*[@alt=\"User Avatar\"])[2]\n"));
        WebElement hovers3 = webDriver.findElement(By.xpath("(//*[@alt=\"User Avatar\"])[3]\n"));
        new Actions(webDriver).moveToElement(hovers1).perform();
        WebElement user1Text = webDriver.findElement(By.xpath("//*[contains(text(),'user1')]"));
        Assert.assertTrue("не отображается текст при наведении на пользователя ", user1Text.isDisplayed());
        new Actions(webDriver).moveToElement(hovers2).perform();
        WebElement user2Text = webDriver.findElement(By.xpath("//*[contains(text(),'user2')]"));
        Assert.assertTrue("не отображается текст при наведении на пользователя ", user2Text.isDisplayed());
        new Actions(webDriver).moveToElement(hovers3).perform();
        WebElement user3Text = webDriver.findElement(By.xpath("//*[contains(text(),'user3')]"));
        Assert.assertTrue("не отображается текст при наведении на пользователя ", user3Text.isDisplayed());
        Thread.sleep(1000);
    }

    @When("^проверить что динамически загружаемый элемент отображается на странице$")
    public void DynamicallyLoadedPageElementsTest() {
        webDriver = new ChromeDriver();
        webDriver.manage().window().maximize();
        webDriver.get("http://the-internet.herokuapp.com/dynamic_loading/2");

        WebElement buttonStart = webDriver.findElement(By.cssSelector("#start>button"));
        buttonStart.click();
        WebElement helloText = new WebDriverWait(webDriver, 15)
                .until(ExpectedConditions.elementToBeClickable(By.cssSelector("#finish>h4")));
        Assert.assertTrue("Нужный текст не найден", helloText.isDisplayed());
    }

    @When("^проверить что команда введена$")
    public void KeyPressesTest() throws InterruptedException {
        webDriver = new ChromeDriver();
        webDriver.manage().window().maximize();
        webDriver.get("http://the-internet.herokuapp.com/key_presses");
        String text = "input";

        WebElement inputField = webDriver.findElement(By.cssSelector("#target"));
        inputField.sendKeys(text);
        Thread.sleep(1000);

        Assert.assertEquals("Текст не совпал", text, inputField.getAttribute("value"));
    }

    @When("^проверить что добавились элементы в количестве, которое передали на вход$")
    public void AddRemoveElementsTest() throws InterruptedException {
        webDriver = new ChromeDriver();
        webDriver.manage().window().maximize();
        webDriver.get(addRemoveElements.addRemoveElementUrl);
        int countElement = 6;

        WebElement buttonAddElement = webDriver.findElement(addRemoveElements.addElementButton);
        for (int i = 0; i < countElement; i++) {
            buttonAddElement.click();
            Thread.sleep(500);
        }
        List buttonDelete = webDriver.findElements(addRemoveElements.deleteButton);

        Assert.assertEquals("Текст не совпал", countElement, buttonDelete.size());
        Thread.sleep(1000);
    }
}

