package pl.put.poznan.transformer.logic;

import java.util.HashMap;
import java.util.Map;

public class FullToAbberrationDecorator extends AbstractDecorator
{

    public FullToAbberrationDecorator(Text text)
    {
        super(text);
    }

    @Override
    public String decorate()
    {
        final HashMap<String, String> predefiniowane_skroty = new HashMap<>();
        predefiniowane_skroty.put("na przykład", "np.");
        predefiniowane_skroty.put("i tak dalej", "itd.");
        predefiniowane_skroty.put("i tym podobne", "itp.");
        predefiniowane_skroty.put("wyżej wymienione", "ww.");
        predefiniowane_skroty.put("według", "wg");

        String tmp = String.valueOf(super.decorate());
        for (Map.Entry<String, String> entry : predefiniowane_skroty.entrySet()) {
            tmp = tmp.replaceAll(entry.getKey(), entry.getValue());
        }
        return tmp;
    }
}
