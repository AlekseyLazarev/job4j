package ru.alazarev.iostream;

//        Создать программу консольный чат. Пользователь вводит слово-фразу,
//        программа берет случайную фразу из текстового файла и выводит в ответ.
//        Программа замолкает если пользователь вводит слово «стоп» при этом он может продолжать
//        отправлять сообщения в чат. Если пользователь вводит слово «продолжить» ,
//        программа снова начинает отвечать.
//        При вводе слова «закончить» программа прекращает работу. Запись диалога включая,
//        слова-команды стоп/продолжить/закончить записать в текстовый лог.
//        Так делать не надо. while (true) { - консольный чат. должен явно выходить
//        из цикла. не делайте вечный цикл.

import java.io.*;
import java.nio.file.Path;
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
    private int countLinesAnswears;


    public Chat(String path) {
        this.pathToAnswers = path + "answers.txt";
        this.logFilePath = path + "log.txt";
        this.countLinesAnswears = setCountLinesAnswers();
    }

    /**
     * Получение количества строк в ответах.
     *
     * @return Количество строк в ответах.
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
                System.out.println(readChars);
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

    public String getRandomPhrase() {
        String ss = "";
        int lineNumber = (int) (Math.random() * this.countLinesAnswears);
        try {
            for (int index = 0; index < lineNumber - 1; index++) {
                Scanner answer = new Scanner(new FileInputStream(this.pathToAnswers));
                ss = answer.next();
            }
        } catch (FileNotFoundException fnfe) {
            System.out.println(fnfe.getMessage());
        }

        return ss;
    }

    //    public void checkInput(String input) {
//
//    }
    public void chating() {
        try (Scanner input = new Scanner(System.in);
             PrintStream output = new PrintStream(this.logFilePath)) {
            boolean exitAnswer = false;
            while (!exitAnswer) {
                String enterLine = input.nextLine();
                output.println(enterLine);
                switch (enterLine) {
                    case "закончить":
                        exitAnswer = true;
                        break;
                    case "стоп":
                        boolean silent = true;
                        while (silent) {
                            enterLine = input.nextLine();
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
        Chat chat = new Chat("C:\\chat\\");
        chat.chating();
    }
}
