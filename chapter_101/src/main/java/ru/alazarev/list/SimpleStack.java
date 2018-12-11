package ru.alazarev.list;

/**
 * Class SimpleStack решение задачи части 001. 5.3.3. Используя контейнер на базе связанного списка создать контейнер Stack [#71474].
 *
 * @author Aleksey Lazarev
 * @since 09.12.2018
 */
public class SimpleStack<T> {
    private NodeList<T> stack = new NodeList<>();

    /**
     * Method return value and delete it (LIFO).
     *
     * @return value.
     */
    public T poll() {
        return this.stack.delete(0);
    }

    /**
     * Method return value and delete it by position.
     *
     * @param position Position for delete and return value.
     * @return Value.
     */
    public T poll(int position) {
        return this.stack.delete(position);
    }

    /**
     * Method passes NodeList instance size.
     *
     * @return Size of list.
     */
    public int getSize() {
        return this.stack.getSize();
    }

    /**
     * Method add value in stack.
     *
     * @param value Value for add.
     */
    public void push(T value) {
        this.stack.add(value);
    }
}
