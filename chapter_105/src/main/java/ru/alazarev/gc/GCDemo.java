package ru.alazarev.gc;

/**
 * Class  решение задачи части
 *
 * @author Aleksey Lazarev
 * @since 10.09.2019
 */

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
    static int size = 400000;
    static int kb = 1024;
    static int mb = kb * kb;

    public static void print(String first, long l) {
        System.out.println(first + " memory : " + l / mb + " Mb or " + l + " b");
    }

    public static void info() {
        Runtime r = Runtime.getRuntime();
        long max = r.maxMemory();
        long free = r.freeMemory();
        long used = max - free;
        long memForOne = size != 0 ? used / size : 0;
        print("Free", free);
        print("Max", max);
        print("Used", used);
        System.out.println("Memory for 1 object User: " + String.format("%.2f", (double) memForOne / kb) + "Kb or " + memForOne + " b");
        System.out.println();
    }

    public static void main(String[] args) {
        for (int i = 0; i < size; i++) {
            new User();
        }
        info();
    }
}
