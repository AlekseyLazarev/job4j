package ru.alazarev.lsp.foods;

import java.util.Date;

/**
 * Interface IFood решение задачи части 004. 3.2. Расширенное хранилище. [#853]
 *
 * @author Aleksey Lazarev
 * @since 17.06.2019
 */
public interface IFood {
    /**
     * Method return need for cold storage.
     *
     * @return need for cold storage.
     */
    boolean coldStorageNeeded();

    /**
     * Method return recycling capacity.
     *
     * @return recycling capacity.
     */
    boolean canReproduce();

    /**
     * Method return food price variable.
     *
     * @return food price variable.
     */
    double getPrice();

    /**
     * Method return food discount variable.
     *
     * @return food discount variable.
     */
    double getDiscount();

    /**
     * Method set food discount variable.
     *
     * @param discount food discount value.
     */
    void setDiscount(double discount);

    /**
     * Method return shelf life.
     *
     * @return shelf life.
     */
    int freshness(Date current);
}
