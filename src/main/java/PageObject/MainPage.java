package PageObject;

import com.codeborne.selenide.SelenideElement;
import lombok.Data;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

import static com.codeborne.selenide.Selenide.$;

@Data
public class MainPage {

    private final String mainPageUrl = "http://the-internet.herokuapp.com";

    private final SelenideElement checkboxes1 = $(By.xpath("checkboxes1"));



}
