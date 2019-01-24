package ru.alazarev.socket;

import java.io.*;
import java.net.*;

public class Server {
    private int port;

    public Server(int port) {
        this.port = port;
    }

    public void start() throws IOException {
        Socket socket =  new ServerSocket(port).accept();
        PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        String ask = null;
        do {
            System.out.println("wait command ...");
            ask = in.readLine();
            System.out.println(ask);
            if ("hello".equals(ask)) {
                out.println("Hello, dear friend, I'm a oracle.");
                out.println();
            }
        } while ("exit".equals(ask));
    }

    public static void main(String[] args) throws IOException{
        Server server = new Server(11111);
        server.start();
    }
}
