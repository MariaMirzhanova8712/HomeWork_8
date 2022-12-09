package PageObject;

import com.codeborne.selenide.SelenideElement;
import lombok.Data;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static com.codeborne.selenide.Selenide.$;

@Data
public class Checkbox {
    private final String url = "http://the-internet.herokuapp.com/checkboxes";
    private final SelenideElement checkbox1 = $(By.xpath("(//form[@id=\"checkboxes\"]/input)[1]"));
    private final SelenideElement checkbox2 = $(By.xpath("(//form[@id=\"checkboxes\"]/input)[2]"));
}
