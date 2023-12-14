package pl.put.poznan.transformer.logic;

public class ToUpperDecorator extends AbstractDecorator{
    public ToUpperDecorator(Text text){
        super(text);
    }

    @Override
    public String decorate(){
        return(super.decorate().toUpperCase());
    }
}
