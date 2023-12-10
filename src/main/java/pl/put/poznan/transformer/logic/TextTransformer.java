package pl.put.poznan.transformer.logic;

import java.util.HashMap;
import java.util.Map;

/**
 * This is just an example to show that the logic should be outside the REST service.
 */
public class TextTransformer {

    //to do zmiany, trzeba dać użytkownikowi możliwość dodawania skrótów
    private  final HashMap<String, String> predefiniowane_skroty;
    public String makeTextShorter(String text) {
        String tmp = text;
        for (Map.Entry<String, String> entry : this.predefiniowane_skroty.entrySet()) {
            tmp = tmp.replaceAll(entry.getKey(), entry.getValue());
        }
        return tmp;
    }

    private final String[] transforms;

    public TextTransformer(String[] transforms){
        this.transforms = transforms;
        this.predefiniowane_skroty = new HashMap<>();
        predefiniowane_skroty.put("na przykład", "np.");
        predefiniowane_skroty.put("i tak dalej", "itd.");
        predefiniowane_skroty.put("i tym podobne", "itp.");
        predefiniowane_skroty.put("wyżej wymienione", "ww.");
        predefiniowane_skroty.put("według", "wg");
    }

    public String transform(String text){
        // of course, normally it would do something based on the transforms
        return makeTextShorter(text);
    }
}
