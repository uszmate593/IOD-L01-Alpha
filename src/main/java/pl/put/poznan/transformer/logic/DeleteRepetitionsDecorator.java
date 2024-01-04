package pl.put.poznan.transformer.logic;


/**
 * Klasa ta odpowiada za usuwanie z tekstu powtarzających się
 * po sobie wyrazów.
 *
 *
 * @author Mateusz Barski
 */

public class DeleteRepetitionsDecorator extends AbstractDecorator
{
    /**
    * Konstruktor klasy, przyjmujący jeden argument.
    *
    * @param text Konstruktor klasy przyjmuje obiekt klasy TextImplementation, który chcemy przekształcić.
    */
    public DeleteRepetitionsDecorator(Text text)
        {
            super(text);
        }
    /**
    * Matoda wykonująca przekształcenie podanego w konstruktorze klasy tekstu.
    * Przekształcenie to polega na usuwaniu występujących po sobie identycznych wyrazów,tak by pozostał tylko jeden z nich.
    *
    * @return Zwraca obiekt klasy String zawierający przekształcony tekst.
    */
    @Override
    public String decorate()
    {
        String[] words = super.decorate().split( " ");
        String last = words[0];
        String result = words[0];
        for(int i = 1;i < words.length;i++)
            if(!words[i].toLowerCase().equals(last.toLowerCase()))
            {
                if((last.toLowerCase() + ".").equals(words[i].toLowerCase()))
                    result += ".";
                else
                {
                    result += " ";
                    result += words[i];
                }
                last = words[i];
            }
        return result;
    }
}
