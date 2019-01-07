package ru.alazarev.tree;

import org.junit.Before;
import org.junit.Test;

import java.util.Iterator;
import java.util.NoSuchElementException;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

/**
 * @author Petr Arsentev (parsentev@yandex.ru)
 * @version $Id$
 * @since 0.1
 */
public class TreeTest {
    private Tree<String> tree = new Tree<>("Корень");
    private Iterator<String> iterator;

    @Before
    public void setUp() {
        this.tree.add("Корень", "Левый ребенок");
        this.tree.add("Корень", "Центральный ребенок");
        this.tree.add("Корень", "Правый ребенок");
        this.tree.add("Левый ребенок", "Ребёнок Левого ребенка");
        this.tree.add("Правый ребенок", "Ребёнок Правого ребенок");
        this.iterator = this.tree.iterator();
    }

    @Test
    public void whenLeftChildFind() {
        assertThat(
                this.tree.findBy("Левый ребенок").isPresent(),
                is(true)
        );
    }

    @Test
    public void whenFindNotExitThenOptionEmpty() {
        assertThat(
                this.tree.findBy("Ребёнок Центрального ребенка").isPresent(),
                is(false)
        );
    }

    @Test(expected = NoSuchElementException.class)
    public void whenHasNotIteration() {
        this.iterator.next();
        this.iterator.next();
        this.iterator.next();
        this.iterator.next();
        this.iterator.next();
        this.iterator.next();
        this.iterator.next();
    }

    @Test
    public void whenHasNextNotIteration() {
        this.iterator.next();
        this.iterator.next();
        this.iterator.next();
        this.iterator.next();
        this.iterator.next();
        this.iterator.next();
        assertThat(this.iterator.hasNext(), is(false));
    }

    @Test
    public void whenIsBinaryTreeThenFalse() {
        Tree<Integer> tree = new Tree<>(1);
        tree.add(1,2);
        tree.add(1,3);
        tree.add(2,4);
        tree.add(2,5);
        tree.add(3,6);
        tree.add(3,7);
        assertThat(tree.isBinary(), is(true));
    }
}