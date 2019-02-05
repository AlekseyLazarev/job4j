package ru.alazarev.iostream;

import java.io.*;
import java.util.Scanner;

/**
 * Class Chat решение задачи части 002. 5. Создать программу консольный чат.  [#862].
 *
 * @author Aleksey Lazarev
 * @since 21.01.2019
 */
public class Chat {
    private String pathToAnswers;
    private String logFilePath;

    /**
     * Constructor with path parameter.
     *
     * @param path Path to answers and log.
     */
    public Chat(String path) {
        this.pathToAnswers = path + "answers.txt";
        this.logFilePath = path + "log.txt";
    }

    /**
     * Chat method.
     */
    public void chat() {
        System.out.println("Добро пожаловать, что-бы получить ответ просто напишите что-то: ");
        try (Scanner input = new Scanner(System.in);
             PrintStream output = new PrintStream(this.logFilePath)) {
            Answers dp = new Answers(output, this.pathToAnswers).init();
            boolean exit = false;
            do {
                String inputString = input.nextLine();
                output.println(inputString);
                exit = dp.sent(inputString);
            } while (!exit);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            ex.printStackTrace();
        }
    }

    /**
     * Main method.
     *
     * @param args Arguments.
     */
    public static void main(String[] args) {
        Chat chat = new Chat("C:\\Chat\\");
        chat.chat();
    }

}
