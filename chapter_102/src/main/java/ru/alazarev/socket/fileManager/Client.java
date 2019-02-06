package ru.alazarev.socket.fileManager;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    private int port;
    private String ip;

    /**
     * Constructor.
     *
     * @param port Connection port.
     * @param ip   Connection ip.
     */
    public Client(int port, String ip) {
        this.port = port;
        this.ip = ip;
    }

    /**
     * Method start client.
     */
    public void start() {
        try {
            Socket socket = new Socket(InetAddress.getByName(this.ip), this.port);
            System.out.println("Server connected to " + this.ip + ":" + this.port);
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            Scanner console = new Scanner(System.in);
            do {
                System.out.println("Enter command");
                String clientString = console.nextLine();
                out.println(clientString);
                String serverString;
                System.out.println("Server answer: ");
                while (!(serverString = in.readLine()).isEmpty()) {
                    System.out.println(serverString);
                }
            } while (true);
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

        ru.alazarev.socket.oracle.Client client = new ru.alazarev.socket.oracle.Client(5000, "127.0.0.1");
        client.start();
    }
}
