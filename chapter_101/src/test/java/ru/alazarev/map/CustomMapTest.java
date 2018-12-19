package ru.alazarev.map;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class CustomMapTest {
    private CustomMap customMap;
    private int size = 1;
    @Before
    public void setUp() {
        this.customMap = new CustomMap(this.size);
    }
    @Test
    public void whenInsertThenGet() {
        this.customMap.insert(0, "string 0");
        this.customMap.insert(1, "string 1");
        this.customMap.insert(2, "string 2");
        Object[] ext = new Object[]{"string 0", "string 1", "string 2"};
        assertThat(this.customMap.get(0), is(ext[0]));
        assertThat(this.customMap.get(1), is(ext[1]));
        assertThat(this.customMap.get(2), is(ext[2]));
    }
}