package pl.put.poznan.transformer.logic;
/**
 * Klasa odpowiadająca za zamienię pierwszej litery w kazdym wyrazie na dużą
 *
 * @author Wojciech Chwaciński
 *
 */
public class ToCapitalizeDecorator extends AbstractDecorator{

    /**
     * Konstruktor klasy, przyjmujący jeden argument.
     *
     * @param text Konstruktor klasy przyjmuje obiekt klasy TextImplementation, który chcemy przekształcić.
     */
    public ToCapitalizeDecorator(Text text){

        super(text);
    }


    /**
     * Metoda zamieniająca każde słowo w oryginalnym tekście na jego formę z wielką literą na początku.
     *
     * @return Zwraca tekst po zamianie każdego słowa na formę z wielką literą na początku jako obiekt typu String.
     */
    @Override
    public String decorate(){
        StringBuilder result = new StringBuilder();
        String[] slowa = super.decorate().split("\\s");
        for (String slowo : slowa){
            if(slowo.isEmpty()) {
                result.append(" ");
            }else{
                char x = slowo.charAt(0);
                String reszta = slowo.substring(1);
                String y = (x + "").toUpperCase();
                result.append(y + reszta);
                result.append(" ");
            }

        }
        return result.toString().trim();

    }
}
