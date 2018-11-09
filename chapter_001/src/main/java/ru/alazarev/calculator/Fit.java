package ru.alazarev.calculator;

/**
 * Ideal weight calculation program.
 */
public class Fit {

    /**
     * Ideal weight for man.
     * @param height Male height .
     * @return ideal weight for man.
     */
    public double manWeight(double height) {
        return (height - 100) * 1.15;
    }

    /**
     * Ideal weight for woman.
     * @param height Female height.
     * @return ideal weight for woman.
     */
    public double womanWeight(double height) {
        return (height - 110) * 1.15;
    }
}