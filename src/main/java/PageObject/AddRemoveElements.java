package PageObject;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import lombok.Data;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

@Data
public class AddRemoveElements {

    private final String url = "http://the-internet.herokuapp.com/add_remove_elements/";
    private final SelenideElement addElementButton = $(By.xpath("//*[contains(text(), 'Add Element')]"));
    private final ElementsCollection deleteButton = $$(By.xpath("//button[@class=\"added-manually\"]"));

}
