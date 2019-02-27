package ru.alazarev.socket.filemanager;

import java.io.InputStream;
import java.util.Properties;

/**
 * Class Settings решение задачи части 002. 2. Сетевой менеджер файлов. [#863].
 *
 * @author Aleksey Lazarev
 * @since 26.02.2019
 */
public class Settings {
    private final Properties prs = new Properties();

    public void load(InputStream is) {
        try {
            this.prs.load(is);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public String getValue(String key) {
        return this.prs.getProperty(key);
    }
}
