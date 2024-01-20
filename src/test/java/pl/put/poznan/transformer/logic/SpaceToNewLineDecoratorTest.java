package pl.put.poznan.transformer.logic;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;

class SpaceToNewLineDecoratorTest {

    private SpaceToNewLineDecorator decorator;

    @Test
    void testDecorate()
    {
        decorator = new SpaceToNewLineDecorator(new TextImplementation("A imię jego 40 i 4."));
        assertEquals("A\nimię\njego\n40\ni\n4.", decorator.decorate());

        decorator = new SpaceToNewLineDecorator(new TextImplementation("Litwo! Ojczyzno moja! ty jesteś jak zdrowie. Ile cię trzeba cenić, ten tylko się dowie, Kto cię stracił. Dziś piękność twą w całej ozdobie Widzę i opisuję, bo tęsknię po tobie."));
        assertEquals("Litwo!\nOjczyzno\nmoja!\nty\njesteś\njak\nzdrowie.\nIle\ncię\ntrzeba\ncenić,\nten\ntylko\nsię\ndowie,\nKto\ncię\nstracił.\nDziś\npiękność\ntwą\nw\ncałej\nozdobie\nWidzę\ni\nopisuję,\nbo\ntęsknię\npo\ntobie.", decorator.decorate());
    }

    @Test
    void testDecorateAfterAbberrationToFullDecorator()
    {
        AbberrationToFullDecorator mock = Mockito.mock(AbberrationToFullDecorator.class);
        Mockito.when(mock.decorate()).thenReturn("I study at Poznan University of Technology in Poland.");

        decorator = new SpaceToNewLineDecorator(mock);
        assertEquals("I\nstudy\nat\nPoznan\nUniversity\nof\nTechnology\nin\nPoland.", decorator.decorate());
    }
}