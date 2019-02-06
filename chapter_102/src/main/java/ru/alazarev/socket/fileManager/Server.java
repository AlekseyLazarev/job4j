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


import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.*;

public class Server implements FileManager {
    private final String root;
    private final Socket socket;
    private PrintWriter out;
    private BufferedReader in;
    private String currentCatalog;

    public Server(String root, int port) throws IOException {
        this.root = root;
        socket = new ServerSocket(port).accept();
    }

    public void chk(String inputString) throws IOException {
        String[] splitInput = inputString.split(" ");
        switch (splitInput[0]) {
            case ("child"): {
                getChildren();
                break;
            }
            case ("down"): {
                followChild(splitInput[1]);
                break;
            }
            case ("root"): {
                getRoot();
                break;
            }
            case ("download"): {
                getFile(splitInput[1]);
                break;
            }
            case ("upload"): {
                loadFile(new File(splitInput[1]));
                break;
            }
            default: {
                this.out.println("Unknown command");
                break;
            }
        }
    }

    public void start() {
        getRoot();
        try {
            System.out.println("Server started.");
            out = new PrintWriter(this.socket.getOutputStream(), true);
            in = new BufferedReader(new InputStreamReader(this.socket.getInputStream()));
            String ask;
            do {
                System.out.println("Wait command ...");
                ask = in.readLine();
                chk(ask);
            } while (!("exit".equals(ask)));
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    /**
     * Получить список корневого каталога.
     *
     * @return Список корневого каталога.
     */
    public boolean getChildren() {
        Arrays.asList(new File(this.currentCatalog).listFiles())
                .stream().forEach(f -> out.println(f.getPath()));
        return true;
    }

    /**
     * Перейти в подкаталог.
     */
    public boolean followChild(String path) {
        boolean result = false;
        if (new File(path).exists()) {
            this.currentCatalog = new File(path).getPath();
            this.out.println(currentCatalog);
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
            if (false) {
                this.out.println(currentCatalog);
            }
            result = true;
        }
        return result;
    }

    /**
     * Скачать файл.
     *
     * @return
     */
    public boolean getFile(String fileName) throws IOException {
        boolean result = false;
        File inFile = new File(this.currentCatalog + "\\" + fileName);
        String currentPath = "C:\\Chat\\1\\" + fileName;
        File outFile = new File(currentPath);
        if (inFile.exists()) {
            byte data[] = new byte[(int) inFile.length()];
            FileInputStream in = new FileInputStream(inFile);
            in.read(data);
            FileOutputStream out = new FileOutputStream(outFile);
            out.write(data);
            out.close();
            result = true;
        }
        return result;
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

    public static void main(String[] args) throws IOException {
        Server server = new Server("C:\\chat", 5000);
        server.start();
    }
}
