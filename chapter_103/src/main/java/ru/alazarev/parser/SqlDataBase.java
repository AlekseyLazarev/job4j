package ru.alazarev.parser;

import ru.alazarev.array.Config;

import java.io.FileOutputStream;
import java.io.OutputStream;
import java.sql.*;
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
        String sql = "INSERT INTO vacancy (name, text, link) VALUES(?,?,?)";
        try (PreparedStatement current = this.connect.prepareStatement(sql)) {
            for (Vacancy vacancy : vacancies) {
                if (!findByName(vacancy.getName()).next()) {
                    current.setString(1, vacancy.getName());
                    current.setString(2, vacancy.getText());
                    current.setString(3, vacancy.getLink());
                    current.addBatch();
                }
            }
            result = current.executeBatch().length != 0;
        } catch (SQLException sqle) {
            sqle.printStackTrace();
        }
        updateTime();
        return result;
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
     * Method return result select by name.
     *
     * @param name Find name.
     * @return result.
     */
    public ResultSet findByName(String name) {
        ResultSet result = null;
        try {
            PreparedStatement ps = this.connect.prepareStatement("SELECT * FROM vacancy WHERE name = (?);");
            ps.setString(1, name);
            result = ps.executeQuery();
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
                + "PRIMARY KEY(id))");
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
