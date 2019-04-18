package ru.alazarev.socket.oracle;

import java.io.*;
import java.net.*;
import java.util.Scanner;

/**
 * Class OracleClient решение задачи части 002. 2.1. Бот [#7921].
 *
 * @author Aleksey Lazarev
 * @since 29.01.2019
 */
public class Client {
    private int port;
    private String ip;

    /**
     * Constructor.
     *
     * @param port Connection port.
     * @param ip   Connection ip.
     */
    private Client(int port, String ip) {
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
                String clientString = console.nextLine();
                out.println(clientString);
                System.out.println("Server answer: ");
                String serverString = in.readLine();
                while (!(serverString.isEmpty())) {
                    System.out.println(serverString);
                    serverString = in.readLine();
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
    public static void main(String[] args) {

        Client client = new Client(5000, "127.0.0.1");
        client.start();
    }
}
