package ru.alazarev.socket;
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

import javafx.application.Application;

import java.io.File;

public class FileManagerServer {
    final private String root;

    public FileManagerServer(String root) {
        this.root = root;
    }

    public void start() {
        System.out.println("Server started...");

    }

    /**
     * Получить список корневого каталога.
     *
     * @return Список корневого каталога.
     */
    public String[] getChildren() {
        String[] result = new String[10];
        return result;
    }

    /**
     * Перейти в подкаталог.
     */
    public void followChild() {

    }

    /**
     * Спуститься в родительский каталог
     */
    public void getRoot() {

    }

    /**
     * Скачать файл.
     *
     * @return
     */
    public File getFile() {
        File result = null;
        return result;
    }

    /**
     * Загрузить файл.
     *
     * @param file
     */
    public void loadFile(File file) {

    }
}
