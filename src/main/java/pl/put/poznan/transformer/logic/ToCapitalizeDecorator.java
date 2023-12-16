package pl.put.poznan.transformer.logic;

public class ToCapitalizeDecorator extends AbstractDecorator{
    public ToCapitalizeDecorator(Text text){

        super(text);
    }

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
