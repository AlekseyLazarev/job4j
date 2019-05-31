package ru.alazarev.lsp.foods;

import org.junit.Test;

import java.util.Date;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class MilkTest {
    @Test
    public void whenCheckFreshnessThen() {
        Milk milk = new Milk("Milk", new Date(2019,05,30), new Date(2019,05,20), 10000, 0);
        assertThat(milk.freshness(new Date(2019,05,25)), is(50));
    }

}