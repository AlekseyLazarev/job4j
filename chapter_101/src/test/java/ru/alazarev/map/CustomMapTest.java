package ru.alazarev.map;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class CustomMapTest {
    private CustomMap customMap;
    private int size = 10;

    @Before
    public void setUp() {
        this.customMap = new CustomMap(this.size);
    }

    @Test
    public void whenInsertThenGet() {
        this.customMap.insert(20000, "string 0");
        this.customMap.insert(16546, "string 1");
        this.customMap.insert(29416548, "string 2");
        Object[] ext = new Object[]{"string 0", "string 1", "string 2"};
        assertThat(this.customMap.get(20000), is(ext[0]));
        assertThat(this.customMap.get(16546), is(ext[1]));
        assertThat(this.customMap.get(29416548), is(ext[2]));
    }
}