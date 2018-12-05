package ru.alazarev.store;

import ru.alazarev.generic.SimpleArray;

/**
 * Class AbstractStore решение задачи части 001. Урок 5.2.2. Реализовать Store<T extends Base> [#157].
 *
 * @author Aleksey Lazarev
 * @since 04.12.2018
 */
public class AbstractStore<T extends Base> implements Store<T> {

    private SimpleArray<T> models;
    private int size;

    /**
     * Constructor.
     *
     * @param size Array size.
     */
    public AbstractStore(int size) {
        this.size = size;
        models = new SimpleArray(this.size);
    }

    /**
     * Add new element method.
     *
     * @param model Element to add.
     */
    public void add(T model) {
        models.add(model);
    }

    /**
     * Method replaces element with id.
     *
     * @param id    Element id.
     * @param model Replacement item.
     * @return Result of replaces.
     */
    public boolean replace(String id, T model) {
        boolean result = false;
        int findItem = findIndexById(id);
        if (findItem != -1) {
            models.set(findItem, model);
            result = true;
        }
        return result;
    }

    /**
     * Method delete item from array.
     *
     * @param id
     * @return
     */
    public boolean delete(String id) {
        boolean result = false;
        int index = findIndexById(id);
        if (index != -1) {
            models.delete(index);
            result = true;
        }
        return result;
    }

    /**
     * Method find element by his id.
     *
     * @param id Element required id.
     * @return Find element.
     */
    public T findById(String id) {
        T result = null;
        for (int index = 0; index < size; index++) {
            if (models.get(index) != null && models.get(index).getId().equals(id)) {
                result = models.get(index);
                break;
            }
        }
        return result;
    }

    /**
     * Method find index element by his id.
     *
     * @param id Element required id.
     * @return Index element.
     */
    public int findIndexById(String id) {
        int result = -1;
        for (int index = 0; index < size; index++) {
            if (models.get(index) != null && models.get(index).getId().equals(id)) {
                result = index;
                break;
            }
        }
        return result;
    }
}
