package pl.put.poznan.transformer.logic;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
class TextTransformerTest {
    TextTransformer transformer;

    @Test
    public void testEmpty(){
        String[] transforms = {};
        transformer = new TextTransformer(transforms);
        assertEquals(transformer.transform("abc"), "abc");
    }

    @Test
    public void testNumbersToText(){
        String[] transforms = {"numbersToText"};
        transformer = new TextTransformer(transforms);
        assertEquals(transformer.transform("123"), "sto dwadzieścia trzy");
        assertEquals(transformer.transform("1234"), "tysiąc dwieście trzydzieści cztery");
        assertEquals(transformer.transform("12"), "dwanaście");
        assertEquals(transformer.transform("1001"), "tysiąc jeden");
        assertEquals(transformer.transform("1017"), "tysiąc siedemnaście");
    }

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
