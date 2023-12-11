package pl.put.poznan.transformer.logic;

public class TextUpper {
    public static String convertToUpperCase(String text) {
        if (text == null) {
            return null;
        }

        return text.toUpperCase();
    }
}
