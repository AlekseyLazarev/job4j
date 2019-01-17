package ru.alazarev.iostream;

import org.junit.Test;

import java.io.*;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

/**
 * Class AbusesTest.
 *
 * @author Aleksey Lazarev
 * @since 17.01.2019
 */
public class AbusesTest {
    @Test
    public void whenTwoAbuseThen() {
        Abuses abuses = new Abuses();
        InputStream is = new ByteArrayInputStream(("Сериализация представляет процесс записи состояния объекта в поток.").getBytes());
        OutputStream os = new ByteArrayOutputStream();
        String[] abusesStrings = new String[]{"сериализация", "в"};
        abuses.dropAbuses(is, os, abusesStrings);
        assertThat(os.toString(), is("представляет процесс записи состояния объекта поток."));
    }

}