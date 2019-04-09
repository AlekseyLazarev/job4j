package ru.alazarev.tracker;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNull.nullValue;
import static org.junit.Assert.assertThat;

public class TrackerSQLTest {
    private TrackerSQL trackerSQL;
    private int count = 5;
    private boolean filled = false;

    @Before
    public void start() {
        this.trackerSQL = new TrackerSQL();
        this.trackerSQL.init();
        if (!this.filled) {
            for (int i = 0; i < this.count - 1; i++) {
                this.trackerSQL.add(new Item("TEST NAME " + i, "TEST DESC " + i, "TEST comment " + i));
            }
            this.trackerSQL.add(new Item("TEST NAME 1", "TEST DESC 1", "TEST comment 1"));
        }
    }

    @Test
    public void checkConnection() {
        TrackerSQL sql = new TrackerSQL();
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
        this.trackerSQL.delete("3");
        Item item = this.trackerSQL.findById("3");
        assertThat(item, is(nullValue()));
    }


    @Test
    public void ifFindByNameThen() {
        assertThat(this.trackerSQL.findByName("TEST NAME 0")[0].getName(), is("TEST NAME 0"));
    }
}