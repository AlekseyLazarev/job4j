package ru.alazarev.pseudo;

public class Paint {
    public void draw(Shape shape) {
        System.out.println(shape.draw());
    }

    public static void main(String[] args) {
        Paint paint = new Paint();
        Triangle triangle = new Triangle();
        Square square = new Square();
        paint.draw(triangle);
        paint.draw(square);
    }
}
