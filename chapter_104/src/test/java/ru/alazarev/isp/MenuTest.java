package ru.alazarev.isp;

import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

/**
 * Class MenuTest решение задачи части 004. 4.1 Создать меню. [#4748].
 *
 * @author Aleksey Lazarev
 * @since 26.08.2019
 */
public class MenuTest {
    final static String LN = System.lineSeparator();
    Menu menu;

    @Before
    public void setUp() {
        this.menu = new Menu();
        SingleElement el1 = new SingleElement("1.");
        SingleElement el2 = new SingleElement("1.1.");
        SingleElement el3 = new SingleElement("1.1.1.");
        SingleElement el4 = new SingleElement("1.1.2.");
        SingleElement el5 = new SingleElement("1.2.");
        SingleElement el6 = new SingleElement("2.");
        this.menu.addElement(el1, null);
        this.menu.addElement(el6, null);
        this.menu.addElement(el2, el1);
        this.menu.addElement(el4, el2);
        this.menu.addElement(el3, el2);
        this.menu.addElement(el5, el1);
    }

    @Test
    public void name() {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintStream ps = new PrintStream(baos);
        PrintStream old = System.out;
        System.setOut(ps);
        this.menu.printElements();
        System.out.flush();
        System.setOut(old);
        assertThat(baos.toString(), is("----Задача 1." + LN
                + "--------Задача 1.1." + LN
                + "------------Задача 1.1.2." + LN
                + "------------Задача 1.1.1." + LN
                + "--------Задача 1.2." + LN
                + "----Задача 2." + LN));
    }

    @Test
    public void findTest() {
        assertThat(this.menu.finder("1."), is(this.menu.elements.get(0)));
    }
}