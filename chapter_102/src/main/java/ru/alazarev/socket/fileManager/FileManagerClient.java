package ru.alazarev.socket.fileManager;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileManagerClient {
    private int port;
    private String ip;
    private Socket socket;
    private BufferedReader in;
    private PrintWriter out;
    private Scanner console;
    private DataInputStream dataInputStream;
    private DataOutputStream dataOutputStream;

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
     * Method start client.
     */
    public void start() {
        try {
            this.socket = new Socket(InetAddress.getByName(this.ip), this.port);
            System.out.println("Server connected to " + this.ip + ":" + this.port);
            this.out = new PrintWriter(this.socket.getOutputStream(), true);
            this.console = new Scanner(System.in);
            do {
                System.out.println("Enter command");
                String clientString = this.console.nextLine();
                this.out.println(clientString);
                System.out.println("Server answer: ");
                if (clientString.startsWith("download")) {
                    String[] split = clientString.split(" ");
                    File file = new File(split[2] + "\\" + split[1]);
                    this.dataInputStream = new DataInputStream(this.socket.getInputStream());
                    byte[] download = new byte[Integer.valueOf(dataInputStream.readUTF())];
                    FileOutputStream fos = new FileOutputStream(file);
                    this.dataInputStream.read(download);
                    fos.write(download);
                    fos.close();
                    System.out.println(new BufferedReader(new InputStreamReader(this.socket.getInputStream())).readLine());
                } else {
                    this.in = new BufferedReader(new InputStreamReader(this.socket.getInputStream()));
                    String serverString;
                    while (!"End translation._!".equals(serverString = this.in.readLine())) {
                        System.out.println(serverString);
                    }
                }
            }
            while (true);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    /**
     * Main method.
     *
     * @param args arguments.
     */
    public static void main(String[] args) throws IOException {

        FileManagerClient client = new FileManagerClient(5000, "127.0.0.1");
        client.start();
    }
}
