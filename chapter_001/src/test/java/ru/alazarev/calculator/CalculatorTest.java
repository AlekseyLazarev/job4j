package ru.alazarev.calculator;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Test.
 *
 * @author Aleksey Lazarev
 * @version 0.1
 * @since 09.11.2018
 */
public class CalculatorTest {
    private Calculator calc;

    @Before
    public void set() {
        calc = new Calculator().init();
    }

    /**
     * Test add method.
     */
    @Test
    public void whenAddOnePlusOneThenTwo() {
        assertThat(calc.sent("1D + 1D".split(" ")), is(2D));
    }

    /**
     * Test sub method.
     */
    @Test
    public void whenAddTwoSubOneThenOne() {
        assertThat(calc.sent("2D - 1D".split(" ")), is(1D));
    }

    /**
     * Test divide method.
     */
    @Test
    public void whenAddTenDivTwoThenFive() {
        assertThat(calc.sent("10D / 2D".split(" ")), is(5D));
    }

    /**
     * Test multiple method.
     */
    @Test
    public void whenAddTwoMulThreeThenSix() {
        assertThat(calc.sent("2D * 3D".split(" ")), is(6D));
    }
}
