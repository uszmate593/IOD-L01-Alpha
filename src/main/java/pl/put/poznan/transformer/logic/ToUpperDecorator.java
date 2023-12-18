package pl.put.poznan.transformer.logic;
/**
 * Klasa odpowiadająca za zamienię wszytskich liter w tekscie na duże
 *
 * @author Mikołaj Lewandowski
 *
 */
public class ToUpperDecorator extends AbstractDecorator{

    /**
     * Konstruktor klasy, przyjmujący jeden argument.
     *
     * @param text Konstruktor klasy przyjmuje obiekt klasy TextImplementation, który chcemy przekształcić.
     */
    public ToUpperDecorator(Text text){
        super(text);
    }


    /**
     * Metoda zamieniająca oryginalny tekst podany w konstruktorze na wielkie litery.
     *
     * @return Zwraca tekst po zamianie na wielkie litery jako obiekt typu String.
     */
    @Override
    public String decorate(){
        return(super.decorate().toUpperCase());
    }
}
