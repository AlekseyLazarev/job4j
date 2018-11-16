package ru.alazarev.pseudo;

public class Square implements Shape {
    @Override
    public String draw() {
        StringBuilder square = new StringBuilder();
        square.append("*******\n");
        square.append("*     *\n");
        square.append("*     *\n");
        square.append("*******\n");
        return square.toString();
    }
}
