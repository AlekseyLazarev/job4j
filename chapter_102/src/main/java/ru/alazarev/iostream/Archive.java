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
                    /**
                     * TODO Цикл создания каталогов
                     */
                    File actualFile = queue.poll();
                    String entryPath = actualFile.getPath().substring(pathToPack.length()).replace('\\', '/');
                    try (FileInputStream fis = new FileInputStream(actualFile)) {
                        zos.putNextEntry(new ZipEntry(entryPath));
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
