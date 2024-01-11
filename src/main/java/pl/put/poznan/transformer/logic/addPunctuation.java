package pl.put.poznan.transformer.logic;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * The {@code addPunctuation} class is a decorator that adds punctuation to the text obtained from the wrapped {@link Text} object.
 * It extends the {@link AbstractDecorator} class.
 * Punctuation includes adding periods before each uppercase letter (except the first letter in the text) and commas before specific keywords.
 *
 * @author Kacper Woźniak
 * @version 1.0
 * @since 08.01.2024
 */
public class addPunctuation extends AbstractDecorator {

    // Set of keywords that trigger the addition of commas
    private static final Set<String> KEYWORDS = Set.of("który", "ale", "że", "bo");

    /**
     * Constructs an {@code AddPunctuation} object with the specified {@link Text} to decorate.
     *
     * @param text The {@link Text} object to be decorated.
     */
    public addPunctuation(Text text) {
        super(text);
    }

    /**
     * Decorates the text by adding punctuation.
     *
     * @return The decorated text.
     */
    @Override
    public String decorate() {
        String originalText = super.decorate();
        return AddPunctuation(originalText);
    }

    /**
     * Adds punctuation to the given text.
     *
     * @param text The text to be decorated.
     * @return The decorated text with added punctuation.
     */
    private String AddPunctuation(String text) {
        StringBuilder decoratedText = new StringBuilder();
        char[] characters = text.toCharArray();

        for (int i = 0; i < characters.length; i++) {
            char character = characters[i];

            if (Character.isUpperCase(character) && i > 0) {
                if (decoratedText.length() > 0 && decoratedText.charAt(decoratedText.length() - 1) == ' ') {
                    decoratedText.deleteCharAt(decoratedText.length() - 1);
                    decoratedText.append(". ");
                } else {
                    decoratedText.append(".");
                }
            } else if (character == ' ' && i > 0) {
                String[] words = decoratedText.toString().split("\\s+");
                String previousWord = words[words.length - 1];


                String cleanedWord = previousWord.replaceAll("[^a-zA-Z]", "");

                if (isKeyword(cleanedWord)) {
                    decoratedText.delete(decoratedText.length() - previousWord.length() - 1, decoratedText.length());
                    decoratedText.append(", ").append(previousWord);
                }
            }

            decoratedText.append(character);
        }

        if (decoratedText.length() > 0 && decoratedText.charAt(decoratedText.length() - 1) != '.') {
            decoratedText.append(".");
        }

        return decoratedText.toString();
    }
    /**
     * Checks if a given word is a keyword.
     *
     * @param word The word to be checked.
     * @return {@code true} if the word is a keyword, {@code false} otherwise.
     */
    private boolean isKeyword(String word) {
        return KEYWORDS.contains(word.toLowerCase());
    }
}