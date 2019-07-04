package ru.alazarev.isp;

/**
 * Class Menu решение задачи части 004. 4.1 Создать меню. [#4748].
 *
 * @author Aleksey Lazarev
 * @since 29.06.2019
 */
public class Menu {
    public static void main(String[] args) {
        SingleElement el1 = new SingleElement("Задача 1", 0);
        SingleElement el2 = new SingleElement("Задача 1.1.", 1);
        SingleElement el3 = new SingleElement("Задача 1.1.1.", 2);
        SingleElement el4 = new SingleElement("Задача 1.1.2.", 2);
        SingleElement el5 = new SingleElement("Задача 1.2.", 1);
        el1.addElement(el2);
        el1.addElement(el3);
        el1.addElement(el4);
        el1.addElement(el5);
        el1.printElement();
    }
}
