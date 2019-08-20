package ru.alazarev.tdd;

import org.junit.Before;
import org.junit.Test;
import ru.alazarev.tdd.exception.ExtraKeysInMapException;
import ru.alazarev.tdd.exception.KeyNotFoundException;
import ru.alazarev.tdd.exception.MapIsEmptyException;

import java.util.HashMap;
import java.util.Map;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

/**
 * Class SimpleGeneratorTest решение задачи части 4 6.1. Исправить код класс SimpleGenerator. [#855]
 *
 * @author Aleksey Lazarev
 * @since 20.08.2019
 */
public class SimpleGeneratorTest {
    private SimpleGenerator sg;
    private Map<String, String> map;

    @Before
    public void setUp() {
        this.sg = new SimpleGenerator();
        this.map = new HashMap<>();
    }

    @Test
    public void whenStringWithMapThenReplace() {
        this.map.put("name", "Petr");
        this.map.put("subject", "you");
        String result = this.sg.generate("I am a ${name}, Who are ${subject}? A? A? A?", this.map);
        assertThat(result, is("I am a " + this.map.get("name") + ", Who are " + this.map.get("subject") + "? A? A? A?"));
    }

    @Test(expected = KeyNotFoundException.class)
    public void whenKeyNotFoundThenException() {
        this.map.put("one", "1");
        this.map.put("two", "2");
        this.map.put("three", "3");
        this.sg.generate("${one}, ${two}, ${three}, ${four}  ", this.map);
    }

    @Test(expected = ExtraKeysInMapException.class)
    public void whenExtraKeyInMapThenException() {
        this.map.put("one", "1");
        this.map.put("two", "2");
        this.map.put("three", "3");
        this.sg.generate("${one}, ${two}", this.map);
    }

    @Test(expected = MapIsEmptyException.class)
    public void whenMapIsEmpty() {
        this.sg.generate("Some string", new HashMap<>());
    }
}