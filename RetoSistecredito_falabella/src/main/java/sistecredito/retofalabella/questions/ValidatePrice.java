package sistecredito.retofalabella.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

public class ValidatePrice implements Question<Boolean> {
    @Override
    public Boolean answeredBy(Actor actor) {
        int priceProduct = Integer.parseInt(actor.recall("price_product"));
        int priceShipping = Integer.parseInt(actor.recall("price_shipping"));
        int priceFinal = Integer.parseInt(actor.recall("price_final"));
        int sumPrices = priceProduct+priceShipping;

        return sumPrices == priceFinal;
    }
    public static ValidatePrice isCorrect(){
        return new ValidatePrice();
    }
}
