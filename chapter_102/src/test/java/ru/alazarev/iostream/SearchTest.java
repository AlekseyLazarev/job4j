package ru.alazarev.iostream;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import static org.apache.commons.io.FileUtils.forceDelete;
import static org.junit.Assert.*;
import static org.hamcrest.Matchers.is;

/**
 * Class SearchTest решение задачи части 002. 3. Сканирование файловой системы. [#106929].
 *
 * @author Aleksey Lazarev
 * @since 21.01.2019
 */
public class SearchTest {
    private int size = 10;
    private static final String PS = File.separator;
    private String path = new File(".").getAbsolutePath();
    private List<String> extensions = new ArrayList<>();
    private List<File> expect;

    @Before
    public void setUp() {
        this.extensions.add(".topka");
        this.extensions.add(".tagil");
        this.extensions.add(".ttfpra");
    }

    @Test
    public void whenAddTenThenReceiveTen() {
        this.expect = new LinkedList<>();
        try {
            for (int index = 0; index < this.size; index++) {
                String currentPath = this.path + PS + index + PS + (this.size - index);
                new File(currentPath).mkdirs();
                File currentFile = new File(currentPath + PS + index
                        + this.extensions.get(index % this.extensions.size()));
                this.expect.add(currentFile);
                currentFile.createNewFile();
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        Search search = new Search();
        List<File> result = search.files(this.path, this.extensions);
        List<String> es = new ArrayList<>();
        List<String> rs = new ArrayList<>();
        this.expect.stream().forEach(file -> es.add(file.getName()));
        result.stream().forEach(file -> rs.add(file.getName()));
        Collections.sort(es);
        Collections.sort(rs);
        assertThat(rs, is(es));
    }

    @After
    public void delete() throws IOException {
        List<String> ls = new ArrayList<>();
        this.expect.stream().forEach(file -> ls.add(file.getAbsolutePath()));
        for (String s : ls) {
            String current = s.replace(this.path + PS, "");
            current = current.substring(0, current.indexOf(File.separatorChar));
            String currentPath = this.path + PS;
            forceDelete(new File(currentPath + current));
        }
    }
}