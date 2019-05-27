package ru.alazarev.lsp;

import ru.alazarev.lsp.foods.Food;
import ru.alazarev.lsp.storages.Shop;
import ru.alazarev.lsp.storages.Storage;
import ru.alazarev.lsp.storages.Trash;
import ru.alazarev.lsp.storages.Warehouse;

import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 * Class ControlQuality решение задачи части 004. 3.1. Хранилище продуктов [#852]
 *
 * @author Aleksey Lazarev
 * @since 27.05.2019
 */
public class ControlQuality {
    private double discount = 0.2;
    Context ct = new Context();
    Calendar now = new GregorianCalendar();

    /**
     * Method return current discount value.
     *
     * @return current discount value.
     */
    public double getDiscount() {
        return this.discount;
    }

    /**
     * Method set current discount variable.
     *
     * @param discount Discount value.
     */
    public void setDiscount(double discount) {
        this.discount = discount;
    }

    /**
     * Constructor.
     *
     * @param year  Year value.
     * @param month Month value.
     * @param day   Day value.
     */
    public ControlQuality(int year, int month, int day) {
        this.now.set(year, month, day);
    }

    /**
     * Method calculate food freshness percentage.
     *
     * @param food Food value.
     * @return Result of calc freshness.
     */
    private double freshnessPercentage(Food food) {
        double result = 1D - (double) (food.getExpireDate().getTime() - this.now.getTime().getTime()) / (double) food.freshDays();
        return result > 0 ? result : 1;
    }

    /**
     * Method distribute food to storage.
     *
     * @param food Food value.
     * @return Storage value.
     */
    public Storage distributor(Food food) {
        double freshProc = freshnessPercentage(food);
        if (freshProc >= 1) {
            ct.setStorage(new Trash());
        } else if (freshProc > 0.75) {
            ct.setStorage(new Shop());
            food.setDiscount(this.discount);
        } else if (freshProc > 0.25) {
            ct.setStorage(new Shop());
        } else if (freshProc > 0) {
            ct.setStorage(new Warehouse());
        }
        return ct.storageAdd(food);
    }
}
