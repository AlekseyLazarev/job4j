package ru.alazarev.lsp;

import ru.alazarev.lsp.foods.Food;
import ru.alazarev.lsp.foods.Milk;
import ru.alazarev.lsp.storages.IStorage;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * Class FoodAssistant решение задачи части 004. 3.2. Расширенное хранилище. [#853]
 *
 * @author Aleksey Lazarev
 * @since 13.06.2019
 */
public class FoodAssistant {
    private Calendar c1 = new GregorianCalendar();
    private Calendar c2 = new GregorianCalendar();
    private ControlQuality cq = new ControlQuality();
    private int year;
    private int month;
    private double stdPrice;
    private double stdDisc;
    private int date1;
    private int date2;
    private Calendar now;

    /**
     * Constructor.
     *
     * @param year     Year value.
     * @param month    Month value.
     * @param day      Day value.
     * @param stdPrice Standard price.
     * @param stdDisc  Standard discount.
     */
    public FoodAssistant(int year, int month, int day, double stdPrice, double stdDisc) {
        this.year = year;
        this.month = month;
        this.stdDisc = stdDisc;
        this.stdPrice = stdPrice;
        this.now = new GregorianCalendar(year, month, day);
    }

    /**
     * Method setup expires and create dates.
     *
     * @param date1 Expire date value.
     * @param date2 Create date value.
     */
    public void setupDates(int date1, int date2) {
        this.date1 = date1;
        this.date2 = date2;
    }

    /**
     * Method create milk.
     *
     * @param nameMilk Name milk value.
     * @return Milk object.
     */
    public Food createMilk(String nameMilk) {
        this.c1.set(this.year, this.month, this.date1);
        this.c2.set(this.year, this.month, this.date2);
        return new Milk(nameMilk, this.c1.getTime(), this.c2.getTime(), this.stdPrice, this.stdDisc);
    }

    /**
     * Method return ControlQuality object.
     *
     * @return ControlQuality object.
     */
    public ControlQuality getCq() {
        return cq;
    }

    /**
     * Method return now date.
     *
     * @return return now date.
     */
    public Date getNowInDate() {
        return this.now.getTime();
    }

    /**
     * Method return storage object.
     *
     * @param name  Name value.
     * @param date1 Expire date value.
     * @param date2 Create date value.
     * @return storage object.
     */
    public IStorage checker(String name, int date1, int date2) {
        setupDates(date1, date2);
        return getCq().distributor(createMilk(name), getNowInDate());
    }

    /**
     * Method return expire date.
     *
     * @return expire date.
     */
    public Date getDate1() {
        this.c1.set(this.year, this.month, this.date1);
        return this.c1.getTime();
    }

    /**
     * Method return create date.
     *
     * @return create date.
     */
    public Date getDate2() {
        this.c2.set(this.year, this.month, this.date2);
        return this.c2.getTime();
    }

    /**
     * Method return standard price.
     *
     * @return standard price.
     */
    public double getStdPrice() {
        return stdPrice;
    }

    /**
     * Method return standard discount.
     *
     * @return standard discount.
     */
    public double getStdDisc() {
        return stdDisc;
    }
}
