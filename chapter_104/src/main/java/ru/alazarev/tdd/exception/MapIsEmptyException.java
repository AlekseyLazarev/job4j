package ru.alazarev.tdd.exception;

/**
 * Class MapIsEmptyException решение задачи части 4 6.1. Исправить код класс SimpleGenerator. [#855]
 *
 * @author Aleksey Lazarev
 * @since 20.08.2019
 */
public class MapIsEmptyException extends RuntimeException {
    public MapIsEmptyException() {
        System.out.println("Map is empty");
    }
}
