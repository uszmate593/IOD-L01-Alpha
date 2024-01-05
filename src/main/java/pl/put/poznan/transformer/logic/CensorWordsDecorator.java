package pl.put.poznan.transformer.logic;

/**
 * Klasa CensorWordsDecorator odpowiedzialna jest za zastępowanie określonych słów gwiazdkami.
 *
 * <p>Klasa dziedziczy po klasie AbstractDecorator.</p>
 *
 * @author Wojciech Chwaciński
 */
public class CensorWordsDecorator extends AbstractDecorator {

    private String forbiddenWords;

    /**
     * Konstruktor klasy CensorWordsDecorator.
     *
     * @param text Obiekt klasy TextImplementation, który chcemy przekształcić.
     */
    public CensorWordsDecorator(Text text) {
        super(text);
        this.forbiddenWords = "kurcze,java,ptc,ask,air";
    }

    /**
     * Metoda odpowiedzialna za zamianę określonych słów na gwiazdki w oryginalnym tekście.
     *
     * @return Zwraca tekst po zastąpieniu określonych słów gwiazdkami jako obiekt typu String.
     */
    @Override
    public String decorate() {
        String result = super.decorate();
        String[] forbiddenWordsArray = forbiddenWords.split(",");
        for (String forbiddenWord : forbiddenWordsArray) {

            String stars = "*".repeat(forbiddenWord.length());


            result = result.replaceAll("(?i)\\b" + forbiddenWord + "\\b", stars);
        }

        return result;
    }
}