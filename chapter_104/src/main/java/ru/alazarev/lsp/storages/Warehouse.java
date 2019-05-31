package ru.alazarev.lsp.storages;

/**
 * Class Warehouse решение задачи части 004. 3.1. Хранилище продуктов [#852]
 *
 * @author Aleksey Lazarev
 * @since 27.05.2019
 */
public class Warehouse extends Storage {

    public Warehouse() {
        setAcceptQualityLower(0);
        setAcceptQualityUpper(25);
    }
}