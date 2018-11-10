package ru.alazarev.сondition;

/**
 * Class Point решение задачи части 001. Урок 3.4. Расстояние между точками в системе координат [#188].
 * @author Aleksey Lazarev
 * @since 09.11.2018
 */
public class Point {
    private final int x;
    private final int y;

    /**
     * Point constructor.
     *
     * @param x coordinate X.
     * @param y coordinate Y.
     */
    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Calculate distance from a to b.
     *
     * @param that point to the distance.
     * @return distance from a to b.
     */
    public double distanceTo(Point that) {
        return Math.sqrt(Math.pow(that.x - this.x, 2) + Math.pow(that.y - this.y, 2));
    }

    public static void main(String[] args) {
        Point a = new Point(0, 1);
        Point b = new Point(2, 5);
        // сделаем вызов метода
        System.out.println("x1 = " + a.x);
        System.out.println("y1 = " + a.y);
        System.out.println("x2 = " + b.x);
        System.out.println("y2 = " + b.y);

        System.out.println("Расстояние между точками А и В : " + a.distanceTo(b));
    }
}