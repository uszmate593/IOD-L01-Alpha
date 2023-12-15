package pl.put.poznan.transformer.logic;

public abstract class AbstractDecorator implements Text{
    protected Text text;

    public AbstractDecorator(Text text) {
        this.text = text;
    }

    @Override
    public String decorate(){
        return text.decorate();
    }
}
