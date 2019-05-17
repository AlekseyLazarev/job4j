package ru.alazarev.parser;

import ru.alazarev.array.Config;

import java.io.FileOutputStream;
import java.io.OutputStream;
import java.sql.*;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashSet;
import java.util.Properties;

/**
 * Class SqlDataBase решение задачи Парсер вакансий на sql.ru [#1731].
 *
 * @author Aleksey Lazarev
 * @since 30.04.2019
 */
public class SqlDataBase {
    private final Properties config;
    private Connection connect;

    /**
     * Constructor.
     *
     * @param properties configuration.
     */
    public SqlDataBase(Properties properties) {
        this.config = properties;
    }

    /**
     * Method return configurations.
     *
     * @return configurations.
     */
    public Properties getConfig() {
        return config;
    }

    /**
     * Method connect to db.
     *
     * @param dbname Name database.
     * @return Result connection.
     */
    private boolean setConnection(String dbname) {
        boolean result = false;
        try {
            if (this.connect != null) {
                this.connect.close();
            }
            this.connect = DriverManager.getConnection(
                    this.config.getProperty("jdbc.url") + dbname,
                    this.config.getProperty("jdbc.username"),
                    this.config.getProperty("jdbc.password")
            );
            result = true;
        } catch (SQLException sqle) {
            sqle.printStackTrace();
        }
        return result;
    }

    /**
     * Method load params.
     *
     * @return result load.
     */
    public boolean init() {
        try {
            Class.forName(this.config.getProperty("driver-class-name"));
            if (setConnection(this.config.get("jdbc.dbname").toString())) {
                createTable();
            } else {
                setConnection("");
                createDB();
                setConnection(this.config.get("jdbc.dbname").toString());
                createTable();
            }
        } catch (Exception e) {
            throw new IllegalStateException(e);
        }
        return this.connect != null;
    }

    /**
     * Method load hashset into sqldb.
     *
     * @return result load.
     */
    public boolean load(HashSet<Vacancy> vacancies) {
        boolean result = false;

        String sql = "INSERT INTO vacancy (name, text, link, date) VALUES(?,?,?,?) ON CONFLICT (name) DO NOTHING";
        try (PreparedStatement current = this.connect.prepareStatement(sql)) {
            for (Vacancy vacancy : vacancies) {
                current.setString(1, vacancy.getName());
                current.setString(2, vacancy.getText());
                current.setString(3, vacancy.getLink());
                current.setLong(4, vacancy.getDate());
                current.addBatch();
            }
            result = current.executeBatch().length != 0;
        } catch (BatchUpdateException bue) {
            bue.printStackTrace();
            System.out.println("next");
            bue.getNextException().printStackTrace();
        } catch (SQLException sqle) {
            sqle.getNextException();
        }
        updateTime();
        return result;
    }

    private ResultSet query(String sql) {
        ResultSet result = null;
        try {
            PreparedStatement ps = this.connect.prepareStatement(sql);
            result = ps.executeQuery();
        } catch (SQLException sqle) {
            sqle.printStackTrace();
        }
        return result;
    }

    /**
     * Method get last vacancy date.
     *
     * @return Long format last date.
     */
    public long getLastDate() {
        Calendar calendar = new GregorianCalendar();
        calendar.set(Calendar.DAY_OF_YEAR, 1);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        long res = 0;
        ResultSet rs = query("SELECT MAX(date) FROM vacancy");
        try {
            if (rs.next()) {
                long cur = rs.getLong(1);
                if (cur == 0) {
                    res = calendar.getTimeInMillis();
                } else {
                    res = cur;
                }
            }
        } catch (SQLException se) {
            se.printStackTrace();
        }
        return res;
    }

    /**
     * Method update last update time.
     */
    public void updateTime() {
        try (OutputStream out = new FileOutputStream(Config.class.getClassLoader().getResource("app.properties").getPath())) {
            this.config.setProperty("last.update", String.valueOf(System.currentTimeMillis()));
            this.config.store(out, null);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    /**
     * Method execute sql.
     *
     * @param sql Sql.
     * @return result.
     */
    public boolean exec(String sql) {
        boolean result = false;
        try (Statement current = this.connect.createStatement()) {
            result = current.execute(sql);
        } catch (SQLException sqle) {
            sqle.printStackTrace();
        }
        return result;
    }

    /**
     * Method create table.
     *
     * @return Result of create table.
     */
    private boolean createTable() {
        return exec("CREATE TABLE IF NOT EXISTS vacancy("
                + "id SERIAL, "
                + "name VARCHAR(255), "
                + "text VARCHAR(10000), "
                + "link VARCHAR(300), "
                + "date BIGINT,"
                + "PRIMARY KEY(id),"
                + "UNIQUE (name))");
    }

    /**
     * Method create table.
     *
     * @return Result of create table.
     */
    private boolean createDB() {
        return exec("CREATE DATABASE sqlru;");
    }
}
