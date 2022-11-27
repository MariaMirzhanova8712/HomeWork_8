package PageObject;

import lombok.Data;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@Data
public class MainPage {

    String mainPageUrl = "http://the-internet.herokuapp.com";

    @FindBy(xpath = "//*[@href='/ checkboxes']")
    public WebElement checkboxes1;


}
