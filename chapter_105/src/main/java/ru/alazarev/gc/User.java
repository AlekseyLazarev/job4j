package ru.alazarev.gc;

/**
 * Class User решение задачи части  5.1.Демонстрация работы GC.
 *
 * @author Aleksey Lazarev
 * @since 10.09.2019
 */
public class User {
    private final String name;

    public User(String name) {
        this.name = name;
    }

    @Override
    protected void finalize() throws Throwable {
        System.out.println("Finalize " + this.name + " object.");
        super.finalize();
    }
}
