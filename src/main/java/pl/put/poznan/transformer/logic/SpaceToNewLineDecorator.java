package pl.put.poznan.transformer.logic;

/**
 * Klasa ta odpowiada za zamiane spacji  tekscie
 * na znaki nowej lini.
 *
 *
 * @author Mateusz Barski
 */

public class SpaceToNewLineDecorator extends AbstractDecorator
{
    /**
     * Konstruktor klasy, przyjmujący jeden argument.
     *
     * @param text Konstruktor klasy przyjmuje obiekt klasy TextImplementation, który chcemy przekształcić.
     */
    public SpaceToNewLineDecorator(Text text)
    {
        super(text);
    }
    /**
     * Matoda wykonująca przekształcenie podanego w konstruktorze klasy tekstu.
     * Przekształcenie to polega na zamianie spacji na zanki nowej lini.
     *
     * @return Zwraca obiekt klasy String zawierający przekształcony tekst.
     */
    @Override
    public String decorate()
    {
        String[] words = super.decorate().split( " ");
        String result = String.join("\n", words);
        return result;
    }
}
