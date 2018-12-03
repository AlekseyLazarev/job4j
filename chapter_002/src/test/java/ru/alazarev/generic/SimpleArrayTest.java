package ru.alazarev.generic;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class SimpleArrayTest {

    @Test
    public void whenCreateContainerShouldReturnSomeType() {
        SimpleArray<Integer> simpleArray = new SimpleArray<Integer>(10);
        simpleArray.add(1);
        simpleArray.add(2);
        simpleArray.add(3);
        simpleArray.add(4);
        assertThat(simpleArray.get(0),is(1));
        simpleArray.set(2,16);
        assertThat(simpleArray.get(2),is(16));
        simpleArray.delete(3);
        assertThat(simpleArray.get(3), is(""));
    }

}