package ru.alazarev.finder;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Class Finder решение задачи части 002. Тестовое задание. [#783].
 *
 * @author Aleksey Lazarev
 * @since 22.02.2019
 */
public class Finder {
    private List<String> found = new ArrayList<>();
    private final String currentPath;
    private final String search;
    private final String typeFind;
    private final String resultFile;

    /**
     * Constructor.
     *
     * @param currentPath Start search folder.
     * @param searchFile  Full file name, mask or regex.
     * @param typeFind    Search type.
     * @param resultFile  Log file path.
     */
    public Finder(String currentPath, String searchFile, String typeFind, String resultFile) {
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
    public void find(File file) {
        if (file.isDirectory()) {
            for (File current : file.listFiles()) {
                find(current);
            }
        } else if (file.isFile()) {
            if (selectWay(file.getName())) {
                this.found.add(file.getPath());
            }
        }
    }

    /**
     * Method choice way.
     *
     * @param searchFile File to compare.
     * @return Compare result.
     */
    public boolean selectWay(String searchFile) {
        boolean result = false;
        switch (this.typeFind) {
            case "m":
                result = checkMask(searchFile);
                break;
            case "f":
                result = checkFull(searchFile);
                break;
            case "r":
                result = checkRegex(searchFile);
                break;
            default:
                break;
        }
        return result;
    }

    /**
     * Method check file with mask.
     *
     * @param searchFile File to compare.
     * @return
     */
    public boolean checkMask(String searchFile) {
        return searchFile.contains(this.search);
    }

    /**
     * Method check file with full name.
     *
     * @param searchFile File to compare.
     * @return
     */
    public boolean checkFull(String searchFile) {
        return searchFile.equalsIgnoreCase(this.search);
    }

    /**
     * Method check file with regex.
     *
     * @param searchFile File to compare.
     * @return
     */
    public boolean checkRegex(String searchFile) {
        Pattern pattern = Pattern.compile(this.search);
        Matcher matcher = pattern.matcher(searchFile);
        return matcher.matches();
    }

    /**
     * Start find method.
     */
    public void start() {
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
