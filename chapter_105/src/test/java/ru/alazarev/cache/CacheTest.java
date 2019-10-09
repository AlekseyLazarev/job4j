package ru.alazarev.cache;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.HashMap;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

/**
 * Class CacheTest решение задачи части 5.4. Реализации кеша на SoftReference.
 *
 * @author Aleksey Lazarev
 * @since 09.10.2019
 */
public class CacheTest {
    private Cache cache;
    private String path = System.getProperty("user.dir");
    private HashMap<String, File> files = new HashMap<>();


    @Before
    public void setUp() {
        this.cache = new Cache(this.path);
    }

    @After
    public void deleteCreatedFiles() {
        for (File f : this.files.values()) {
            f.delete();
        }
    }

    private void writeToFile(File file, String text) {
        try (Writer w = new FileWriter(file)) {
            w.write(text);
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }

    @Test
    public void whenReadFromCache() {
        System.out.println();
        String fileNames = "Names.txt";
        String fileAddress = "Address.txt";
        File f1 = new File(this.path.concat("\\" + fileNames));
        File f2 = new File(this.path.concat("\\" + fileAddress));
        this.files.put(fileNames, f1);
        this.files.put(fileAddress, f2);
        writeToFile(f1, fileNames + " text");
        writeToFile(f2, fileAddress + " text");
        String firstResult = this.cache.readFromCache(fileNames);
        String secondResult = this.cache.readFromCache(fileAddress);
        assertThat(firstResult, is(fileNames + " text" + System.lineSeparator()));
        assertThat(secondResult, is(fileAddress + " text" + System.lineSeparator()));
    }
}