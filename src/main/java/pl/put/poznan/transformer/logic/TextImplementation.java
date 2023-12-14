package pl.put.poznan.transformer.logic;

public class TextImplementation implements Text{
    private String text;

    public TextImplementation(String text){
        this.text = text;
    }
    @Override
    public String decorate(){
        return text;
    }
}
