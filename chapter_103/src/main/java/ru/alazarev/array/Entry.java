package ru.alazarev.array;

/**
 * Class Entry решение задачи части 003. Урок 4.3. XML XSLT JDBC Оптимизация.
 *
 * @author Aleksey Lazarev
 * @since 14.04.2019
 */
public class Entry {
    int field;

    /**
     * Constructor.
     *
     * @param field Field value.
     */
    public Entry(int field) {
        this.field = field;
    }

    /**
     * Method return field value.
     *
     * @return field value.
     */
    public int getField() {
        return field;
    }
}