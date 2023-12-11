package pl.put.poznan.transformer.logic;

public class TextLower {
    public static String ConvertToLowerase(String text){
        if (text == null){
            return null;
        }

        return text.toLowerCase();
    }
}
