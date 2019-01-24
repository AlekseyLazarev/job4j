package ru.alazarev.socket;

import java.io.*;
import java.net.*;
import java.util.Scanner;

public class Client {
    private int port;
    private String ip;

    public Client(int port, String ip) {
        this.port = port;
        this.ip = ip;
    }

    public void start() throws IOException {
        Socket socket = new Socket(InetAddress.getByName(ip), port);
        PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        Scanner console = new Scanner(System.in);
        do {
            out.println("Hello oracle");
            String str;
            while (!(str = in.readLine()).isEmpty()) {
                System.out.println(str);
            }
        } while (true);
    }

    public static void main(String[] args) throws IOException {
        Client client = new Client(11111,"127.0.0.1");
        client.start();
    }
}
