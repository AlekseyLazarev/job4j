package ru.alazarev.tracker;

import java.util.Arrays;

/**
 * Class Tracker решение задачи части 002. Урок 2. Реализовать класс Tracker [#396].
 *
 * @author Aleksey Lazarev
 * @since 15.11.2018
 */
public class Tracker {
    private final Item[] items = new Item[100];
    private int position = 0;
    private int uniqueId = 0;

    /**
     * Add item in items array.
     *
     * @param item What item need to add.
     * @return added item.
     */
    public Item add(Item item) {
        item.setId(this.generateId());
        this.items[position++] = item;
        return item;
    }

    /**
     * Replace item in array.
     *
     * @param id   Item unique id.
     * @param item Item to replace.
     */
    public Boolean replace(String id, Item item) {
        Boolean result = false;
        for (int index = 0; index != position; index++) {
            if (items[index] != null && items[index].getId().equals(id)) {
                items[index].setName(item.getName());
                items[index].setDesc(item.getDesc());
                result = true;
                break;
            }
        }
        return result;
    }

    /**
     * Delete item with id.
     * Rewrite array.
     *
     * @param id Item unique id.
     */
    public Boolean delete(String id) {
        Boolean result = false;
        for (int index = 0; index != position; index++) {
            if (items[index] != null && items[index].getId().equals(id)) {
                System.arraycopy(items, index + 1, items, index, items.length - index - 1);
                result = true;
                position--;
                break;
            }
        }
        return result;
    }

    /**
     * View items array.
     *
     * @return items array.
     */
    public Item[] findAll() {
        return Arrays.copyOf(items, position);
    }

    /**
     * Find item in array by name.
     *
     * @param key Name of item.
     * @return array of all matched values.
     */
    public Item[] findByName(String key) {
        Item[] result = new Item[this.position];
        int indexResult = 0;
        for (int index = 0; index != this.position; index++) {
            if (this.items[index] != null && this.items[index].getName().equals(key)) {
                result[indexResult] = this.items[index];
                indexResult++;
            }
        }
        return Arrays.copyOf(result, indexResult);
    }

    /**
     * Find item by unique id.
     *
     * @param id Item unique id.
     * @return found item.
     */
    protected Item findById(String id) {
        Item result = null;
        for (Item desired : items) {
            if (desired != null && desired.getId().equals(id)) {
                result = desired;
                break;
            }
        }
        return result;
    }

    /**
     * Generate id method.
     *
     * @return New unique id.
     */
    private String generateId() {
        return String.valueOf(uniqueId++);
    }
}