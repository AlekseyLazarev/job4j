package ru.alazarev.finder;

//        1. Создать программу для поиска файла.
//        2. Программа должна искать данные в заданном каталоге и подкаталогах.
//        3. Имя файла может задаваться, целиком, по маске, по регулярному выражение(не обязательно).
//        4. Программа должна собираться в jar и запускаться через java -jar find.jar -d c:/ -n *.txt -m -o log.txt
//        Ключи
//        -d - директория в которая начинать поиск.
//        -n - имя файл, маска, либо регулярное выражение.
//        -m - искать по макс, либо -f - полное совпадение имени. -r регулярное выражение.
//        -o - результат записать в файл.
//        5. Программа должна записывать результат в файл.
//        6. В программе должна быть валидация ключей и подсказка.

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Finder {
    private List<String> found = new ArrayList<>();
    private final String currentPath;
    private final String search;
    private final String typeFind;
    private final String resultFile;

    public Finder(String currentPath, String searchFile, String typeFind, String resultFile) {
        this.currentPath = currentPath;
        this.search = searchFile;
        this.typeFind = typeFind;
        this.resultFile = resultFile;
    }

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

    public boolean checkMask(String searchFile) {
        return searchFile.contains(this.search);
    }

    public boolean checkFull(String searchFile) {
        return searchFile.equalsIgnoreCase(this.search);
    }

    public boolean checkRegex(String searchFile) {
        Pattern pattern = Pattern.compile(this.search);
        Matcher matcher = pattern.matcher(searchFile);
        return matcher.matches();
    }


    public void start() throws IOException {
        File file = new File(this.resultFile);
        find(new File(this.currentPath));
        try (FileWriter fileWriter = new FileWriter(file)) {
            for (String currentFile : this.found) {
                fileWriter.write("File: " + currentFile + System.getProperty("line.separator"));
            }
        }

    }

}
