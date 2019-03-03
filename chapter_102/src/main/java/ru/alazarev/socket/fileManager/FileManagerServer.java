package ru.alazarev.socket.filemanager;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Class FileManagerServer решение задачи части 002. 2. Сетевой менеджер файлов. [#863].
 *
 * @author Aleksey Lazarev
 * @since 26.02.2019
 */
public class FileManagerServer {
    private final String root;
    private final Socket socket;
    private PrintWriter out;
    private BufferedReader in;
    private String currentCatalog;
    private Actions actions;

    /**
     * Constructor.
     *
     * @param root Root path.
     * @param port Server port.
     * @throws IOException
     */
    public FileManagerServer(String root, int port) throws IOException {
        this.root = root;
        this.currentCatalog = root;
        this.socket = new ServerSocket(port).accept();
    }

    /**
     * Method get root path.
     *
     * @return Root path.
     */
    public String getRoot() {
        return this.root;
    }

    /**
     * Method return current catalog path.
     *
     * @return Current catalog path.
     */
    public String getCurrentCatalog() {
        return this.currentCatalog;
    }

    /**
     * Method set current catalog.
     *
     * @param currentCatalog Current catalog.
     */
    public void setCurrentCatalog(String currentCatalog) {
        this.currentCatalog = currentCatalog;
    }

    /**
     * Method return socket.
     *
     * @return server socket.
     */
    public Socket getSocket() {
        return this.socket;
    }

    /**
     * Start server method.
     */
    public void start() {
        try {
            System.out.println("Server started.");
            this.out = new PrintWriter(this.socket.getOutputStream(), true);
            this.in = new BufferedReader(new InputStreamReader(this.socket.getInputStream()));
            String ask;
            this.actions = new Actions(this).init();
            do {
                System.out.println("Wait command ...");
                ask = this.in.readLine();
                for (String s : this.actions.sent(ask)) {
                    this.out.println(s);
                }
                this.out.println("End translation._!");
            } while (!("exit".equals(ask)));
        } catch (Exception ex) {
            ex.printStackTrace();

        }
    }

    /**
     * Main method.
     *
     * @param args Arguments.
     */
    public static void main(String[] args) {
        Settings settings = new Settings();
        ClassLoader classLoader = Settings.class.getClassLoader();
        try {
            InputStream is = classLoader.getResourceAsStream("app.properties");
            settings.load(is);
            FileManagerServer server = new FileManagerServer(settings.getValue("home.path"),
                    Integer.valueOf(settings.getValue("port")));
            server.start();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }

    }
}
