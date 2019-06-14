package ru.alazarev.lsp.storages;

import ru.alazarev.lsp.foods.ReproduceFood;

import java.util.Date;

public class ReproduceStorage extends Trash {
    public boolean addTo(ReproduceFood food, Date date) {
        return food.isReproducible() ? super.addTo(food, date) : false;
    }
}
