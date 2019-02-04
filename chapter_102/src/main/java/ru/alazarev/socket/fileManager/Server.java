package ru.alazarev.socket.fileManager;
//        Перед реализацией в коде. Составить каркас приложения на интерфейсах. С описанием.
//        1. Разработать клиент серверное приложение на сокетах.
//        2. Серверная часть должна реализовывать следующее апи
//        - получить список корневого каталога. Корневой каталог задается при запуске сервера.
//        - перейти в подкаталог.
//        - спуститься в родительский каталог
//        - скачать файл
//        - загрузить файл.
//        3. Клиент должен это апи уметь вызывать.
//
//        4. настройки портов и адреса считывать с app.properties

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.*;

public class Server implements FileManager {
    final private String root;
    private String currentCatalog;

    public Server(String root) {
        this.root = root;
    }

    public boolean start() {
        boolean result = false;
        getRoot();
        System.out.println("Server started...");
        return result;
    }

    /**
     * Получить список корневого каталога.
     *
     * @return Список корневого каталога.
     */
    public List<File> getChildren() {
        return Arrays.asList(new File(this.currentCatalog).listFiles());
    }

    /**
     * Перейти в подкаталог.
     */
    public boolean followChild(String path) {
        boolean result = false;
        if (new File(path).exists()) {
            this.currentCatalog = new File(path).getPath();
            result = true;
        }
        return result;
    }

    /**
     * Спуститься в родительский каталог
     */
    public boolean getRoot() {
        boolean result = false;
        if (new File(this.root).exists()) {
            this.currentCatalog = this.root;
            result = true;
        }
        return result;
    }

    /**
     * Скачать файл.
     *
     * @return
     */
    public File getFile(String fileName) {
        String currentFile = this.currentCatalog + "\\" + fileName;
        return new File(currentFile).exists() ? new File(currentFile) : null;
    }

    /**
     * Загрузить файл.
     *
     * @param file
     */
    public boolean loadFile(File file) throws IOException {
        boolean result = false;
        String currentPath = this.currentCatalog + "\\" + file.getName();
        if (!new File(currentPath).exists()) {
            byte data[] = new byte[(int) file.length()];
            FileInputStream in = new FileInputStream(file);
            in.read(data);
            FileOutputStream out = new FileOutputStream(currentPath);
            out.write(data);
            out.close();
            new File(currentPath);
            result = true;
        }
        return result;
    }
}
