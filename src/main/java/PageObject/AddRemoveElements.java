package PageObject;

import org.openqa.selenium.By;

public class AddRemoveElements {
    public String addRemoveElementUrl = "http://the-internet.herokuapp.com/add_remove_elements/";
    public By addElementButton = By.xpath("//*[contains(text(), 'Add Element')]");
    public By deleteButton = By.xpath("//button[@class=\"added-manually\"]");
}
