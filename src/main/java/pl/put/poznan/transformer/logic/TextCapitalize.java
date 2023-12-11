package pl.put.poznan.transformer.logic;

public class TextCapitalize {
    public static String CapitalizeFirstLetter(String text){
        if (text == null){
            return null;
        }
        StringBuilder result = new StringBuilder();
        String[] slowa = text.split("\\s");
        for (String slowo : slowa){
            if(slowo.isEmpty()) {
                result.append(" ");
            }else{
                char x = slowo.charAt(0);
                String y = TextUpper.convertToUpperCase(String.valueOf(x));
                result.append(y+slowo.substring(1));
                result.append(" ");
            }

        }
        return result.toString().trim();
    }
}
