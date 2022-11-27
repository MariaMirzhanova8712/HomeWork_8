package PageObject;

import org.openqa.selenium.By;

public class FormAuthentication {

    public By username = By.cssSelector("#username");
    public By password = By.cssSelector("#password");
    public By loginButton = By.cssSelector(".radius");
    public By logoutButton = By.cssSelector(".button.secondary.radius");
    public By wrongLogin = By.xpath("//*[contains(text(),'invalid')]");


}
