package ru.alazarev.tracker;


/**
 * Class Item решение задачи части 002. Урок 2. Реализовать класс Tracker [#396].
 *
 * @author Aleksey Lazarev
 * @since 15.11.2018
 */
public class Item {
    private String id;
    private String name;
    private String desc;
    private long created;
    private String[] comments;

    /**
     * Constructor for item.
     *
     * @param name Item name.
     * @param desc Item description.
     */
    public Item(String name, String desc) {
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
     *
     * @param created It for setup.
     */
    public void setCreated(Long created) {
        this.created = created;
    }
}