package ru.alazarev.lsp.storages;

import ru.alazarev.lsp.foods.IFood;

import java.util.Date;
import java.util.List;

/**
 * Interface IStorage решение задачи части 004. 3.2. Расширенное хранилище. [#853]
 *
 * @author Aleksey Lazarev
 * @since 14.06.2019
 */
public interface IStorage {
    /**
     * Method add food into storage.
     *
     * @param food Food value.
     * @return this object.
     */
    boolean addTo(IFood food, Date date);

    /**
     * Method calculate freshness.
     *
     * @param food Food object for calculate.
     * @param date Date object for calculate.
     * @return Freshness.
     */
    boolean quality(IFood food, Date date);

    /**
     * Method return foods.
     *
     * @return Food list value.
     */
    List<IFood> getFoods();
}
