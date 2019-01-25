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
     * Method generate tree structure for create.
     *
     * @param files List for generate tree.
     * @return Sorted list.
     */
    public List<String> getTree(List<File> files) {
        String folderSplit = "/";
        HashSet<String> hashSet = new HashSet<>();
        for (File file : files) {
            String[] currentFilePath = replacePath(file.getParent()).split("\\\\");
            String lastPath = null;
            for (int index = 0; index < currentFilePath.length; index++) {
                if (index == 0) {
                    lastPath = currentFilePath[index] + folderSplit;
                } else {
                    lastPath = lastPath + currentFilePath[index] + folderSplit;
                }
                hashSet.add(lastPath);
            }
        }
        List<String> sortedList = new ArrayList(hashSet);
        Collections.sort(sortedList);
        return sortedList;
    }

    /**
     * Method remove start path.
     *
     * @param path Path for remove.
     * @return Removed path.
     */
    public String replacePath(String path) {
        return path.replace(this.path + "\\", "");
    }

    /**
     * Packing method.
     */
    public void pack() throws IOException {
        List<File> fileList = new Search().files(this.path, this.extensions);
        try (ZipOutputStream zos = new ZipOutputStream(new FileOutputStream(this.path + "\\project.zip"))) {
            for (String path : getTree(fileList)) {
                zos.putNextEntry(new ZipEntry(path));
            }
            for (File actualFile : fileList) {
                FileInputStream fis = new FileInputStream(actualFile);
                zos.putNextEntry(new ZipEntry(replacePath(actualFile.getPath()).replace("\\", "/")));
                byte[] buffer = new byte[fis.available()];
                fis.read(buffer);
                zos.write(buffer);
            }
        }
    }
}
