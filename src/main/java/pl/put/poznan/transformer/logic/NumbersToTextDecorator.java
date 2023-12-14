package pl.put.poznan.transformer.logic;

public class NumbersToTextDecorator extends AbstractDecorator{

    private static final String[][] numbers = {
            {"", "jeden", "dwa", "trzy", "cztery", "pięć", "sześć", "siedem", "osiem", "dziewięć"},
            {"", "dziesięć", "dwadzieścia", "trzydzieści", "czterdzieści", "pięćdziesiąt", "sześćdziesiąt", "siedemdziesiąt", "osiemdziesiąt", "dziewięćdziesiąt"},
            {"", "sto", "dwieście", "trzysta", "czterysta", "pięćset", "sześćset", "siedemset", "osiemset", "dziewięćset"}
    };

    public NumbersToTextDecorator(Text text) {
        super(text);
    }

    @Override
    public String decorate(){
        String text = super.decorate();
        String[] words = text.split(" ");
        StringBuilder result = new StringBuilder();

        for (String word : words) {
            result.append(numberToText(word));
        }

        return result.toString();
    }

    private String numberToText(String number){
        StringBuilder result = new StringBuilder();
        String[] digits = number.split("");
        for(int i = digits.length - 1, j = 0; i >= 0; i--, j++){
            int digit = Integer.parseInt(digits[i]);
            result.insert(0, numbers[j][digit] + " ");
        }

        return result.toString();
    }
}
