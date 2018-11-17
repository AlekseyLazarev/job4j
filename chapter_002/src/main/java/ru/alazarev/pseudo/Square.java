package ru.alazarev.pseudo;

/**
 * Class Square implements interface Shape решение задачи части 002. Урок 4.4. Используя шаблон проектирования - стратегию [#786].
 *
 * @author Aleksey Lazarev
 * @since 16.11.2018
 */
public class Square implements Shape {
    /**
     * Method draw square in pseudo graphic.
     *
     * @return Pseudo graphic shape.
     */
    @Override
    public String draw() {
        StringBuilder square = new StringBuilder();
        square.append("*******"+System.lineSeparator());
        square.append("*     *"+System.lineSeparator());
        square.append("*     *"+System.lineSeparator());
        square.append("*******");
        return square.toString();
    }
}
