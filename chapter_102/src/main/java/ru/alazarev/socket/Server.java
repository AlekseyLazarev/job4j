package ru.alazarev.socket;

import java.io.*;
import java.net.*;

/**
 * Class AnswersChecker решение задачи части 002. 2.1. Бот [#7921].
 *
 * @author Aleksey Lazarev
 * @since 29.01.2019
 */
public class Server {
    private int port;

    /**
     * Constructor.
     *
     * @param port Connection port.
     */
    public Server(int port) {
        this.port = port;
    }

    /**
     * Method start server.
     */
    public void start() {
        try {
            Socket socket = new ServerSocket(port).accept();
            System.out.println("Server started.");
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String ask;
            AnswersChecker dp = new AnswersChecker().init();
            do {
                System.out.println("Wait command ...");
                ask = in.readLine();
                System.out.println(ask);
                out.println(dp.sent(ask));
                out.println();
            } while (!("exit".equals(ask)));
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
        Server server = new Server(5000);
        server.start();
    }
}
