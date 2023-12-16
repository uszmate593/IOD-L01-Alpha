package pl.put.poznan.transformer.logic;

import java.util.ArrayList;

public class ToReversed extends AbstractDecorator {

    public ToReversed(Text text) {
        super(text);
    }

    @Override
    public String decorate() {
        String originalText = super.decorate();
        return inverse(originalText);
    }

    private String inverse(String text) {
        text = text.strip();

        if (text.isEmpty()) {
            return "0";
        }

        int length = text.length();
        ArrayList<Boolean> isUpperCaseList = new ArrayList<>();
        ArrayList<Character> charactersList = new ArrayList<>();

        for (int i = 0; i < length; i++) {
            char currentChar = text.charAt(i);
            isUpperCaseList.add(Character.isUpperCase(currentChar));
            charactersList.add(currentChar);
        }

        StringBuilder result = new StringBuilder();
        int index = 1;

        for (int i = 0; i < length; i++) {
            char currentChar = charactersList.get(charactersList.size() - index);

            if (isUpperCaseList.get(i)) {
                result.append(Character.isUpperCase(currentChar) ? currentChar : Character.toUpperCase(currentChar));
            } else {
                result.append(Character.isUpperCase(currentChar) ? Character.toLowerCase(currentChar) : currentChar);
            }

            index++;
        }

        return result.toString();
    }
}