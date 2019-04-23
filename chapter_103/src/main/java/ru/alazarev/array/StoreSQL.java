package ru.alazarev.array;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Class StoreSQL решение задачи части 003. Урок 4.3. XML XSLT JDBC Оптимизация.
 *
 * @author Aleksey Lazarev
 * @since 14.04.2019
 */
public class StoreSQL implements AutoCloseable {

    private final Config config;
    private Connection connect;
    private Statement currentStatement;

    /**
     * Constructor.
     *
     * @param config Configuration object.
     */
    public StoreSQL(Config config) {
        this.config = config;
    }

    /**
     * Method initiate connection to database and clear table if need.
     */
    public void init() {
        try {
            this.connect = DriverManager.getConnection(this.config.get("driver") + this.config.get("dbname"));
            createTable();
            if (selectAll().next()) {
                clearTable();
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * Method insert values into table.
     *
     * @param start Start values to insert.
     * @param end   End values to insert.
     */
    public void insert(int start, int end) {
        String array = "";
        if (start != 1) {
            start++;
        }
        for (int i = start; i < end; i++) {
            array += "(" + i + ")" + ", ";
        }
        array += "(" + end + ")";
        execute("INSERT INTO entry (field) VALUES " + array + ";");
    }

    /**
     * Method generate values.
     *
     * @param size Size values to generate.
     */
    public void generate(int size) {
        int start = 1;
        int factor = 1;
        int divider = Integer.valueOf(config.get("divider"));
        int part;
        while (start < size) {
            part = Math.floor(size / divider) > factor ? divider * factor : size;
            insert(start, part);
            start = part;
            factor++;
        }
    }

    /**
     * Method load Entries into list.
     *
     * @return List entries.
     */
    public List<Entry> load() {
        List<Entry> result = new ArrayList<>();
        ResultSet actualData = this.selectAll();
        try {
            while (actualData.next()) {
                result.add(new Entry(actualData.getInt(1)));
            }
        } catch (SQLException s) {
            s.printStackTrace();
        }
        return result;
    }

    /**
     * Method close connection.
     *
     * @throws Exception
     */
    @Override
    public void close() throws Exception {
        if (this.connect != null) {
            this.connect.close();
        }
    }

    /**
     * Method execute sql command.
     *
     * @param sql Sql command.
     * @return Result of execute.
     */
    private boolean execute(String sql) {
        boolean result = false;
        try {
            this.currentStatement = this.connect.createStatement();
            result = this.currentStatement.execute(sql);
        } catch (SQLException sqle) {
            sqle.printStackTrace();
        }
        return result;
    }

    /**
     * Method execute sql command and return records.
     *
     * @param sql Sql command.
     * @return Result records.
     */
    private ResultSet query(String sql) {
        ResultSet result = null;
        try {
            this.currentStatement = this.connect.createStatement();
            result = this.currentStatement.executeQuery(sql);
        } catch (SQLException sqle) {
            sqle.printStackTrace();
        }
        return result;
    }

    /**
     * Method return result sql select all command.
     *
     * @return Result sql select all command.
     */
    private ResultSet selectAll() {
        return query("SELECT * FROM entry;");
    }

    /**
     * Method clear table.
     *
     * @return Result of clear table.
     */
    private boolean clearTable() {
        return execute("DELETE FROM entry WHERE field > 0;");
    }

    /**
     * Method create table.
     *
     * @return Result of create table.
     */
    private boolean createTable() {
        return execute("CREATE TABLE if not exists 'entry' ('field' INTEGER);");
    }
}