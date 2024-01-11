package pl.put.poznan.transformer.logic;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;

public class ToLatexDecorator extends AbstractDecorator {

    public ToLatexDecorator(Text text) {
        super(text);
        latexReplacements = new HashMap<>();
        latexReplacements.put("\\$", "\\$");
        latexReplacements.put("\\&", "\\&");

    }

    private static HashMap<String, String> latexReplacements;

    @Override
    public String decorate() {
        String tmp = super.decorate();
        for (Map.Entry<String, String> entry : latexReplacements.entrySet()) {
            tmp = tmp.replaceAll(entry.getKey(), Matcher.quoteReplacement(entry.getValue()));
        }
        return tmp;
    }
}
