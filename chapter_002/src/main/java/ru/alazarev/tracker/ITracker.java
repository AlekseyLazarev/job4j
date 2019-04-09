package ru.alazarev.tracker;

public interface ITracker {
    Item add(Item item);
    Boolean replace(String id, Item item);
    Boolean delete(String id);
    Item[] findAll();
    Item[] findByName(String name);
    Item findById(String id);
}