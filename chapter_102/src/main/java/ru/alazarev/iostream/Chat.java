package ru.alazarev.iostream;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
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
    private List<String> answers = new ArrayList<>();

    /**
     * Constructor with path parameter.
     *
     * @param path Path to answers and log.
     */
    public Chat(String path) {
        this.pathToAnswers = path + "answers.txt";
        this.logFilePath = path + "log.txt";
        setAnswers();
    }

    public void setAnswers() {
        try (Scanner scanner = new Scanner(new FileReader(this.pathToAnswers))) {
           while (scanner.hasNextLine()) {
               this.answers.add(scanner.nextLine());
           }
        } catch (IOException ioe) {
            System.out.println(ioe.getMessage());
        }
    }

    /**
     * Chat method.
     */
    public void chat() {
        System.out.println("Добро пожаловать, что-бы получить ответ просто напишите что-то: ");
        try (Scanner input = new Scanner(System.in);
             PrintStream output = new PrintStream(this.logFilePath)) {
            boolean exitAnswer = false;
            while (!exitAnswer) {
                String enterLine = input.nextLine().toLowerCase();
                output.println(enterLine);
                switch (enterLine) {
                    case "закончить":
                        exitAnswer = true;
                        break;
                    case "стоп":
                        boolean silent = true;
                        while (silent) {
                            enterLine = input.nextLine().toLowerCase();
                            output.println(enterLine);
                            if (enterLine.equals("продолжить")) {
                                silent = false;
                            } else if (enterLine.equals("закончить")) {
                                exitAnswer = true;
                                silent = false;
                            }
                        }
                        break;
                    default:
                        String phrase = this.answers.get((int) (Math.random() * this.answers.size()));
                        System.out.println(phrase);
                        output.println(phrase);
                }
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    public static void main(String[] args) {
        Chat chat = new Chat("C:\\Chat\\");
        chat.chat();
    }
}
