package pl.put.poznan.transformer.logic;

import java.util.HashMap;
import java.util.Map;

/**
 * Klasa ta odpowiada za przekształcenie obecnych
 * w tekście skrótów do ich pełnej wersji.
 *
 *
 * @author Mateusz Barski
 */
public class AbberrationToFullDecorator extends AbstractDecorator
{


    /**
     * Konstruktor klasy, przyjmujący jeden argument.
     *
     * @param text Konstruktor klasy przyjmuje obiekt klasy TextImplementation, który chcemy przekształcić.
     */
    public AbberrationToFullDecorator(Text text)
    {
        super(text);
    }

    /**
     * Matoda wykonująca przekształcenie podanego w konstruktorze klasy tekstu.
     * Przekształcenie to polega na rozwinięciu skrótów obecnych w tekście, zgodnie z obecnym w programie słowniku skrótów.
     *
     * @return Zwraca obiekt klasy String zawierający przekształcony tekst.
     */
    @Override
    public String decorate()
    {
        String[] words = super.decorate().split( " ");
        Map<String, String> abbreviations = loadAbberrationDictionary();

        for(int i = 0;i < words.length; i++)
            if(abbreviations.containsKey(words[i]))
                words[i] = abbreviations.get(words[i]);

        String result = String.join(" ", words);
        return result;
    }

    /**
     * Metoda definiująca słownik rozwinięć skrótów i zwracająca go.
     *
     * @return Zwraca obiekt klasy HashMap zawierający zdefiniowane skróty wraz z ich rozwinięciami.
     */
    private Map<String, String> loadAbberrationDictionary()
    {
        Map<String, String> dictionary = new HashMap<String, String>();
        dictionary.put("PUT", "Poznan University of Technology");
        dictionary.put("itd.", "i tak dalej");
        dictionary.put("np.", "na przykład");
        dictionary.put("prof.", "profesor");
        dictionary.put("Prof.", "Profesor");
        dictionary.put("dr", "doktor");
        dictionary.put("Dr", "Doktor");
        dictionary.put("mgr", "magister");
        dictionary.put("Mgr", "Magister");
        dictionary.put("itp.", "i tym podobne");
        dictionary.put("wg", "według");
        dictionary.put("Wg", "Według");
        dictionary.put("al.", "aleja");
        dictionary.put("Al.", "Aleja");
        dictionary.put("ul.", "ulica");
        dictionary.put("Ul.", "Ulica");
        dictionary.put("lek.", "lekarz");
        dictionary.put("NIP", "Numer Identyfikacji Podatkowej");
        dictionary.put("PESEL", "Powszechny Elektroniczny System Ewidencji Ludności");
        dictionary.put("RP", "Rzeczpospolita Polska");
        dictionary.put("p.o.", "pełniący obowiązki");

        return dictionary;
    }
}
