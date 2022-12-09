package PageObject;

import com.codeborne.selenide.SelenideElement;
import lombok.Data;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.w3c.dom.html.HTMLInputElement;

import static com.codeborne.selenide.Selenide.$;

@Data
public class FormAuthentication {

    private final String url = "http://the-internet.herokuapp.com/login";

    private final SelenideElement username = $(By.cssSelector("#username"));
    private final SelenideElement password = $(By.cssSelector("#password"));
    private final SelenideElement loginButton = $(By.cssSelector(".radius"));
    private final SelenideElement logoutButton = $(By.cssSelector(".button.secondary.radius"));


    private final SelenideElement wrongLogin = $(By.xpath("//*[contains(text(),'invalid')]"));

}
