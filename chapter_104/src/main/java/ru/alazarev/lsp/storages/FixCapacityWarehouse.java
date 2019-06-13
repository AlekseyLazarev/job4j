package ru.alazarev.lsp.storages;

        import ru.alazarev.lsp.foods.Food;

        import java.util.Date;

/**
 * Class FixCapacityWarehouse решение задачи части 004. 3.1. Хранилище продуктов [#852]
 *
 * @author Aleksey Lazarev
 * @since 13.06.2019
 */
public class FixCapacityWarehouse extends StorageDecorator {
    private final int capacity;
    private int currentSize;

    public FixCapacityWarehouse(Storage storageDecorator, int capacity) {
        super(storageDecorator);
        this.capacity = capacity;
        this.currentSize = storageDecorator.foods.size();
    }

    @Override
    public boolean addTo(Food food, Date date) {
        boolean result = false;
        if (this.currentSize < this.capacity) {
            this.currentSize++;
            result = super.addTo(food, date);
        }
        return result;
    }
}
