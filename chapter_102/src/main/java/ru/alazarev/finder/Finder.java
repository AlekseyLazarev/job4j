package ru.alazarev.finder;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Class Finder решение задачи части 002. Тестовое задание. [#783].
 *
 * @author Aleksey Lazarev
 * @since 22.02.2019
 */
class Finder {
    private List<String> found = new ArrayList<>();
    private final String currentPath;
    private final String search;
    private final String typeFind;
    private final String resultFile;
    private Elector elector;

    /**
     * Constructor.
     *
     * @param currentPath Start search folder.
     * @param searchFile  Full file name, mask or regex.
     * @param typeFind    Search type.
     * @param resultFile  Log file path.
     */
    Finder(String currentPath, String searchFile, String typeFind, String resultFile) {
        this.currentPath = currentPath;
        this.search = searchFile;
        this.typeFind = typeFind;
        this.resultFile = resultFile;
    }

    /**
     * Method search files.
     *
     * @param file Start folder for search.
     */
    private void find(File file) {
        if (file.isDirectory()) {
            for (File current : file.listFiles()) {
                find(current);
            }
        } else if (file.isFile()) {
            if (this.elector.sent(file.getName(), this.typeFind)){
                this.found.add(file.getPath());
            }
        }
    }

    /**
     * Start find method.
     */
    void start() {
        this.elector = new Elector(this.search).init();
        File file = new File(this.resultFile);
        find(new File(this.currentPath));
        try (FileWriter fileWriter = new FileWriter(file)) {
            for (String currentFile : this.found) {
                fileWriter.write("File: " + currentFile + System.getProperty("line.separator"));
            }
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }
}
