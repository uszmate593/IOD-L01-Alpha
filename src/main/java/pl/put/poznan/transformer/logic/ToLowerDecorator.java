package pl.put.poznan.transformer.logic;
/**
 * Klasa odpowiadająca za zamienię wszytskich liter w tekscie na małe
 *
 * @author Wojciech Chwaciński
 *
 */
public class ToLowerDecorator extends AbstractDecorator{
    /**
     * Konstruktor klasy, przyjmujący jeden argument.
     *
     * @param text Konstruktor klasy przyjmuje obiekt klasy TextImplementation, który chcemy przekształcić.
     */
    public ToLowerDecorator(Text text){
        super(text);
    }

    /**
     * Metoda zamieniająca oryginalny tekst podany w konstruktorze na małe litery.
     *
     * @return Zwraca tekst po zamianie na małe litery jako obiekt typu String.
     */
    @Override
    public String decorate(){

        return(super.decorate().toLowerCase());
    }
}
