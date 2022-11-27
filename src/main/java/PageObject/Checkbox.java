package PageObject;

import lombok.Data;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@Data
public class Checkbox {

    public By checkbox1 = By.xpath("(//form[@id=\"checkboxes\"]/input)[1]");
    public By checkbox2 = By.xpath("(//form[@id=\"checkboxes\"]/input)[2]");

    @FindBy(xpath = "(//form[@id=\"checkboxes\"]/input)[1]")
    private WebElement checkboxes1;

    @FindBy(xpath = "(//form[@id=\"checkboxes\"]/input)[2]")
    public WebElement checkboxes2;

}
