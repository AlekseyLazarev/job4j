package ru.alazarev.tracker;

import org.junit.jupiter.api.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Test
 *
 * @author Aleksey Lazarev
 * @since 16.11.2018
 */
public class StartUITest {
    /**
     * Test add new item method.
     */
    @Test
    public void whenUserAddItemThenTrackerHasNewItemWithSameName() {
        Tracker tracker = new Tracker();     // создаём Tracker
        Input input = new StubInput(new String[]{"0", "test name", "desc", "6"});   //создаём StubInput с последовательностью действий
        new StartUI(input, tracker).init();     //   создаём StartUI и вызываем метод init()

        assertThat(tracker.findAll()[0].getName(), is("test name")); // проверяем, что нулевой элемент массива в трекере содержит имя, введённое при эмуляции.
    }

    /**
     * Test edit item method.
     */
    @Test
    public void whenUpdateThenTrackerHasUpdatedValue() {
        // создаём Tracker
        Tracker tracker = new Tracker();
        //Напрямую добавляем заявку
        Item item = tracker.add(new Item("test name", "desc"));
        //создаём StubInput с последовательностью действий(производим замену заявки)
        Input input = new StubInput(new String[]{"2", item.getId(), "test replace", "заменили заявку", "6"});
        // создаём StartUI и вызываем метод init()
        new StartUI(input, tracker).init();
        // проверяем, что нулевой элемент массива в трекере содержит имя, введённое при эмуляции.
        assertThat(tracker.findById(item.getId()).getName(), is("test replace"));
    }

    /**
     * Test delete item method.
     */
    @Test
    public void whenDeleteItemThenTrackerHasDeletedItem() {
        Tracker tracker = new Tracker();
        Item testItem1 = new Item("Test Name 1", "Test Desc 1");
        Item testItem2 = new Item("Test Name 2", "Test Desc 2");
        tracker.add(testItem1);
        tracker.add(testItem2);
        Input input = new StubInput(new String[]{"3", testItem1.getId(), "6"});
        new StartUI(input, tracker).init();
        assertThat(tracker.findAll(), is(new Item[]{testItem2}));
        System.out.print("");
    }

    /**
     * Test find item by id method.
     */
    @Test
    public void whenFindItemByIdThenTrackerHasReturnItem() {
        Tracker tracker = new Tracker();
        Item testItem1 = new Item("Test Name 1", "Test Desc 1");
        tracker.add(testItem1);
        Input input = new StubInput(new String[]{"4", testItem1.getId(), "6"});
        new StartUI(input, tracker).init();
        assertThat(tracker.findById(testItem1.getId()), is(testItem1));
    }
}