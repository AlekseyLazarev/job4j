package ru.alazarev.array;

import java.io.InputStream;
import java.util.Properties;

/**
 * Class Config решение задачи части 003. Урок 4.3. XML XSLT JDBC Оптимизация.
 *
 * @author Aleksey Lazarev
 * @since 14.04.2019
 */
public class Config {
    private final Properties values = new Properties();

    /**
     * Method initiate config file.
     */
    public void init() {
        try (InputStream in = Config.class.getClassLoader().getResourceAsStream("app.properties")) {
            this.values.load(in);
        } catch (Exception e) {
            throw new IllegalStateException(e);
        }
    }

    /**
     * Method return value by key.
     *
     * @param key Find key.
     * @return Value.
     */
    public String get(String key) {
        return this.values.getProperty(key);
    }

}