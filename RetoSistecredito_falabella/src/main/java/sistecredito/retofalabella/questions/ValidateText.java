package sistecredito.retofalabella.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

public class ValidateText implements Question<Boolean> {
    String message;
    public ValidateText(String message) {
        this.message = message;
    }

    @Override
    public Boolean answeredBy(Actor actor) {

        System.out.println("::::::::::::::::::"+message);
        System.out.println("---------------------"+actor.recall("text_stock"));
        return actor.recall("text_stock").equals(message);
    }
    public static ValidateText isEquals(String message){
        return new ValidateText(message);
    }
}
