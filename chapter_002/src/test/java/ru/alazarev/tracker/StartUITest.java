package ru.alazarev.tracker;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Test
 *
 * @author Aleksey Lazarev
 * @since 16.11.2018
 */
public class StartUITest {
    private final Tracker tracker = new Tracker();
    private final PrintStream stdout = System.out;
    private final ByteArrayOutputStream out = new ByteArrayOutputStream();
    private final String exitAnswer = "yes";

    /**
     * Before test method.
     */
    @BeforeClass
    public void before() {
        this.tracker.add(new Item("Name 1", "Desc 1"));
        this.tracker.add(new Item("Name 2", "Desc 2"));
        this.tracker.add(new Item("Name 3", "Desc 3"));
        this.tracker.add(new Item("Name 4", "Desc 4"));
        this.tracker.add(new Item("Name 1", "Desc 1"));
        this.tracker.add(new Item("Name 1", "Desc 1"));
        System.setOut(new PrintStream(this.out));
    }

    /**
     * Return console output.
     */
    @After
    public void backOutput() {
        System.setOut(this.stdout);
    }

    /**
     * Test add new item method.
     */
    @Test
    public void whenUserAddItemThenTrackerHasNewItemWithSameName() {
        Input input = new StubInput(new String[]{"0", "test name", "desc", exitAnswer});   //создаём StubInput с последовательностью действий
        new StartUI(input, this.tracker).init();     //   создаём StartUI и вызываем метод init()
        assertThat(this.tracker.findAll()[0].getName(), is("test name")); // проверяем, что нулевой элемент массива в трекере содержит имя, введённое при эмуляции.
    }

    /**
     * Test edit item method.
     */
    @Test
    public void whenUpdateThenTrackerHasUpdatedValue() {
        this.before();
        //создаём StubInput с последовательностью действий(производим замену заявки)
        Input input = new StubInput(new String[]{"2", this.tracker.findAll()[0].getId(), "test replace", "replaced", exitAnswer});
        // создаём StartUI и вызываем метод init()
        new StartUI(input, this.tracker).init();
        // проверяем, что нулевой элемент массива в трекере содержит имя, введённое при эмуляции.
        assertThat(this.tracker.findAll()[0].getName(), is("test replace"));
    }

    /**
     * Test delete item method.
     */
    @Test
    public void whenDeleteItemThenTrackerHasDeletedItem() {
        this.before();
        Input input = new StubInput(new String[]{"3", this.tracker.findAll()[0].getId(), exitAnswer});
        new StartUI(input, this.tracker).init();
        Item[] beforeArray = Arrays.copyOfRange(this.tracker.findAll(), 0, this.tracker.findAll().length);
        assertThat(this.tracker.findAll(), is(beforeArray));
    }

    /**
     * Test find item by id method.
     */
    @Test
    public void whenFindItemByIdThenTrackerHasReturnItem() {
        this.before();
        Input input = new StubInput(new String[]{"4", this.tracker.findAll()[3].getId(), exitAnswer});
        new StartUI(input, this.tracker).init();
        assertThat(this.tracker.findById(this.tracker.findAll()[3].getId()), is(this.tracker.findAll()[3]));
    }

    /**
     * Add to string builder menu method.
     */
    public void appendMenu(StringBuilder ex) {
        ex.append("0. Add new Item");
        ex.append(System.lineSeparator());
        ex.append("1. Show all items");
        ex.append(System.lineSeparator());
        ex.append("2. Edit item");
        ex.append(System.lineSeparator());
        ex.append("3. Delete item");
        ex.append(System.lineSeparator());
        ex.append("4. Find item by Id");
        ex.append(System.lineSeparator());
        ex.append("5. Find items by name");
        ex.append(System.lineSeparator());
        ex.append("6. Exit Program");
        ex.append(System.lineSeparator());
    }

    /**
     * Test user show all items method.
     */
    @Test
    public void whenUserShowAllItemsThenTrackerHasReturnAllItems() {
        this.before();
        Input input = new StubInput(new String[]{"1", exitAnswer});   //создаём StubInput с последовательностью действий
        StartUI startUI = new StartUI(input, this.tracker);     //   создаём StartUI и вызываем метод init()
        startUI.init();
        StringBuilder ex = new StringBuilder();
        this.appendMenu(ex);
        ex.append("___ START SHOW ALL ITEM ___");
        ex.append(System.lineSeparator());
        for (Item item : this.tracker.findAll()) {
            ex.append(String.format("ID: %15s Name: %10s Desc: %20s %n", item.getId(), item.getName(), item.getDesc()));
        }
        ex.append("___ END SHOW ALL ITEM ___");
        ex.append(System.lineSeparator());
        String res = new String(out.toByteArray());
        assertThat(res, is(ex.toString())); // проверяем, что нулевой элемент массива в трекере содержит имя, введённое при эмуляции.
    }

    /**
     * Test find items by name method.
     */
    @Test
    public void whenFindItemsByNameThenTrackerHasReturnItems() {
        this.before();
        Input input = new StubInput(new String[]{"5", this.tracker.findAll()[0].getName(), exitAnswer});
        new StartUI(input, tracker).init();
        StringBuilder ex = new StringBuilder();
        this.appendMenu(ex);
        ex.append("___ FIND ITEMS BY NAME ___");
        ex.append(System.lineSeparator());
        ex.append(String.format("ID: %15s Name: %10s Desc: %20s %n", this.tracker.findAll()[0].getId(),
                this.tracker.findAll()[0].getName(), this.tracker.findAll()[0].getDesc()));
        ex.append(String.format("ID: %15s Name: %10s Desc: %20s %n", this.tracker.findAll()[4].getId(),
                this.tracker.findAll()[4].getName(), this.tracker.findAll()[4].getDesc()));
        ex.append(String.format("ID: %15s Name: %10s Desc: %20s %n", this.tracker.findAll()[5].getId(),
                this.tracker.findAll()[5].getName(), this.tracker.findAll()[5].getDesc()));
        ex.append("___ FOUNDED ITEMS BY NAME ___");
        ex.append(System.lineSeparator());
        assertThat(new String(out.toByteArray()), is(ex.toString()));
    }
}