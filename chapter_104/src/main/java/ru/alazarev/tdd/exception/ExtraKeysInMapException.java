package ru.alazarev.tdd.exception;

import java.util.List;

/**
 * Class ExtraKeysInMapException решение задачи части 4 6.1. Исправить код класс SimpleGenerator. [#855]
 *
 * @author Aleksey Lazarev
 * @since 20.08.2019
 */
public class ExtraKeysInMapException extends RuntimeException {
    public ExtraKeysInMapException(List<String> keys) {
        System.out.println("Extra keys in map: ");
        for (String k : keys) {
            System.out.println(k);
        }
    }
}
