package pl.put.poznan.transformer.logic;
import org.mockito.Mockito;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
class CensorWordsDecoratorTestMock {
    @Test
    public void testCensorWithToCapitalizeDecoratorClass() {

        ToCapitalizeDecorator externalClassMock = Mockito.mock(ToCapitalizeDecorator.class);
        when(externalClassMock.decorate()).thenReturn("This Is A Java Mock Test.");

        CensorWordsDecorator censorWordsDecorator = new CensorWordsDecorator(externalClassMock);
        String result = censorWordsDecorator.decorate();

        assertEquals("This Is A **** Mock Test.", result);


    }
    @Test
    public void testCensorWithToUpperDecoratorClass() {

        ToUpperDecorator externalClassMock = Mockito.mock(ToUpperDecorator.class);
        when(externalClassMock.decorate()).thenReturn("THIS IS A JAVA MOCK TEST.");

        CensorWordsDecorator censorWordsDecorator = new CensorWordsDecorator(externalClassMock);
        String result = censorWordsDecorator.decorate();

        assertEquals("THIS IS A **** MOCK TEST.", result);

    }

    @Test
    public void testCensorWithToLowerDecoratorClass() {

        ToUpperDecorator externalClassMock = Mockito.mock(ToUpperDecorator.class);
        when(externalClassMock.decorate()).thenReturn("this is a java mock test.");

        CensorWordsDecorator censorWordsDecorator = new CensorWordsDecorator(externalClassMock);
        String result = censorWordsDecorator.decorate();

        assertEquals("this is a **** mock test.", result);

    }
}