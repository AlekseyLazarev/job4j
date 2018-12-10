package ru.alazarev.list;

/**
 * Class SimpleStack решение задачи части 001. 5.3.3. Используя контейнер на базе связанного списка создать контейнер Stack [#71474].
 *
 * @author Aleksey Lazarev
 * @since 09.12.2018
 */
public class SimpleStack<T> extends NodeList<T> {
    private NodeList<T> stack = new NodeList<>();

    /**
     * Method return value and delete it.
     *
     * @return value.
     */
    public T poll() {
        return stack.delete(0);
    }

    /**
     * Method add value in stack.
     *
     * @param value Value for add.
     */
    public void push(T value) {
        stack.add(value);
    }
}
