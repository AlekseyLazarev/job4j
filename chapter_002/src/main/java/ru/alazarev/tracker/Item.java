package ru.alazarev.tracker;

import java.util.UUID;

/**
 * Class Item решение задачи части 002. Урок 2. Реализовать класс Tracker [#396].
 *
 * @author Aleksey Lazarev
 * @since 15.11.2018
 */
public class Item {
    private String id = UUID.randomUUID().toString();
    private String name;
    private String desc;
    private long created;
    private String[] comments;

    /**
     * Constructor for item.
     *
     * @param name    Item name.
     * @param desc    Item description.
     * @param created Item date and time creation.
     */
    public Item(String name, String desc, long created) {
        this.name = name;
        this.desc = desc;
        this.created = created;
    }

    /**
     * Get item name method.
     *
     * @return this item name.
     */
    public String getName() {
        return this.name;
    }

    /**
     * Get item description method.
     *
     * @return this item description.
     */
    public String getDesc() {
        return this.desc;
    }

    /**
     * Get item date and time creation method.
     *
     * @return this item created value.
     */
    public long getCreated() {
        return this.created;
    }

    /**
     * Get unique item id method.
     *
     * @return this item id.
     */
    public String getId() {
        return this.id;
    }

    /**
     * Setup this item id.
     *
     * @param id It for setup.
     */
    public void setId(String id) {
        this.id = id;
    }
}