import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features" ,//path of feature file located
        glue = "stepDefinitions", //package containing Step Definition
        plugin = {"pretty","html:target/cucumber-reports.html"}, //Report generation
        monochrome = true //makes output readable
)
public class TestRunner {

}
