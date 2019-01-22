package ru.alazarev.iostream;

//        Создать программу консольный чат. Пользователь вводит слово-фразу,
//        программа берет случайную фразу из текстового файла и выводит в ответ.
//        Программа замолкает если пользователь вводит слово «стоп» при этом он может продолжать
//        отправлять сообщения в чат. Если пользователь вводит слово «продолжить» , программа снова начинает отвечать.
//        При вводе слова «закончить» программа прекращает работу. Запись диалога включая,
//        слова-команды стоп/продолжить/закончить записать в текстовый лог.
//        Так делать не надо. while (true) { - консольный чат. должен явно выходить из цикла. не делайте вечный цикл.

import java.io.FileInputStream;
import java.io.PrintStream;

/**
 * Class Chat решение задачи части 002. 5. Создать программу консольный чат.  [#862].
 *
 * @author Aleksey Lazarev
 * @since 21.01.2019
 */
public class Chat {
    private String pathToAnswers;
    private String userFrase;
    private String logFilePath;

    public Chat(String pathToAnswers) {
        this.pathToAnswers = pathToAnswers;
    }

    public void chating() {
        try (FileInputStream fis = new FileInputStream(this.pathToAnswers);
             PrintStream output = new PrintStream(this.logFilePath)) {
            //some action
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

}
