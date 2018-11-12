package ru.alazarev.array;

/**
 * Class Check решение задачи части 001. 6.4. Слово начинается с ... [#41585].
 *
 * @author Aleksey Lazarev
 * @since 12.11.2018
 */
public class ArrayChar {
    private char[] data;

    /**
     * Constructor for ArrayChar.
     *
     * @param line Line to convert in char array.
     */
    public ArrayChar(String line) {
        this.data = line.toCharArray();
    }

    /**
     * Search prefix string.
     *
     * @param prefix Search prefix.
     * @return result of search.
     */
    public boolean startWith(String prefix) {
        boolean result = true;
        char[] value = prefix.toCharArray();
        for (int index = 0; index < value.length; index++) {
            if (data[index] != value[index]) {
                result = false;
                break;
            }
        }
        return result;
    }
}
