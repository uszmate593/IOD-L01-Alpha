package pl.put.poznan.transformer.logic;

import java.util.ArrayList;

/**
 * Klasa {@code ToReverse} jest dekoratorem, który odwraca kolejność znaków
 * w tekście uzyskanym od obiektu {@link Text}, który jest opakowany.
 * Rozszerza klasę {@link AbstractDecorator}.
 *
 * Odwracanie jest wykonywane przy zachowaniu oryginalnej wielkości znaków.
 *
 * @author Kacper Woźniak
 * @version 1.0
 * @since 2023-12-19
 */
public class ToReverse extends AbstractDecorator {

    /**
     * Konstruuje obiekt {@code ToReverse} z określonym obiektem {@link Text} do udekorowania.
     *
     * @param text Obiekt {@link Text}, który ma zostać udekorowany.
     */
    public ToReverse(Text text) {
        super(text);
    }

    /**
     * Dekoruje tekst, odwracając kolejność jego znaków przy zachowaniu oryginalnej wielkości.
     *
     * @return Odwrócony tekst.
     */
    @Override
    public String decorate() {
        String originalText = super.decorate();
        return inverse(originalText);
    }
    /**
     * Odwraca kolejność znaków w podanym tekście, zachowując wielkość liter na odpowiednich miejscach.
     *
     * @param text Tekst do odwrócenia.
     * @return Odwrócony tekst.
     */
    private String inverse(String text) {
        text = text.strip();

        if (text.isEmpty()) {
            return "";
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