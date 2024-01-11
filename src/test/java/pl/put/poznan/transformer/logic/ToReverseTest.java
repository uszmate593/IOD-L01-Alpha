package pl.put.poznan.transformer.logic;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ToReverseTest {

    @Test
    public void testReverseEmptyString() {
        Text text = new TextImplementation("");
        ToReverse toReverse = new ToReverse(text);
        String result = toReverse.decorate();
        assertEquals("", result);
    }

    @Test
    public void testReverseLowerCase() {
        Text text = new TextImplementation("abcd");
        ToReverse toReverse = new ToReverse(text);
        String result = toReverse.decorate();
        assertEquals("dcba", result);
    }

    @Test
    public void testReverseUpperCase() {
        Text text = new TextImplementation("ABCD");
        ToReverse toReverse = new ToReverse(text);
        String result = toReverse.decorate();
        assertEquals("DCBA", result);
    }

    @Test
    public void testReverseMixedCase() {
        Text text = new TextImplementation("aBcD");
        ToReverse toReverse = new ToReverse(text);
        String result = toReverse.decorate();
        assertEquals("dCbA", result);
    }

    @Test
    public void testReverseWithSpaces() {
        Text text = new TextImplementation("Hello World");
        ToReverse toReverse = new ToReverse(text);
        String result = toReverse.decorate();
        assertEquals("Dlrow Olleh", result);
    }
}