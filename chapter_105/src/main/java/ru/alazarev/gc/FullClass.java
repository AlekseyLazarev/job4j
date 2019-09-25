package ru.alazarev.gc;

/**
 * Class FullClass решение задачи части 5.1.Демонстрация работы GC.
 *
 * @author Aleksey Lazarev
 * @since 25.09.2019
 */
public class FullClass {
    private byte a = 120;
    private short b = 130;
    private int c = 2000000;
    private float d = 123F;
    private String e = "Simple string";

    public byte getA() {
        return a;
    }

    public void setA(byte a) {
        this.a = a;
    }

    public short getB() {
        return b;
    }

    public void setB(short b) {
        this.b = b;
    }

    public int getC() {
        return c;
    }

    public void setC(int c) {
        this.c = c;
    }

    public float getD() {
        return d;
    }

    public void setD(float d) {
        this.d = d;
    }

    public String getE() {
        return e;
    }

    public void setE(String e) {
        this.e = e;
    }
}
