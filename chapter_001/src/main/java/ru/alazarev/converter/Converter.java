package ru.alazarev.converter;

/**
 * Class money converter.
 */
public class Converter {
    private static int euro = 76;
    private static int dollar = 67;
    /**
     * Convert rub into euro.
     * @param value In rub.
     * @return Euro.
     */
    public int rubleToEuro(int value){
        return value / euro;
    }
    /**
     * Convert rub into dollar.
     * @param value In rub.
     * @return Dollar.
     */
    public int rubleToDollar(int value){
        return value / dollar;
    }
    /**
     * Convert euro into rub.
     * @param value In euro.
     * @return Rub.
     */
    public int euroToRuble(int value){
        return value * euro;
    }
    /**
     * Convert dollar into rub.
     * @param value In dollar.
     * @return Rub.
     */
    public int dollarToRuble(int value){
        return value * dollar;
    }
}
