package pl.put.poznan.transformer.logic;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

class NumbersToTextTest {

    @Test
    public void testOneNumber() {
        NumbersToTextDecorator numbersToText = new NumbersToTextDecorator(new TextImplementation("Test numer 1 test numer 2"));
        String result = numbersToText.decorate();
        assertEquals("Test numer jeden test numer dwa", result);
    }

    @Test
    public void testTwoNumbers() {
        NumbersToTextDecorator numbersToText = new NumbersToTextDecorator(new TextImplementation("Test numer 23 test numer 75"));
        String result = numbersToText.decorate();
        assertEquals("Test numer dwadzieścia trzy test numer siedemdziesiąt pięć", result);
    }

    @Test
    public void testThreeNumbers() {
        NumbersToTextDecorator numbersToText = new NumbersToTextDecorator(new TextImplementation("Test numer 123 test numer 456"));
        String result = numbersToText.decorate();
        assertEquals("Test numer sto dwadzieścia trzy test numer czterysta pięćdziesiąt sześć", result);
    }

    @Test
    public void testNumbersToTextAndToCapitalizeDecorator() {

        ToCapitalizeDecorator mock = Mockito.mock(ToCapitalizeDecorator.class);
        when(mock.decorate()).thenReturn("To Jest Test 123");

        NumbersToTextDecorator numbersToText = new NumbersToTextDecorator(mock);
        String result = numbersToText.decorate();

        assertEquals("To Jest Test sto dwadzieścia trzy", result);
    }

    @Test
    public void testNumbersToTextAndToUpperDecorator() {

        ToCapitalizeDecorator mock = Mockito.mock(ToCapitalizeDecorator.class);
        when(mock.decorate()).thenReturn("TO JEST TEST 123");

        NumbersToTextDecorator numbersToText = new NumbersToTextDecorator(mock);
        String result = numbersToText.decorate();

        assertEquals("TO JEST TEST sto dwadzieścia trzy", result);
    }

    @Test
    public void testNumbersToTextAndToLowerDecorator() {

        ToCapitalizeDecorator mock = Mockito.mock(ToCapitalizeDecorator.class);
        when(mock.decorate()).thenReturn("to jest test 123");

        NumbersToTextDecorator numbersToText = new NumbersToTextDecorator(mock);
        String result = numbersToText.decorate();

        assertEquals("to jest test sto dwadzieścia trzy", result);
    }
}