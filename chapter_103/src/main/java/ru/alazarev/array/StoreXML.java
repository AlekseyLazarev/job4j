package ru.alazarev.array;


import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * Class StoreXML решение задачи части 003. Урок 4.3. XML XSLT JDBC Оптимизация.
 *
 * @author Aleksey Lazarev
 * @since 14.04.2019
 */
public class StoreXML {
    private final File target;

    /**
     * Constructor.
     *
     * @param target File for save xml.
     */
    public StoreXML(File target) {
        this.target = target;
    }

    /**
     * Method convert list entries to xml.entries.
     *
     * @param list list entries for convert.
     * @return xml.entry list.
     */
    public List<XmlUsage.Entry> converter(List<Entry> list) {
        List<XmlUsage.Entry> result = new ArrayList<>();
        for (Entry e : list) {
            result.add(new XmlUsage.Entry(e.getField()));
        }
        return result;
    }

    /**
     * Method save entry list into xml file.
     *
     * @param list List entries for save.
     */
    public void save(List<Entry> list) {
        new XmlUsage().run(converter(list), this.target);
    }

}
