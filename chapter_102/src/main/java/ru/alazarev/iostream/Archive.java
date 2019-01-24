package ru.alazarev.iostream;

import com.sun.nio.zipfs.ZipDirectoryStream;
import com.sun.nio.zipfs.ZipInfo;

import java.io.*;
import java.util.*;
import java.util.stream.Stream;
import java.util.zip.*;

/**
 * Class Search решение задачи части 002. 4. Архивировать проект.  [#861].
 *
 * @author Aleksey Lazarev
 * @since 21.01.2019
 */
public class Archive {
    private String path;
    private List<String> extensions = new ArrayList<>();

    /**
     * Constructor with 1 parameter.
     *
     * @param path Path for pack.
     */
    public Archive(String path) {
        this.path = path;
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
        Queue<File> queue = (Queue<File>) new Search().files(this.path, this.extensions);
        try {
            ZipOutputStream zos = new ZipOutputStream(new FileOutputStream(this.path + "\\project.zip"));
            while (!queue.isEmpty()) {
                File actualFile = queue.poll();
                String[] catalogs;
                String currentPath = "";
                catalogs = actualFile.getPath().replace(this.path + "\\", "")
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
                            ze.printStackTrace();
                        }
                    }
                    byte[] buffer = new byte[fis.available()];
                    fis.read(buffer);
                    zos.write(buffer);
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        } catch (
                Exception ex) {
            ex.printStackTrace();
        }
    }

}
