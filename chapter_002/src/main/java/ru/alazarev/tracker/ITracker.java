package ru.alazarev.tracker;

import java.util.List;

public interface ITracker {
    Item add(Item item);
    Boolean replace(String id, Item item);
    Boolean delete(String id);
    List<Item> findAll();
    List<Item> findByName(String name);
    Item findById(String id);
}