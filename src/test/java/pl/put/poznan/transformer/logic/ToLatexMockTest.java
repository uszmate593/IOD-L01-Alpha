package pl.put.poznan.transformer.logic;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

public class ToLatexMockTest {

    @Test
    public void testToLatexDecoratorWithToLower() {
        ToLowerDecorator lowerDecoratorMock = Mockito.mock(ToLowerDecorator.class);
        when(lowerDecoratorMock.decorate()).thenReturn("abc$ defg ");

        ToLatexDecorator toLatexWithLower = new ToLatexDecorator(lowerDecoratorMock);

        String result = toLatexWithLower.decorate();

        assertEquals("abc\\$ defg ", result);
    }

    @Test
    public void testToLatexDecoratorWithCapitalize() {
        ToCapitalizeDecorator capitalizeDecoratorMock = Mockito.mock(ToCapitalizeDecorator.class);
        when(capitalizeDecoratorMock.decorate()).thenReturn("AbCdefG$ Abc Bca");

        ToLatexDecorator toLatexWithCapitalize = new ToLatexDecorator(capitalizeDecoratorMock);

        String result = toLatexWithCapitalize.decorate();

        assertEquals("AbCdefG\\$ Abc Bca", result);
    }

    @Test
    public void testToLatexDecoratorWithUpper() {
        ToUpperDecorator upperDecoratorMock = Mockito.mock(ToUpperDecorator.class);
        when(upperDecoratorMock.decorate()).thenReturn("ABCDEFG& HIJ");

        ToLatexDecorator toLatexWithUpper = new ToLatexDecorator(upperDecoratorMock);

        String result = toLatexWithUpper.decorate();

        assertEquals("ABCDEFG\\& HIJ", result);
    }
}