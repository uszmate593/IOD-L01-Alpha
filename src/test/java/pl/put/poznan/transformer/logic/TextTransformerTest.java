package pl.put.poznan.transformer.logic;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
class TextTransformerTest {
    TextTransformer transformer;

    @Test
    public void testToUpper(){
        String[] transforms = {"toUpper"};
        transformer = new TextTransformer(transforms);
        assertEquals(transformer.transform("abc"), "ABC");
    }
    @Test
    public void testDoubleText(){
        String[] transforms = {"doubleText"};
        transformer = new TextTransformer(transforms);
        assertEquals(transformer.transform("abc"), "abcabc");
    }

    @Test
    public void testBoth(){
        String[] transforms = {"doubleText", "toUpper"};
        transformer = new TextTransformer(transforms);
        assertEquals(transformer.transform("abc"), "ABCABC");
    }
  
}