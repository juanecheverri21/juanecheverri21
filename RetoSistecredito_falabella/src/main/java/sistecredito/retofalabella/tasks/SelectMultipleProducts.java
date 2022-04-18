package sistecredito.retofalabella.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.waits.WaitUntil;
import sistecredito.retofalabella.userinterfaces.HomePage;
import sistecredito.retofalabella.utils.Wait;

public class SelectMultipleProducts implements Task {
    private int cantProducts;

    public SelectMultipleProducts(int cantProducts) {
        this.cantProducts = cantProducts;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {

        actor.remember("cantProducts",cantProducts);
        actor.attemptsTo(Click.on(HomePage.ADD_PRODUCT));
        actor.remember("price_multiple_products",HomePage.PRICE_PRODUCT.resolveFor(actor).getText().
                replace("$ ","").replace(".","").replace(" (Precio final)",""));
        WaitUntil.the(HomePage.BUTTON_ADD_BAG, WebElementStateMatchers.isClickable());
        for(int i = 0; i < cantProducts; i++) {
            actor.attemptsTo(Click.on(HomePage.BUTTON_ADD_BAG));
            actor.attemptsTo(Click.on(HomePage.BUTTON_CONTINUE_BUYING));
        }
        actor.attemptsTo(Click.on(HomePage.BUTTON_CAR));
        actor.attemptsTo(Click.on(HomePage.BUTTON_GO_SHOPPING));
        Wait.stopExecutions(5000);

        String a;
        a = actor.recall("price_multiple_products");

        System.out.println("Precio unitario"+a);



    }
    public static SelectMultipleProducts multipleProducts(int cantProducts){
        return Tasks.instrumented(SelectMultipleProducts.class,cantProducts);
    }
}
