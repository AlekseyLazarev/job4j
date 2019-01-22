package ru.alazarev.iostream;

import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

import static org.junit.Assert.*;
import static org.hamcrest.Matchers.is;

/**
 * Class ArchiveTest решение задачи части 002. 4. Архивировать проект.  [#861].
 *
 * @author Aleksey Lazarev
 * @since 22.01.2019
 */
public class ArchiveTest {
    private String path = "C:\\projects\\job4j";
    private List<String> extensions = new ArrayList<>();
    private Archive archive;
    private Search search = new Search();

    @Before
    public void setUp() {
        this.extensions.add(".java");
        this.extensions.add(".xml");
        this.archive = new Archive(this.path, this.extensions);
    }

    @Test
    public void whenArchivedThen() {
        this.archive.pack();
        List<String> result = new ArrayList<>();
        List<String> expected = new ArrayList<>();
        this.search.files(this.path, this.extensions).stream().forEach(s -> expected.add(s.getPath().substring(this.path.length() + 1)));
        try (ZipInputStream zipInputStream = new ZipInputStream(new FileInputStream(path + "\\" + "project.zip"))) {
            while (zipInputStream.available() != 0) {
                result.add(this.path + "\\" + new ZipEntry(zipInputStream.getNextEntry()).getName());
            }
        } catch (Exception ex) {
        }
        assertThat(result.retainAll(expected), is(true));
    }
}