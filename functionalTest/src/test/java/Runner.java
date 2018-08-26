
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {
                "html:build/cucumber",
                "json:build/cucumber.json",
                "junit:build/cucumber.xml",
                "pretty"
        },
        features = {"src/test/java/feature/"},
        tags = {},
        strict = false,
        glue = {"step"}

)

public class Runner {
}



