package ru.alazarev.pseudo;

public class Triangle implements Shape {
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
