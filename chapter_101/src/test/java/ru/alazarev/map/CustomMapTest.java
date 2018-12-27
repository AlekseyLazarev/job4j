package ru.alazarev.map;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class CustomMapTest {
    private CustomMap customMap;
    private int size = 6;

    @Before
    public void setUp() {
        this.customMap = new CustomMap(this.size);
    }

    @Test
    public void whenInsertThenGet() {
        this.customMap.insert(19540, "string 0");
        this.customMap.insert(96484, "string 1");
        this.customMap.insert(2354, "string 2");
        this.customMap.insert(617, "string 3");
        this.customMap.insert(4345, "string 4");
        this.customMap.insert(59871, "string 5");
        this.customMap.insert(6349, "string 6");
        Object[] ext = new Object[]{"string 0", "string 1", "string 2"};
        assertThat(this.customMap.get(19540), is(ext[0]));
        assertThat(this.customMap.get(96484), is(ext[1]));
        assertThat(this.customMap.get(2354), is(ext[2]));
    }
}