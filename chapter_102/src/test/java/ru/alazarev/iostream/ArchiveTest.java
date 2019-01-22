package ru.alazarev.iostream;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class ArchiveTest {
    @Test
    public void name() {
        List<String> exts = new ArrayList<>();
        exts.add(".xml");
        exts.add(".java");
        Archive archive = new Archive("C:\\projects\\job4j", exts);
        archive.pack();
    }

}