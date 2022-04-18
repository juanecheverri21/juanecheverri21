package sistecredito.retofalabella.runners;


import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        features = "src\\test\\resources\\features\\product_shopping_bag.feacture",
        glue = "sistecredito.retofalabella.stepdefinitions",
        snippets = SnippetType.CAMELCASE,
        tags = "@Products"
)
public class ProductShopping {
}
