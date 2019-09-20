package ru.alazarev.gc;

/**
 * Class  решение задачи части
 *
 * @author Aleksey Lazarev
 * @since 10.09.2019
 */
public class User {
    int a = 9999;
    String aa = "12";
    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        System.out.println("Finalize");
    }
}
