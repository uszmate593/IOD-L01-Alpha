package pl.put.poznan.transformer.logic;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


class CensorWordsDecoratorTest {
    @Test
    public void testCensorSingleWord() {

        Text text = new TextImplementation("This is a java test.");
        CensorWordsDecorator censorWordsDecorator = new CensorWordsDecorator(text);
        String result = censorWordsDecorator.decorate();

        assertEquals("This is a **** test.", result);
    }

    @Test
    public void testCensorMultipleWords() {

        Text text = new TextImplementation("I love java programming. PTC is great!");
        CensorWordsDecorator censorWordsDecorator = new CensorWordsDecorator(text);
        String result = censorWordsDecorator.decorate();

        assertEquals("I love **** programming. *** is great!", result);
    }

    @Test
    public void testCensorCaseInsensitive() {

        Text text = new TextImplementation("Java is Awesome and PTC rocks!");
        CensorWordsDecorator censorWordsDecorator = new CensorWordsDecorator(text);
        String result = censorWordsDecorator.decorate();

        assertEquals("**** is Awesome and *** rocks!", result);
    }

    @Test
    public void testCensorNoMatch() {

        Text text = new TextImplementation("This is a sample text.");
        CensorWordsDecorator censorWordsDecorator = new CensorWordsDecorator(text);
        String result = censorWordsDecorator.decorate();


        assertEquals("This is a sample text.", result);
    }

    @Test
    public void testCensorEmptyText() {

        Text text = new TextImplementation("");
        CensorWordsDecorator censorWordsDecorator = new CensorWordsDecorator(text);
        String result = censorWordsDecorator.decorate();

        assertEquals("", result);
    }
}