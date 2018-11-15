package ru.alazarev.tracker;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Test
 *
 * @author Aleksey Lazarev
 * @since 15.11.2018
 */
public class TrackerTest {
    /**
     * Test add method.
     */
    @Test
    public void whenAddNewItemThenTrackerHasSameItem() {
        Tracker tracker = new Tracker();
        Item item = new Item("test1", "testDescription", 123L);
        tracker.add(item);
        assertThat(tracker.findAll()[0], is(item));
    }

    /**
     * Test replace method.
     */
    @Test
    public void whenReplaceNameThenReturnNewName() {
        Tracker tracker = new Tracker();
        Item previous = new Item("test1", "testDescription", 123L);
        // Добавляем заявку в трекер. Теперь в объект проинициализирован id.
        tracker.add(previous);
        // Создаем новую заявку.
        Item next = new Item("test2", "testDescription2", 1234L);
        // Проставляем старый id из previous, который был сгенерирован выше.
        next.setId(previous.getId());
        // Обновляем заявку в трекере.
        tracker.replace(previous.getId(), next);
        // Проверяем, что заявка с таким id имеет новые имя test2.
        assertThat(tracker.findById(previous.getId()).getName(), is("test2"));
    }

    /**
     * Test delete method.
     */
    @Test
    public void whenDeleteIdThenReturnRewriteArray() {
        Tracker tracker = new Tracker();
        tracker.add(new Item("Name1", "desc1", 1234L));
        tracker.add(new Item("Name2", "desc2", 1235L));
        tracker.add(new Item("Name3", "desc1", 1234L));
        tracker.add(new Item("Name4", "desc2", 1235L));
        Item[] excepted = {tracker.findAll()[0], tracker.findAll()[2], tracker.findAll()[3]};
        String idToDel = tracker.findAll()[1].getId();
        tracker.delete(idToDel);
        assertThat(tracker.findAll(), is(excepted));
    }

    /**
     * Test findAll method.
     */
    @Test
    public void whenFindAllThenReturnAllItems() {
        Tracker tracker = new Tracker();
        Item itemFirst = new Item("Name2", "desc2", 1235L);
        Item itemSecond = new Item("Name2", "desc2", 1235L);
        Item itemThird = new Item("Name3", "desc1", 1234L);
        tracker.add(itemFirst);
        tracker.add(itemSecond);
        tracker.add(itemThird);
        Item[] excepted = {itemFirst, itemSecond, itemThird};
        assertThat(tracker.findAll(), is(excepted));
    }

    /**
     * Test findByName method.
     */
    @Test
    public void whenFindByNameThenReturn() {
        Tracker tracker = new Tracker();
        tracker.add(new Item("Name1", "desc1", 1234L));
        Item[] excepted = {tracker.findAll()[0]};
        assertThat(tracker.findByName(tracker.findAll()[0].getName()), is(excepted));
    }

    /**
     * Test findById method.
     */
    @Test
    public void whenFindByIdThenReturnFoundItem() {
        Tracker tracker = new Tracker();
        Item itemFirst = new Item("Name1", "desc1", 1234L);
        Item itemSecond = new Item("Name2", "desc2", 1235L);
        tracker.add(itemFirst);
        tracker.add(itemSecond);
        assertThat(tracker.findById(tracker.findAll()[0].getId()), is(itemFirst));

    }
}