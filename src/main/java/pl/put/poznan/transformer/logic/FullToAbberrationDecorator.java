package pl.put.poznan.transformer.logic;

import java.util.HashMap;
import java.util.Map;

/**
 * Klasa ta odpowiada za zwijanie konkretnych sekwencji wyrazów do skrótów.
 *
 *
 * @author Emil Grzybowski
 */
public class FullToAbberrationDecorator extends AbstractDecorator
{
    /**
     * Konstruktor klasy, przyjmujący jeden argument.
     *
     * @param text obiekt klasy TextImplementation, który chcemy przekształcić.
     */
    public FullToAbberrationDecorator(Text text)
    {
        super(text);
    }

    /**
     * Matoda wykonująca przekształcenie tekstu.
     * Przekształcenie to polega na zwijaniu konkretnych sekwencji wyrazów do skrótów,
     * zgodnie z obecnym w programie słownikiem skrótów.
     *
     * @return Zwraca obiekt klasy String zawierający przekształcony tekst.
     */
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
