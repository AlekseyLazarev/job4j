package ru.alazarev.list;

/**
 * Class SimpleQueue решение задачи части 001. 5.3.3.1 Очередь на двух стеках [#160].
 *
 * @author Aleksey Lazarev
 * @since 11.12.2018
 */
public class SimpleQueue<T> {
    private SimpleStack<T> queue = new SimpleStack<>();
    private SimpleStack<T> stack = new SimpleStack<>();

    /**
     * Method return value and delete it(FIFO).
     *
     * @return value.
     */
    public T poll() {
        if (queue.empty()) {
            while (!stack.empty()) {
                queue.push(stack.poll());
            }
        }
        return queue.poll();
    }

    /**
     * Method add value in stack.
     *
     * @param value Value for add.
     */
    public void push(T value) {
        stack.push(value);
    }
}
