package pl.put.poznan.transformer.logic;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AbberrationToFullDecoratorTest {

    private AbberrationToFullDecorator decorator;
    @Test
    void testDecorate()
    {
        decorator = new AbberrationToFullDecorator(new TextImplementation("I study at PUT in Poland."));
        assertEquals("I study at Poznan University of Technology in Poland.", decorator.decorate());

        decorator = new AbberrationToFullDecorator(new TextImplementation("Zjadłem na śniadanie kanapki."));
        assertEquals("Zjadłem na śniadanie kanapki.", decorator.decorate());
    }
}