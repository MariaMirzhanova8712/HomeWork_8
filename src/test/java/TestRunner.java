
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;


@RunWith(Cucumber.class)
@CucumberOptions(
        tags = "@AddRemoveElements",
        features = "src/test/resources",
        glue = "Steps"
)
public class TestRunner {
}
