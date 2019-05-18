package ru.alazarev.calculator;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

/**
 * Class EngineerCalcTest.
 *
 * @author Aleksey Lazarev
 * @since 08.05.2019
 */
public class EngineerCalcTest {
    private Calculator engineerCalc;

    @Before
    public void start() {
        this.engineerCalc = new Calculator().init();
    }


    @Test
    public void whenCosSixtyThen() {
        assertThat(this.engineerCalc.sent("60 cos".split(" ")), is(Math.cos(60)));
    }

    @Test
    public void whenSinSixtyThen() {
        assertThat(this.engineerCalc.sent("60 sin".split(" ")), is(Math.sin(60)));
    }

    @Test
    public void whenTgSixtyThen() {
        assertThat(this.engineerCalc.sent("60 tg".split(" ")), is(Math.tan(60)));
    }
}