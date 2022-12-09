package PageObject;

import com.codeborne.selenide.SelenideElement;
import lombok.Data;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

@Data
public class KeyPresses {
    private final String url = "http://the-internet.herokuapp.com/key_presses";
    private final SelenideElement inputField = $(By.cssSelector("#target"));
    private final SelenideElement resultField = $(By.cssSelector("#result"));
}
