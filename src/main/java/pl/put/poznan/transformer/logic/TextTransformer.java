package pl.put.poznan.transformer.logic;

import java.util.Objects;

/**
 * This is just an example to show that the logic should be outside the REST service.
 */
public class TextTransformer{

    private final String[] transforms;

    public TextTransformer(String[] transforms){
        this.transforms = transforms;
    }

    public String transform(String text){
        Text trText = new TextImplementation(text);

        for(String tr:transforms){
            if(Objects.equals(tr, "toUpper"))
                trText = new ToUpperDecorator(trText);
            if(Objects.equals(tr, "doubleText"))
                trText = new DoubleTextDecorator(trText);
            if(Objects.equals(tr, "toLower"))
                trText = new ToLowerDecorator(trText);
            if(Objects.equals(tr, "toCapitalize"))
                trText = new ToCapitalizeDecorator(trText);
            if(Objects.equals(tr, "toReversed"))
                trText = new ToReversed(trText);

        }
        return trText.decorate();
    }
}
