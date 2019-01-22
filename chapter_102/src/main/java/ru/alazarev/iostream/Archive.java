package ru.alazarev.iostream;

import java.io.*;
import java.util.*;
import java.util.zip.*;

/**
 * Class Search решение задачи части 002. 4. Архивировать проект.  [#861].
 *
 * @author Aleksey Lazarev
 * @since 21.01.2019
 */
public class Archive {
    private Queue<File> queue;
    private String path;
    private String archivePath;
    private Search archive = new Search();
    private List<String> extensions = new ArrayList<>();

    /**
     * Constructor with 1 parameter.
     *
     * @param path Path for pack.
     */
    public Archive(String path) {
        this.path = path;
        this.archivePath = path + "\\project.zip";
    }

    /**
     * Constructor with 2 parameters.
     *
     * @param path Path for pack.
     * @param exts Extensions for pack.
     */
    public Archive(String path, List<String> exts) {
        this(path);
        this.extensions = exts;
    }

    /**
     * Packing method.
     */
    public void pack() {
        this.queue = (Queue<File>) this.archive.files(this.path, this.extensions);
        try (ZipOutputStream zos = new ZipOutputStream(new FileOutputStream(this.archivePath))) {
            while (!this.queue.isEmpty()) {
                File actualFile = this.queue.poll();
                String currentPath = "";
                String[] catalogs = actualFile.getPath().substring(this.path.length() + 1)
                        .replace('\\', '/').split("/");
                try (FileInputStream fis = new FileInputStream(actualFile)) {
                    for (int index = 0; index < catalogs.length; index++) {
                        if (index != catalogs.length - 1) {
                            currentPath = currentPath + catalogs[index] + "/";
                        } else {
                            currentPath += catalogs[index];
                        }
                        try {
                            zos.putNextEntry(new ZipEntry(currentPath));
                        } catch (ZipException ze) {
                        }
                    }
                    byte[] buffer = new byte[fis.available()];
                    fis.read(buffer);
                    zos.write(buffer);
                } catch (Exception ex) {
                    System.out.println(ex.getMessage());
                }
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

}
