package ru.alazarev.finder;

/**
 * Class Start решение задачи части 002. Тестовое задание. [#783].
 *
 * @author Aleksey Lazarev
 * @since 22.02.2019
 */
public class Start {
    /**
     * Start method.
     *
     * @param args Arguments.
     */
    public static void main(String[] args) {
//        Args params = new Args(args);
//        if (params.empty()) {
//            params.printHelp();
//        } else {
//            Finder finder = new Finder(params.getDirectory(), params.getSearchFile(),
//                                       params.typeFind(), params.getResult());
//            finder.start();
//        }
        Finder finder = new Finder("c:\\chat", "cls.bat",
                "f", "c:\\chat\\1\\logaric.txt");
        finder.start();
    }
}
