package ru.alazarev.iostream;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class SearchTest {
    @Test
    public void name(){
        String path = System.getProperty("java.io.tmpdir");
        Search search = new Search();
        List<String> exts = new ArrayList<>();
        exts.add(".tmp");
        exts.add(".tag");
        exts.add(".ttf");
        search.files(path, exts);
    }

}