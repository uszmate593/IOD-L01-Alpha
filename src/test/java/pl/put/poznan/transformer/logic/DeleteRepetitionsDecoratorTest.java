package pl.put.poznan.transformer.logic;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;

class DeleteRepetitionsDecoratorTest {

    private DeleteRepetitionsDecorator decorator;

    @Test
    void testDecorateSimple()
    {
        decorator = new DeleteRepetitionsDecorator(new TextImplementation("Witam witam nazywam się Stefan."));
        assertEquals("Witam nazywam się Stefan.", decorator.decorate());

        decorator = new DeleteRepetitionsDecorator(new TextImplementation("Zjadłem na na śniadanie śniadanie kanapki."));
        assertEquals("Zjadłem na śniadanie kanapki.", decorator.decorate());
    }

    @Test
    void testDecorateEndOfSentence()
    {
        decorator = new DeleteRepetitionsDecorator(new TextImplementation("Dzisiaj idę na spacer spacer."));
        assertEquals("Dzisiaj idę na spacer.", decorator.decorate());

        decorator = new DeleteRepetitionsDecorator(new TextImplementation("Informatyk w naszej firmię nazywa się Zdzisław. Zdzisław skończył studia."));
        assertEquals("Informatyk w naszej firmię nazywa się Zdzisław. Zdzisław skończył studia.", decorator.decorate());
    }

    @Test
    void testDecorateNoChanges()
    {
        decorator = new DeleteRepetitionsDecorator(new TextImplementation("Kanapka z szynką."));
        assertEquals("Kanapka z szynką.", decorator.decorate());

        decorator = new DeleteRepetitionsDecorator(new TextImplementation("Pan Tadeusz to książka."));
        assertEquals("Pan Tadeusz to książka.", decorator.decorate());
    }

    @Test
    void testDecorateAfterToUpperDecorator()
    {
        ToUpperDecorator mock = Mockito.mock(ToUpperDecorator.class);
        Mockito.when(mock.decorate()).thenReturn("IDĘ NA SPACER SPACER.");

        decorator = new DeleteRepetitionsDecorator(mock);
        assertEquals("IDĘ NA SPACER.", decorator.decorate());
    }

    @Test
    void testDecorateAfterAbberrationToFullDecorator()
    {
        AbberrationToFullDecorator mock = Mockito.mock(AbberrationToFullDecorator.class);
        Mockito.when(mock.decorate()).thenReturn("I study at Poznan University of Technology technology in Poland.");

        decorator = new DeleteRepetitionsDecorator(mock);
        assertEquals("I study at Poznan University of Technology in Poland.", decorator.decorate());
    }
}