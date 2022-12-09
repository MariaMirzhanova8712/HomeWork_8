package PageObject;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import lombok.Data;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

@Data
public class Hovers {
    private final String url = "http://the-internet.herokuapp.com/hovers";
    private final ElementsCollection hovers = $$(By.xpath("//*[@alt='User Avatar']"));
    private final SelenideElement user1Text = $(By.xpath("//*[contains(text(),'user1')]"));
    private final SelenideElement user2Text = $(By.xpath("//*[contains(text(),'user2')]"));
    private final SelenideElement user3Text = $(By.xpath("//*[contains(text(),'user3')]"));
}
