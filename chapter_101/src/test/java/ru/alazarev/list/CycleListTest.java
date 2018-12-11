package ru.alazarev.list;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.hamcrest.core.Is.is;

/**
 * Class CycleListTest решение задачи части 001. Урок 5.3.4. Задан связанный список. Определить цикличность. [#161].
 *
 * @author Aleksey Lazarev
 * @since 11.12.2018
 */
public class CycleListTest {
    private int size = 10;
    CycleList cycleList = new CycleList();
    CycleList.Node[] nodes = new CycleList.Node[size];

    /**
     * Method before all test.
     */
    @Before
    public void setUp() {
        for (int index = 0; index < this.size; index++) {
            this.nodes[index] = new CycleList.Node(index + 1);
        }
        for (int indexLink = 0; indexLink < this.size - 1; indexLink++) {
            this.nodes[indexLink].next = this.nodes[indexLink + 1];
        }
    }

    /**
     * Method check if last node null.
     */
    @Test
    public void whenLastNodeNullThenReturnFalse() {
        this.nodes[size - 1].next = null;
        assertThat(this.cycleList.hasCycle(this.nodes[0]), is(false));
    }

    /**
     * Method check cycle if last has next to first.
     */
    @Test
    public void whenCycleLastAndFirstThenReturnTrue() {
        this.nodes[size - 1].next = this.nodes[0];
        assertThat(this.cycleList.hasCycle(this.nodes[0]), is(true));
    }

    /**
     * Method check cycle if first and some node equa.
     */
    @Test
    public void whenCycleFirstAndSomeNodeInCentreThenReturnTrue() {
        this.nodes[size - 1].next = null;
        this.nodes[4].next = this.nodes[0];
        assertThat(this.cycleList.hasCycle(this.nodes[0]), is(true));
    }

    /**
     * Method check if node is empty.
     */
    @Test
    public void whenNodeEmptyThenReturnFalse() {
        CycleList.Node node = new CycleList.Node(null);
        assertThat(this.cycleList.hasCycle(node), is(false));
    }
}