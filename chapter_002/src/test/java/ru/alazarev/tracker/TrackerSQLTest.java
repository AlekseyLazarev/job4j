package ru.alazarev.tracker;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class TrackerSQLTest {
    private TrackerSQL trackerSQL;
    private int count = 5;
    private boolean filled = false;

    public Connection init() {
        try (InputStream in = TrackerSQL.class.getClassLoader().getResourceAsStream("app.properties")) {
            Properties config = new Properties();
            config.load(in);
            Class.forName(config.getProperty("driver-class-name"));
            return DriverManager.getConnection(
                    config.getProperty("url") + config.getProperty("dbname"),
                    config.getProperty("username"),
                    config.getProperty("password")

            );
        } catch (Exception e) {
            throw new IllegalStateException(e);
        }
    }

    @Before
    public void start() throws Exception {
        this.trackerSQL = new TrackerSQL(ConnectionRollback.create(this.init()));
        if (!this.filled) {
            for (int i = 0; i < this.count - 1; i++) {
                this.trackerSQL.add(new Item("TEST NAME " + i, "TEST DESC " + i, "TEST comment " + i));
            }
            this.trackerSQL.add(new Item("TEST NAME 1", "TEST DESC 1", "TEST comment 1"));
            this.filled = true;
        }
    }

    @Test
    public void checkConnection() throws Exception {
        TrackerSQL sql = new TrackerSQL(ConnectionRollback.create(this.init()));
        assertThat(sql.init(), is(true));
    }

    @Test
    public void ifAddThen() {
        int before = this.trackerSQL.numberOfRecords();
        this.trackerSQL.add(new Item("TEST NAME99", "TEST DESC99", "TEST comment 99"));
        assertThat(this.trackerSQL.numberOfRecords(), is(before + 1));
    }

    @Test
    public void ifFindByIdThen() {
        assertThat(this.trackerSQL.findById("1").getName(), is("TEST NAME 0"));
    }

    @Test
    public void ifReplaceThen() {
        this.trackerSQL.replace("4", new Item("Replace Test", "TEST DESC 1", "TEST comment 1"));
        assertThat(this.trackerSQL.findById("4").getName(), is("Replace Test"));
    }

    @Test
    public void ifDeleteThen() {
        this.trackerSQL.add(new Item("DeleteTest", "TEST DESC 1", "TEST comment 1"));
        this.trackerSQL.delete("DeleteTest");
        assertThat(this.trackerSQL.findByName("DeleteTest").size(), is(0));
    }

    @Test
    public void ifFindByNameThen() {
        assertThat(this.trackerSQL.findByName("TEST NAME 0").get(0).getName(), is("TEST NAME 0"));
    }

    @After
    public void conClose() throws Exception {
        this.trackerSQL.close();
    }
}