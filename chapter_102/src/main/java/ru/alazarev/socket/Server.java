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
    private final Socket socket;

    /**
     * Constructor.
     *
     * @param socket Connection socket.
     */
    public Server(Socket socket) {
        this.socket = socket;
    }

    /**
     * Method start server.
     */
    public void start() {
        try {
            System.out.println("Server started.");
            PrintWriter out = new PrintWriter(this.socket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(this.socket.getInputStream()));
            String ask;
            AnswersChecker dp = new AnswersChecker().init();
            do {
                System.out.println("Wait command ...");
                ask = in.readLine();
                System.out.println(ask);
                out.println(dp.sent(ask.toLowerCase()));
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
        try (Socket socket = new ServerSocket(5000).accept()) {
            new Server(socket);
        } catch (Exception ex) {
            ex.getMessage();
            ex.printStackTrace();
        }


    }
}
