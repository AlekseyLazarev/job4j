package ru.alazarev.socket.fileManager;

import org.junit.Test;
import ru.alazarev.socket.filemanager.Settings;

import java.io.IOException;
import java.io.InputStream;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class SettingsTest {
    @Test
    public void settingsGetHomePathFromProperties() throws IOException {
        Settings settings = new Settings();
        ClassLoader classLoader = Settings.class.getClassLoader();
        try (InputStream is = classLoader.getResourceAsStream("app.properties")) {
            settings.load(is);
        }
        assertThat(settings.getValue("home.path"), is("c:\\chat"));
    }

}