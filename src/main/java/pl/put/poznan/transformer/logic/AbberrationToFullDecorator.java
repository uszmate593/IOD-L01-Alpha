package pl.put.poznan.transformer.logic;

import java.util.HashMap;
import java.util.Map;

public class AbberrationToFullDecorator extends AbstractDecorator
{



    public AbberrationToFullDecorator(Text text)
    {
        super(text);
    }

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
