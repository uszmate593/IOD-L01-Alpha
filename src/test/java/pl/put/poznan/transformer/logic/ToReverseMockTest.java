package pl.put.poznan.transformer.logic;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

class ToReverseMockTest {

    @Test
    public void testToReverseDecoratorWithToLower() {
        ToLowerDecorator lowerDecoratorMock = Mockito.mock(ToLowerDecorator.class);
        when(lowerDecoratorMock.decorate()).thenReturn("abc defg ");

        ToReverse toReverseWithLower = new ToReverse(lowerDecoratorMock);

        String result = toReverseWithLower.decorate();

        assertEquals("gfed cba", result);
    }

    @Test
    public void testToReverseDecoratorWithCapitalize() {
        ToCapitalizeDecorator capitalizeDecoratorMock = Mockito.mock(ToCapitalizeDecorator.class);
        when(capitalizeDecoratorMock.decorate()).thenReturn("AbCdefG Abc Bca");

        ToReverse toReverseWithCapitalize = new ToReverse(capitalizeDecoratorMock);

        String result = toReverseWithCapitalize.decorate();

        assertEquals("AcB cbA GfedCba", result);
    }

    @Test
    public void testToReverseDecoratorWithUpper() {
        ToUpperDecorator upperDecoratorMock = Mockito.mock(ToUpperDecorator.class);
        when(upperDecoratorMock.decorate()).thenReturn("ABCDEFG HIJ");

        ToReverse toReverseWithUpper = new ToReverse(upperDecoratorMock);

        String result = toReverseWithUpper.decorate();

        assertEquals("JIH GFEdCBA", result);
    }
}