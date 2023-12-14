package pl.put.poznan.transformer.logic;

public class DoubleTextDecorator extends AbstractDecorator{
    public DoubleTextDecorator(Text text){
        super(text);
    }

    @Override
    public String decorate(){
        return(super.decorate() + super.decorate());
    }
}
