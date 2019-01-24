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
    private int countLinesAnswers;

    /**
     * Constructor with path parameter.
     *
     * @param path Path to answers and log.
     */
    public Chat(String path) {
        this.pathToAnswers = path + "answers.txt";
        this.logFilePath = path + "log.txt";
        this.countLinesAnswers = setCountLinesAnswers();
    }

    /**
     * Get count lines answers.
     *
     * @return Count lines.
     */
    public int setCountLinesAnswers() {
        int result = 0;
        try (InputStream is = new BufferedInputStream(new FileInputStream(this.pathToAnswers))) {
            byte[] c = new byte[1024];
            int readChars = is.read(c);
            if (readChars == -1) {
                // bail out if nothing to read
                return 0;
            }
            // make it easy for the optimizer to tune this loop
            int count = 0;
            while (readChars == 1024) {
                for (int i = 0; i < 1024; ) {
                    if (c[i++] == '\n') {
                        ++count;
                    }
                }
                readChars = is.read(c);
            }
            // count remaining characters
            while (readChars != -1) {
                for (int i = 0; i < readChars; ++i) {
                    if (c[i] == '\n') {
                        ++count;
                    }
                }
                readChars = is.read(c);
            }
            result = count;
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return result;
    }

    /**
     * Method get random Phrase from file.
     *
     * @return Random phrase.
     */
    public String getRandomPhrase() {
        String resultPhrase = "";
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(this.pathToAnswers))) {
            resultPhrase = (String) bufferedReader.lines().toArray()[(int) (Math.random() * this.countLinesAnswers)];
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return resultPhrase;
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
                        String phrase = getRandomPhrase();
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
