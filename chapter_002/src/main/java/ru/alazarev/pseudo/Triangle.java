package ru.alazarev.pseudo;

/**
 * Class Triangle implements interface Shape решение задачи части 002. Урок 4.4. Используя шаблон проектирования - стратегию [#786].
 *
 * @author Aleksey Lazarev
 * @since 16.11.2018
 */
public class Triangle implements Shape {
    /**
     * Method draw triangle in pseudo graphic.
     *
     * @return Pseudo graphic shape.
     */
    @Override
    public String draw() {
        StringBuilder triangle = new StringBuilder();
        triangle.append("   *   \n");
        triangle.append("  ***  \n");
        triangle.append(" ***** \n");
        triangle.append("*******\n");
        return triangle.toString();
    }
}
