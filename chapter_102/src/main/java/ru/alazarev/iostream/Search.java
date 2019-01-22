package ru.alazarev.iostream;

import java.io.File;
import java.util.*;

/**
 * Class Search решение задачи части 002. 3. Сканирование файловой системы. [#106929].
 *
 * @author Aleksey Lazarev
 * @since 21.01.2019
 */
public class Search {
    Queue<File> queue = new LinkedList<>();

    /**
     * Method update queue of files.
     *
     * @param file Files to add in queue.
     */
    private void upDate(File file) {
        if (file.isDirectory()) {
            for (File current : file.listFiles()) {
                upDate(current);
            }
        } else if (file.isFile()) {
            queue.add(file);
        }
    }

    /**
     * Search method.
     *
     * @param parent Root folder.
     * @param exts   Extensions for search.
     * @return
     */
    List<File> files(String parent, List<String> exts) {
        List<File> resultFiles = new LinkedList<>();
        for (File currentFile : Arrays.asList(new File(parent).listFiles())) {
            upDate(currentFile);
            while (!queue.isEmpty()) {
                File actualFile = queue.poll();
                for (String reg : exts) {
                    if (actualFile.getName().toLowerCase().matches(".*" + reg)) {
                        resultFiles.add(actualFile);
                        break;
                    }
                }
            }
        }
        return resultFiles;
    }
}
