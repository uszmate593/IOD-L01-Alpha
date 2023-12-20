package pl.put.poznan.transformer.logic;

import java.util.Objects;


/**
 * Klasa ta odpowiada za przekształcenie liczb
 * z postaci numercznej na tekstową.
 *
 *
 * @author Mikołaj Lewandowski
 */
public class NumbersToTextDecorator extends AbstractDecorator{

    private static final String[] unity = {"", "jeden", "dwa", "trzy", "cztery", "pięć", "sześć",
            "siedem", "osiem", "dziewięć"};
    private static final String[] teens = {"dziesięć", "jedenaście", "dwanaście", "trzynaście", "czternaście",
            "piętnaście", "szesnaście", "siedemnaście", "osiemnaście", "dziewiętnaście"};
    private static final String[] tens = {"", "dziesięć", "dwadzieścia", "trzydzieści", "czterdzieści", "pięćdziesiąt",
            "sześćdziesiąt", "siedemdziesiąt", "osiemdziesiąt", "dziewięćdziesiąt"};
    private static final String[] hundreds = {"", "sto", "dwieście", "trzysta", "czterysta", "pięćset",
            "sześćset", "siedemset", "osiemset", "dziewięćset"};
    private static final String[] thousands = {"", "tysiąc", "dwa tysiące", "trzy tysiące", "cztery tysiące",
            "pięć tysięcy", "sześć tysięcy", "siedem tysięcy", "osiem tysięcy", "dziewięć tysięcy"};

    /**
     * Konstruktor klasy, przyjmujący jeden argument.
     *
     * @param text Konstruktor klasy przyjmuje obiekt klasy TextImplementation, który chcemy przekształcić.
     */
    public NumbersToTextDecorator(Text text) {
        super(text);
    }

    /**
     * Matoda odpowiedzialna za rodzielenie tekstu na wyrazy
     * 
     *
     * @return Zwraca obiekt klasy String zawierający przekształcony tekst.
     */
    @Override
    public String decorate(){
        String text = super.decorate();
        String[] words = text.split(" ");
        StringBuilder result = new StringBuilder();

        for (String word : words) {
            String[] splitWord = word.split(",");
        if (splitWord.length > 1) {
                result.append(numberToText(splitWord[0])).append(" przecinek ").append(numberToText(splitWord[1])).append(" ");
            } else
                result.append(numberToText(word)).append(" ");
        }

        return result.toString().strip();
    }

    /**
     * Matoda odpowiedzialna za rodzielenie tekstu na wyrazy
     * 
     * @param number Funkcja przyjmuje słowo do zamiany
     * @return Zwraca przetworzone słowo
     */

    private String numberToText(String number) {
        String[] digits = number.split("");
        if (digits.length > 4){
            return number;
        }
        for (String digit : digits) {
            if(Character.isLetter(digit.charAt(0)))
                return number;
        }
        String[] result = new String[digits.length];
        int position = digits.length - 1;

        if (digits.length >= 1) {
            result[position] = unity[Integer.parseInt(digits[position])];
            position--;
        }
        if (digits.length >= 2) {
            result[position] = tens[Integer.parseInt(digits[position])];
            if (digits[position].equals("1")) {
                result[position] = teens[Integer.parseInt(digits[position + 1])];
                result[position + 1] = "";
            }
            position--;
        }
        if (digits.length >= 3) {
            result[position] = hundreds[Integer.parseInt(digits[position])];
            position--;
        }
        if (digits.length >= 4) {
            result[position] = thousands[Integer.parseInt(digits[position])];
        }

        StringBuilder resultString = new StringBuilder();
        for (String s : result) {
            if (!Objects.equals(s, "")) {
                resultString.append(s).append(" ");
            }
        }
        return resultString.toString().strip();
    }
}
