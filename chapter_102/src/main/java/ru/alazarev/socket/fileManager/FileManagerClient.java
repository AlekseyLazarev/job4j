package ru.alazarev.socket.filemanager;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;

/**
 * Class FinderManagerClient решение задачи части 002. 2. Сетевой менеджер файлов. [#863].
 *
 * @author Aleksey Lazarev
 * @since 26.02.2019
 */
public class FileManagerClient {
    private int port;
    private String ip;
    private Socket socket;
    private BufferedReader in;
    private PrintWriter out;
    private Scanner console;
    private DataInputStream dataInputStream;
    private DataOutputStream dataOutputStream;
    private Actions actions;

    /**
     * Constructor.
     *
     * @param port Connection port.
     * @param ip   Connection ip.
     */
    public FileManagerClient(int port, String ip) {
        this.port = port;
        this.ip = ip;
    }

    /**
     * Method get DataInputStream.
     *
     * @return DataInputStream.
     */
    public DataInputStream getDataInputStream() {
        return this.dataInputStream;
    }

    /**
     * Method set DataInputStream.
     *
     * @param dataInputStream DataInputStream value.
     */
    public void setDataInputStream(DataInputStream dataInputStream) {
        this.dataInputStream = dataInputStream;
    }

    /**
     * Method get DataOutputStream.
     *
     * @return DataOutputStream.
     */
    public DataOutputStream getDataOutputStream() {
        return this.dataOutputStream;
    }

    /**
     * Method set DataOutputStream.
     *
     * @param dataOutputStream DataOutputStream value.
     */
    public void setDataOutputStream(DataOutputStream dataOutputStream) {
        this.dataOutputStream = dataOutputStream;
    }

    /**
     * Method get Socket.
     *
     * @return Socket.
     */
    public Socket getSocket() {
        return this.socket;
    }

    /**
     * Method get BufferedReader.
     *
     * @return BufferedReader.
     */
    public BufferedReader getIn() {
        return this.in;
    }

    /**
     * Method set BufferedReader.
     *
     * @param in BufferedReader value.
     */
    public void setIn(BufferedReader in) {
        this.in = in;
    }

    /**
     * Method start client.
     */
    public void start() {
        try {
            this.socket = new Socket(InetAddress.getByName(this.ip), this.port);
            System.out.println("Server connected to " + this.ip + ":" + this.port);
            this.out = new PrintWriter(this.socket.getOutputStream(), true);
            this.console = new Scanner(System.in);
            this.actions = new Actions(this).init();
            String clientString;
            do {
                System.out.println("Enter command");
                clientString = this.console.nextLine();
                this.out.println(clientString);
                System.out.println("Server answer: ");
                actions.sent(clientString);
                this.in = new BufferedReader(new InputStreamReader(this.socket.getInputStream()));
                String serverString = this.in.readLine();
                while (!"End translation._!".equals(serverString)) {
                    System.out.println(serverString);
                    serverString = this.in.readLine();
                }
            }
            while (!"exit".equals(clientString));
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    /**
     * Main method.
     *
     * @param args arguments.
     */
    public static void main(String[] args) {
        Settings settings = new Settings();
        ClassLoader classLoader = Settings.class.getClassLoader();
        InputStream is = classLoader.getResourceAsStream("app.properties");
        settings.load(is);
        FileManagerClient client = new FileManagerClient(Integer.valueOf(settings.getValue("port")), settings.getValue("ip"));
        client.start();
    }
}
