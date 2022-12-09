package PageObject;

import com.codeborne.selenide.SelenideElement;
import lombok.Data;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

@Data
public class DynamicallyLoadedPageElements {
    private final String url = "http://the-internet.herokuapp.com/dynamic_loading/2";
    private final SelenideElement startButton = $(By.cssSelector("#start>button"));
    private final SelenideElement finishText = $(By.cssSelector("#finish>h4"));
}
