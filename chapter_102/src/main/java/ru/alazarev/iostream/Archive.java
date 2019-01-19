package ru.alazarev.iostream;

import java.io.*;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.zip.*;

public class Archive {
    private Queue<File> queue = new LinkedList<>();

    public void pack() {
        String pathToPack = "C:\\projects\\job4j";
        String pathToSaveZip = "C:\\projects\\job4j\\job4j.zip";
        try (ZipOutputStream zos = new ZipOutputStream(new FileOutputStream(pathToSaveZip))) {
            for (File currentFile : Arrays.asList(new File(pathToPack).listFiles())) {
                upDate(currentFile);
                while (!queue.isEmpty()) {
                    File actualFile = queue.poll();
                    String currentPath = "";
                    String[] catalogs = actualFile.getPath().substring(pathToPack.length() + 1).replace('\\', '/').split("/");
                    try (FileInputStream fis = new FileInputStream(actualFile)) {
                        for (int index = 0; index < catalogs.length; index++) {
                            if (index != catalogs.length - 1) {
                                currentPath = currentPath + catalogs[index] + "/";
                            } else {
                                currentPath += catalogs[index];
                            }
                            zos.putNextEntry(new ZipEntry(currentPath));
                        }
                        byte[] buffer = new byte[fis.available()];
                        fis.read(buffer);
                        zos.write(buffer);
                        zos.closeEntry();
                    } catch (Exception ex) {
                        System.out.println(ex.getMessage());
                    }
                }
            }
            zos.close();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    private void upDate(File file) {
        if (file.isDirectory()) {
            for (File current : file.listFiles()) {
                upDate(current);
            }
        } else if (file.isFile()) {
            queue.add(file);
        }
    }
}
