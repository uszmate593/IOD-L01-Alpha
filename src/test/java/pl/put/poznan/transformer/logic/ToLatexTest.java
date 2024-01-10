package pl.put.poznan.transformer.logic;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ToLatexTest {
    @Test
    public void testDollar() {
        Text tmp = new TextImplementation("I have so much $");
        ToLatexDecorator latex = new ToLatexDecorator(tmp);
        String res = latex.decorate();
        assertEquals("I have so much \\$", res);
    }

    @Test
    public void testAmpersand() {
        Text tmp = new TextImplementation("I like cats & rabbits");
        ToLatexDecorator latex = new ToLatexDecorator(tmp);
        String res = latex.decorate();
        assertEquals("I like cats \\& rabbits", res);
    }

    @Test
    public void testAmpersandandDollar() {
        Text tmp = new TextImplementation("I have so much $ I bought many cats & rabbits");
        ToLatexDecorator latex = new ToLatexDecorator(tmp);
        String res = latex.decorate();
        assertEquals("I have so much \\$ I bought many cats \\& rabbits", res);
    }

    @Test
    public void testEmpty() {
        Text tmp = new TextImplementation("");
        ToLatexDecorator latex = new ToLatexDecorator(tmp);
        String res = latex.decorate();
        assertEquals("", res);
    }

    @Test
    public void testRepeating() {
        Text tmp = new TextImplementation("$&$&$$&&&$&&$&&");
        ToLatexDecorator latex = new ToLatexDecorator(tmp);
        String res = latex.decorate();
        assertEquals("\\$\\&\\$\\&\\$\\$\\&\\&\\&\\$\\&\\&\\$\\&\\&", res);
    }
}
