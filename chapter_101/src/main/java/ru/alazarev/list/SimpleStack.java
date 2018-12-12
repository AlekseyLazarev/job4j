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
     * Method passes NodeList instance size.
     *
     * @return Size of list.
     */
    public int getSize() {
        return this.stack.getSize();
    }

    public boolean empty(){
        return stack.checkEmpty();
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
