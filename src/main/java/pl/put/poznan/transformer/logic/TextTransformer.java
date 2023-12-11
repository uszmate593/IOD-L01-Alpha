package pl.put.poznan.transformer.logic;

import java.util.Arrays;
import java.util.stream.Collectors;

public class TextTransformer {

    private final String[] transforms;

    public TextTransformer(String[] transforms) {
        this.transforms = transforms;
    }

    public String transform(String text) {
        String transformedText = text;

        for (String transform : transforms) {
            transformedText = applyTransform(transform, transformedText);
        }

        return transformedText;
    }

    private String applyTransform(String transform, String text) {
        switch (transform) {
            case "upper":
                return TextUpper.convertToUpperCase(text);
            case "lower":
                return TextLower.ConvertToLowerase(text);
            case "capitalize":
                return TextCapitalize.CapitalizeFirstLetter(text);
            default:
                return text;
        }
    }
}