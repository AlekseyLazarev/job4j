package ru.alazarev.tdd.exception;

/**
 * Class KeyNotFoundException решение задачи части 4 6.1. Исправить код класс SimpleGenerator. [#855]
 *
 * @author Aleksey Lazarev
 * @since 20.08.2019
 */
public class KeyNotFoundException extends RuntimeException {
    public KeyNotFoundException() {
        System.out.println("Key not found exception");
    }
}
