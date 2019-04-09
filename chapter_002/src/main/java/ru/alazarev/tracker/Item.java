package ru.alazarev.tracker;


import java.util.Date;

/**
 * Class Item решение задачи части 002. Урок 2. Реализовать класс Tracker [#396].
 *
 * @author Aleksey Lazarev
 * @since 15.11.2018
 */
public class Item {
    /**
     * Identifier of request.
     */
    private String id;
    /**
     * Name of request.
     */
    private String name;
    /**
     * Description of request.
     */
    private String desc;
    /**
     * Date and time create of request.
     */
    private long created;
    /**
     * Comments of request.
     */
    private String comments;
    /**
     * Constructor for item.
     *
     * @param name Item name.
     * @param desc Item description.
     */
    public Item(String name, String desc) {
        this.name = name;
        this.desc = desc;
        setCreated();
    }
    /**
     * Constructor for item.
     *
     * @param name Item name.
     * @param desc Item description.
     */
    public Item(String name, String desc, String comments) {
        this.name = name;
        this.desc = desc;
        this.comments = comments;
        setCreated();
    }

    public Item(String id, String name, String desc, long created, String comments) {
        this.id = id;
        this.name = name;
        this.desc = desc;
        this.created = created;
        this.comments = comments;
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
     * Get item comments method.
     *
     * @return this item comments.
     */
    public String getComments() {
        return this.comments;
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

    /**
     * Setup this item name.
     *
     * @param name It for setup.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Setup this item desc.
     *
     * @param desc It for setup.
     */
    public void setDesc(String desc) {
        this.desc = desc;
    }

    /**
     * Setup this item created.
     */
    public void setCreated() {
        this.created = new Date().getTime();
    }
}