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
        String[] words = text.decorate().split( " ");
        Map<String, String> abbreviations = new HashMap<String, String>();
        abbreviations.put("PUT", "Poznan University of Technology");

        for(int i = 0;i < words.length; i++)
            if(abbreviations.containsKey(words[i]))
                words[i] = abbreviations.get(words[i]);

        String result = String.join(" ", words);
        return result;
    }
}
