package ru.alazarev.iostream;

import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import static org.junit.Assert.*;
import static org.hamcrest.Matchers.is;

public class SearchTest {
    private int size = 10;
    private String path = "C:\\TestDir\\";
    private List<String> extensions = new ArrayList<>();

    @Before
    public void setUp() {
        this.extensions.add(".tmp");
        this.extensions.add(".tag");
        this.extensions.add(".ttf");
    }

    @Test
    public void whenAddTenThenReceiveTen() {
        List<File> expect = new LinkedList<>();
        try {
            for (int index = 0; index < this.size; index++) {
                String currentPath = "C:\\TestDir\\" + index + "\\" + (this.size - index);
                new File(currentPath).mkdirs();
                File currentFile = new File(currentPath + "\\" + index +
                        this.extensions.get(index % this.extensions.size()));
                expect.add(currentFile);
                currentFile.createNewFile();
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        Search search = new Search();
        List<File> result = search.files(this.path, this.extensions);
        assertThat(result, is(expect));
    }

}