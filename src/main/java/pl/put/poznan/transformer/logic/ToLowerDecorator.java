package pl.put.poznan.transformer.logic;

public class ToLowerDecorator extends AbstractDecorator{
    public ToLowerDecorator(Text text){

        super(text);
    }

    @Override
    public String decorate(){

        return(super.decorate().toLowerCase());
    }
}
