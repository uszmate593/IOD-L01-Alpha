package pl.put.poznan.transformer.logic;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DeleteRepetitionsDecoratorTest {

    private DeleteRepetitionsDecorator decorator;

    @Test
    void testDecorate()
    {
        decorator = new DeleteRepetitionsDecorator(new TextImplementation("Witam witam nazywam się Stefan."));
        assertEquals("Witam nazywam się Stefan.", decorator.decorate());

        decorator = new DeleteRepetitionsDecorator(new TextImplementation("Zjadłem na na śniadanie śniadanie kanapki."));
        assertEquals("Zjadłem na śniadanie kanapki.", decorator.decorate());

        decorator = new DeleteRepetitionsDecorator(new TextImplementation("Dzisiaj idę na spacer spacer."));
        assertEquals("Dzisiaj idę na spacer.", decorator.decorate());

        decorator = new DeleteRepetitionsDecorator(new TextImplementation("Informatyk w naszej firmię nazywa się Zdzisław. Zdzisław skończył studia."));
        assertEquals("Informatyk w naszej firmię nazywa się Zdzisław. Zdzisław skończył studia.", decorator.decorate());
    }

}