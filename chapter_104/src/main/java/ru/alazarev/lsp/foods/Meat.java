package ru.alazarev.lsp.foods;

import java.util.Date;

/**
 * Class Meat расширяющий класс Food решение задачи части 004. 3.1. Хранилище продуктов [#852]
 *
 * @author Aleksey Lazarev
 * @since 27.05.2019
 */
public class Meat extends Food {
    /**
     * Constructor.
     *
     * @param name       Value of food name.
     * @param expireDate Value of expire food date.
     * @param createDate Value of create food date.
     * @param price      Value of food price.
     * @param discount   Value of food discount.
     */
    public Meat(String name, Date expireDate, Date createDate, double price, double discount) {
        super(name, expireDate, createDate, price, discount);
    }
}
