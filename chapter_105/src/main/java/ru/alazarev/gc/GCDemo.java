package ru.alazarev.gc;

/**
 * Class GCDemo решение задачи части 5.1.Демонстрация работы GC.
 *
 * @author Aleksey Lazarev
 * @since 10.09.2019
 */

import ru.alazarev.gc.instrumentation.InstrumentationAgent;

/**
 * Создать объект User c полями и перекрытым методом finalize
 * <p>
 * Создать несколько объектов User и руками рассчитать сколько он будет занимать памяти.
 * <p>
 * Нужно найти информацию. Сколько памяти занимает пустой объект без полей.
 * <p>
 * Добиться состояния, когда виртуальная машины вызывает сборщик мусора самостоятельно. За счет ключей xmx.
 * <p>
 * Объяснить поведение программы в текстовом файле.
 */
public class GCDemo {
    static final long SIZE = 1000000;
    static final int KB = 1024;
    static final int MB = KB * KB;


    /**
     * Method using Instrumentation Agent, get object size and print it.
     *
     * @param first Object, who size we need to get.
     * @param name
     */
    public static void print(Object first, String name) {
        System.out.println("Object " + name + " takes " + InstrumentationAgent.getObjectSize(first) + " bytes");
    }

    /**
     * Print method.
     *
     * @param value Memory byte size.
     * @param s     Type memory name.
     */
    public static void printMemory(long value, String s) {
        System.out.println(s + " memory = " + value / MB + " Mb or " + value + " bytes");
    }

    /**
     * Method gets max, total, free memory by runtime object and initiate print method.
     *
     * @param stage Stage name.
     */
    public static void info(String stage) {
        Runtime r = Runtime.getRuntime();
        System.out.println(stage);
        printMemory(r.maxMemory(), "Max");
        printMemory(r.totalMemory(), "Total");
        printMemory(r.freeMemory(), "Free");
    }

    /**
     * Main method.
     *
     * @param args Arguments.
     */
    public static void main(String[] args) {
        info("Before");
        User u = new User("User " + SIZE);
        EmptyClass e = new EmptyClass();
        FullClass f = new FullClass();
        print(u, "user");
        print(e, "empty");
        print(f, "full");
        info("After 3 objects");
        for (long i = 0; i < SIZE; i++) {
            new User("User " + i);
        }
        info("After " + SIZE + " objects");
        System.gc();
        info("After garbage collector");
    }
}
