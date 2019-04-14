package ru.alazarev.tracker;

import java.io.InputStream;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class TrackerSQL implements ITracker {
    private Connection connection;
    private Properties config = new Properties();

    /**
     * Non-return sql method.
     *
     * @param sql Sql command.
     * @return True if command execute.
     */
    private boolean exSQL(String sql) {
        boolean result = false;
        try (Statement ps = this.connection.createStatement()){
            result = ps.executeUpdate(sql) != 0 ? true : false;
        } catch (SQLException sqle) {
            sqle.printStackTrace();
        }
        return result;
    }

    /**
     * Method return sql result.
     *
     * @param sql Sql command.
     * @return Result set.
     */
    private ResultSet qSQL(String sql) {
        ResultSet result = null;
        try (Statement ps = this.connection.createStatement()){
            result = ps.executeQuery(sql);
        } catch (SQLException sqle) {
            sqle.printStackTrace();
        }
        return result;
    }

    /**
     * Convert ResultSet to Item array.
     *
     * @param resultSet ResultSet.
     * @return Item array.
     */
    private List<Item> qResToItems(ResultSet resultSet) {
        List<Item> result = new ArrayList<>();
        try {
            while (resultSet.next()) {
                result.add(new Item(String.valueOf(resultSet.getInt("id")),
                        resultSet.getString("name"),
                        resultSet.getString("descr"),
                        resultSet.getLong("created"),
                        resultSet.getString("comments")));
            }
        } catch (SQLException sqle) {
            sqle.printStackTrace();
        }
        return result;
    }

    /**
     * Method create tracker table.
     */
    public void createTableTracker() {
        exSQL("CREATE TABLE IF NOT EXISTS " + "public" + ".tracker(" +
                "id SERIAL, " +
                "name VARCHAR(255), " +
                "descr VARCHAR(255), " +
                "created BIGINT, " +
                "comments VARCHAR(1000), " +
                "PRIMARY KEY(id))");
    }

    /**
     * Method create db.
     */
    public void createDB() {
        exSQL("CREATE DATABASE " + this.config.getProperty("dbname"));
    }

    /**
     * Method delete db.
     */
    public void dropDB() {
        setConnection("");
        exSQL("DROP DATABASE " + this.config.getProperty("dbname"));
    }

    /**
     * Method return number of records in db.
     *
     * @return Number of records.
     */
    public int numberOfRecords() {
        int result = 0;
        try {
            ResultSet resultSet = qSQL("SELECT COUNT(*) FROM public.tracker");
            resultSet.next();
            result = resultSet.getInt(1);
        } catch (SQLException sqle) {
            sqle.printStackTrace();
        }
        return result;
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
            if (this.connection != null) {
                this.connection.close();
            }
            this.connection = DriverManager.getConnection(
                    this.config.getProperty("url") + dbname,
                    this.config.getProperty("username"),
                    this.config.getProperty("password")
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
        try (InputStream in = TrackerSQL.class.getClassLoader().getResourceAsStream("app.properties")) {
            this.config.load(in);
            Class.forName(this.config.getProperty("driver-class-name"));
            if (setConnection(this.config.get("dbname").toString())) {
                createTableTracker();
            } else {
                setConnection("");
                createDB();
                setConnection(this.config.get("dbname").toString());
                createTableTracker();
            }
        } catch (Exception e) {
            throw new IllegalStateException(e);
        }
        return this.connection != null;
    }

    /**
     * Method add item into database.
     *
     * @param item Item for add.
     * @return Added item.
     */
    @Override
    public Item add(Item item) {
        String separator = "', '";
        exSQL("INSERT INTO public.tracker (name, descr, created, comments) VALUES ('"
                + item.getName() + separator
                + item.getDesc() + separator
                + item.getCreated() + separator
                + item.getComments() + "');");
        return item;
    }

    /**
     * Method replace item in database.
     *
     * @param id Id replaceable item.
     * @param item Item for replace.
     * @return Result replace.
     */
    @Override
    public Boolean replace(String id, Item item) {
        String separator = "', ";
        return exSQL("UPDATE public.tracker " +
                "SET name ='" + item.getName() + separator +
                "descr ='" + item.getDesc() + separator +
                "created ='" + item.getCreated() + separator +
                "comments ='" + item.getComments() +
                "' WHERE id =" + id + ";"
        );
    }

    /**
     * Method delete item in database.
     *
     * @param id Id deleted item.
     * @return Result delete.
     */
    @Override
    public Boolean delete(String id) {
        return exSQL("DELETE FROM public.tracker WHERE id = '" + id + "';");
    }

    /**
     * Method return all records.
     *
     * @return All records.
     */
    @Override
    public List<Item> findAll() {
        return qResToItems(qSQL("SELECT * FROM public.tracker"));
    }

    /**
     * Method return records find by name.
     *
     * @param name Name for find.
     * @return Find records.
     */
    @Override
    public List<Item> findByName(String name) {
        return qResToItems(qSQL("SELECT * FROM public.tracker WHERE name = '" + name + "';"));
    }

    /**
     * Method return record by id.
     *
     * @param id Id record.
     * @return Result item.
     */
    @Override
    public Item findById(String id) {
        return qResToItems(qSQL("SELECT * FROM public.tracker WHERE id = '" + id + "';")).get(0);
    }
}
