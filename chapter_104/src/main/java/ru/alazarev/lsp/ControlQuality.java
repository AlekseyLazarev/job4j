package ru.alazarev.lsp;

import ru.alazarev.lsp.foods.Food;
import ru.alazarev.lsp.foods.Milk;
import ru.alazarev.lsp.storages.Shop;
import ru.alazarev.lsp.storages.Storage;
import ru.alazarev.lsp.storages.Trash;
import ru.alazarev.lsp.storages.Warehouse;

import java.util.*;

/**
 * Class ControlQuality решение задачи части 004. 3.1. Хранилище продуктов [#852]
 *
 * @author Aleksey Lazarev
 * @since 27.05.2019
 */

/**
 * Класс должен перераспределять еду по хранилищам в зависимости от условиый.
 * 3.1. Если срок годности израсходован меньше чем на 25% направить в Warehouse.
 * 3.2 Если срок годности от 25% до 75% направить в Shop
 * 3.3. Если срок годности больше 75% то выставить скидку на продукт и отправить в Shop
 * 3.4. Если срок годности вышел. Отправить продукт в мусорку.
 */
public class ControlQuality {
    Storage ct;
    private final List<Storage> storageList = new ArrayList<>();

    public ControlQuality() {
        this.storageList.add(new Shop());
        this.storageList.add(new Trash());
        this.storageList.add(new Warehouse());
    }

    public void addStorage(Storage storage) {
        this.storageList.add(storage);
    }

    public void setStorage(Storage storage) {
        ct = storage;
    }

    /**
     * Method distribute food to storage.
     *
     * @param food Food value.
     * @return Storage value.
     */
    public Storage distributor(Food food, Date date) {
        Storage res = null;
        for (Storage storage : this.storageList) {
            if(storage.addTo(food,date)) {
                res = storage;
                break;
            }
        }
        int a = 1;
//        if (freshProc >= 1) {
//            ct = new Trash();
//        } else if (freshProc > 0.75) {
//            ct = new Shop();
//            food.setDiscount(0.2);
//        } else if (freshProc > 0.25) {
//            ct = new Shop();
//        } else if (freshProc > 0) {
//            ct = new Warehouse();
//        }
//        return ct.addTo(food);
        return res;
    }

    public static void main(String[] args) {
        ControlQuality cq = new ControlQuality();
        Warehouse w = new Warehouse();
        Shop s = new Shop();
        Trash t = new Trash();
        Shop sa = new Shop();
        Milk milk = new Milk("Milk", new Date(2019, 05, 30), new Date(2019, 05, 20), 10000, 0);
        cq.distributor(milk, new Date(2019, 05, 25));
        int a = 10;
//        cq.distribValues.put(new Double[]{1D}, new Trash());
//        cq.distribValues.put(new Double[]{0.75, 1D}, new Shop());
//        cq.distribValues.put(new Double[]{0.25, 0.75}, new Shop());
//        cq.distribValues.put(new Double[]{0D, 0.25}, new Warehouse());
        for (int i = 0; i < 3; i++) {

        }
    }

}
