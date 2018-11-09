package ru.alazarev.converter;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Converter test.
 * @author Aleksey Lazarev
 * @version 0.1
 * @since 09.11.2018
 */
public class ConverterTest {
    /**
     * Test ruble to dollar method.
     */
    @Test
    public void when67RubleToDollarThen1() {
        Converter converter = new Converter();
        int result = converter.rubleToDollar(67);
        assertThat(result, is(1));
    }
    /**
     * Test ruble to euro method.
     */
    @Test
    public void when76RubleToEuroThen1() {
        Converter converter = new Converter();
        int result = converter.rubleToEuro(76);
        assertThat(result, is(1));
    }
    /**
     * Test dollar to ruble method.
     */
    @Test
    public void when1DollarToRubleThen67() {
        Converter converter = new Converter();
        int result = converter.dollarToRuble(1);
        assertThat(result, is(67));
    }
    /**
     * Test euro to ruble method.
     */
    @Test
    public void when1EuroToRubleThen76() {
        Converter converter = new Converter();
        int result = converter.euroToRuble(1);
        assertThat(result, is(76));
    }
}
