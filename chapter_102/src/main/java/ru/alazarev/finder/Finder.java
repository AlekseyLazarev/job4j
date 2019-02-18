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
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Finder {
    Queue<File> queue = new LinkedList<>();

    public void add(File file) {
        if(file.isDirectory()) {
            for (File current: file.listFiles()) {
                add(current);
            }
        } else if (file.isFile()) {
            queue.add(file);
        }
    }

    public List<File> find(String currentPath, String fileName) {
        List<File> result = new ArrayList<>();
        if (new File(currentPath).exists()) {
            add(new File(currentPath));
        }
        while (!this.queue.isEmpty()) {
            File actual = this.queue.poll();
            if (actual.getName().matches(fileName)){
                result.add(actual);
            }
        }
        return result;
    }
}
