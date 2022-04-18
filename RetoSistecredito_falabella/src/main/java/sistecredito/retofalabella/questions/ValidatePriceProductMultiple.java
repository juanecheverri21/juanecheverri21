package sistecredito.retofalabella.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

public class ValidatePriceProductMultiple implements Question<Boolean> {
    @Override
    public Boolean answeredBy(Actor actor) {
        int cantProduct = actor.recall("cantProducts");
        int priceProduct = Integer.parseInt(actor.recall("price_multiple_products"));
        int priceShipping = Integer.parseInt(actor.recall("price_shipping"));
        int priceFinal = Integer.parseInt(actor.recall("price_final"));
        int sumPrices = (cantProduct*priceProduct)+priceShipping;

        System.out.println("cantidad de productos     "+cantProduct);
        System.out.println("precio producto      "+priceProduct);
        System.out.println("Precio de envio   "+priceShipping);
        System.out.println("Precio final    "+priceFinal);
        System.out.println("Suma de los precios   "+sumPrices);
        return sumPrices == priceFinal;
    }
    public static ValidatePriceProductMultiple isCorrect(){
        return new ValidatePriceProductMultiple();
    }
}
