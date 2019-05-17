package ru.alazarev.parser;

/**
 * Class Vacancy решение задачи Парсер вакансий на sql.ru [#1731].
 *
 * @author Aleksey Lazarev
 * @since 30.04.2019
 */
public class Vacancy {
    private String name;
    private String text;
    private String link;
    private long date;

    /**
     * Constructor.
     *
     * @param name Name vacancy.
     * @param text Description vacancy.
     * @param link Link vacancy.
     */
    public Vacancy(String name, String text, String link, long date) {
        this.name = name;
        this.text = text;
        this.link = link;
        this.date = date;
    }

    /**
     * Set link field vacancy.
     *
     * @param link
     */
    public void setLink(String link) {
        this.link = link;
    }

    /**
     * Set name field vacancy.
     *
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Set text field vacancy.
     *
     * @param text
     */
    public void setText(String text) {
        this.text = text;
    }

    /**
     * Get link field vacancy.
     *
     * @return link value.
     */
    public String getLink() {
        return link;
    }

    /**
     * Get name field vacancy.
     *
     * @return name value.
     */
    public String getName() {
        return name;
    }

    /**
     * Get text field vacancy.
     *
     * @return text value.
     */
    public String getText() {
        return text;
    }

    /**
     * Get date field vacancy.
     *
     * @return long value.
     */
    public long getDate() {
        return date;
    }

    /**
     * Set date field vacancy.
     *
     * @param date
     */
    public void setDate(long date) {
        this.date = date;
    }
}
