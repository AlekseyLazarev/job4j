package ru.alazarev.pseudo;

/**
 * Class Paint решение задачи части 002. Урок 4.4. Используя шаблон проектирования - стратегию [#786].
 *
 * @author Aleksey Lazarev
 * @since 16.11.2018
 */
public class Paint {
    /**
     * Call draw method.
     *
     * @param shape Figure to draw.
     */
    public void draw(Shape shape) {
        System.out.println(shape.draw());
    }

    /**
     * Start program.
     *
     * @param args Arguments.
     */
    public static void main(String[] args) {
        Paint paint = new Paint();
        Triangle triangle = new Triangle();
        Square square = new Square();
        paint.draw(triangle);
        paint.draw(square);
    }
}
