package ru.alazarev.lsp.foods;

import java.util.Date;

/**
 * Class Grape решение задачи части 004. 3.2. Расширенное хранилище. [#853]
 *
 * @author Aleksey Lazarev
 * @since 14.06.2019
 */
public class Grape extends Food {
    /**
     * Constructor.
     *
     * @param name       Value of food name.
     * @param expireDate Value of expire food date.
     * @param createDate Value of create food date.
     * @param price      Value of food price.
     * @param discount   Value of food discount.
     */
    public Grape(String name, Date expireDate, Date createDate, double price, double discount) {
        super(name, expireDate, createDate, price, discount);
    }
}
