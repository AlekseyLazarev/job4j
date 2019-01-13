package ru.alazarev.analize;

import org.junit.Before;
import org.junit.Test;

import java.util.LinkedList;
import java.util.List;
import java.util.NoSuchElementException;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class AnalizeTest {
    Analize analize = new Analize();
    List<Analize.User> previous = new LinkedList<>();
    List<Analize.User> current = new LinkedList<>();
    Analize.Info info;

    @Before
    public void setUp() {
        int size = 2;
        for (int index = 0; index < size; index++) {
            previous.add(new Analize.User(index, Integer.toString(index)));
            current.add(new Analize.User(index, Integer.toString(index)));
        }
    }

    @Test
    public void whenRemoveTwoElementsThenInfoDeletedEqualTwo() {
        int size = 2;
        for (int index = 0; index < size; index++) {
            current.remove(0);
        }
        info = analize.diff(previous, current);
        assertThat(info.deleted, is(size));
    }

    @Test
    public void whenAddTwoElementsThenInfoAddedEqualTwo() {
        int size = 20;
        for (int index = 0; index < size; index++) {
            int thisIndex = current.size() + index;
            current.add(new Analize.User(thisIndex, Integer.toString(thisIndex)));
        }
        info = analize.diff(previous, current);
        assertThat(info.added, is(size));
    }

    @Test
    public void whenRenameTwoElementsThenInfoChangedEqualTwo() {
        int size = 2;
        for (int index = 0; index < size; index++) {
            current.set(index, new Analize.User(index, "String" + index));
        }
        info = analize.diff(previous, current);
        assertThat(info.changed, is(size));
    }

    @Test
    public void whenAddAndRenameAndDeleteThenInfo() {
        current.remove(current.size() - 1);
        current.add(new Analize.User(current.size() + 1, "Some string"));
        current.set(current.size() % 2, new Analize.User(current.size() % 2, "STRING"));
        info = analize.diff(previous, current);
        assertThat(info.changed + info.deleted + info.added, is(3));
    }

    @Test
    public void whenEmptyPreviousThen() {
        previous = new LinkedList<>();
        info = analize.diff(previous, current);
        assertThat(info.added, is(current.size()));
    }

    @Test
    public void whenEmptyCurrentThen() {
        current = new LinkedList<>();
        info = analize.diff(previous, current);
        assertThat(info.deleted, is(previous.size()));
    }

    @Test(expected = NoSuchElementException.class)
    public void whenNullPreviousThenException() {
        previous = null;
        info = analize.diff(previous, current);
    }
}