package ru.alazarev.list;

import org.junit.Test;
import org.junit.Before;

import java.util.ConcurrentModificationException;
import java.util.Iterator;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class ContainerListTest {
    private final int size = 10;
    private ContainerList<Integer> containerList;
    private Iterator containerIterator;

    @Before
    public void setUp() {
        containerList = new ContainerList<>(size);
        for (int index = 0; index < size; index++) {
            if (index == 4) {
                containerList.add(null);
            } else {
                containerList.add(index);
            }
        }
        containerIterator = containerList.iterator();
    }

    @Test
    public void whenAddThenExtendList() {
        int before = containerList.getListSize();
        containerList.add(10);
        assertThat((before * 2), is(containerList.getListSize()));
    }

    @Test
    public void whenGetElementThenTakeIt() {
        assertThat(containerList.get(5), is(5));
    }

    @Test
    public void whenHasNextThen() {
        for (int index = 0; index < size; index++) {
            assertThat(containerIterator.hasNext(), is(true));
            containerIterator.next();
        }
        assertThat(containerIterator.hasNext(), is(false));
    }

    @Test(expected = ConcurrentModificationException.class)
    public void whenCollectionModifiedThenConcurrentModificationException() {
        containerList.add(19);
        containerIterator.next();
    }
}