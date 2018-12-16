package ru.alazarev.set;

import org.junit.Before;
import org.junit.Test;

import java.util.Iterator;

import static org.junit.Assert.*;
import static org.hamcrest.Matchers.is;

public class SimpleSetTest {
    private SimpleSet<Integer> simpleSet;
    private int size = 10;

    @Before
    public void setUp() {
        this.simpleSet = new SimpleSet<>(size);
        for (int index = 0; index < size / 2; index++) {
            this.simpleSet.add(index);
        }
    }

    @Test
    public void whenAddEqualValuesThenSaveOnlyOne() {
        for (int index = 0; index < size / 2; index++) {
            this.simpleSet.add(index);
        }
        Iterator<Integer> iterator = this.simpleSet.iterator();
        int[] ext = new int[size];
        int index = 0;
        while (iterator.hasNext()) {
            ext[index] = iterator.next();
            index++;
        }
        int[] result = new int[size];
        for (int indexRes = 0; indexRes < size / 2; indexRes++) {
            result[indexRes] = indexRes;
        }
        assertThat(ext, is(result));
    }

}