package dstywho.jdbc;

import java.sql.Connection;
import oracle.jdbc.driver.OracleDriver;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Vector;

public class QueryManager {
    public static String HOST     = "jdbc:oracle:thin:@//neptunium.duhs.duke.edu:1521/test2.duhs.duke.edu";
    public static String USERNAME = "achecker";
    public static String PASSWORD = "calgb_0000";
    private Connection   connection;

    public void startConnection() throws SQLException {
        DriverManager.registerDriver(new OracleDriver());
        connection = DriverManager.getConnection(HOST, USERNAME, PASSWORD);
    }

    public Vector<String> getColumnNames(ResultSet resultSet) throws SQLException {
        ResultSetMetaData meta = resultSet.getMetaData();
        Vector<String> columns = new Vector<String>(meta.getColumnCount());
        for (int i = 0; i < meta.getColumnCount(); i++) {
            columns.add(meta.getColumnName(i + 1));
        }
        return columns;
    }

    public Table getRows(ResultSet resultset) throws SQLException {
        Vector<String> columnNames = getColumnNames(resultset);
        Table table = new Table();
        table.setColumns(columnNames);
        while (resultset.next()) {
            Row row = createRow(resultset, columnNames);
            table.insertRow(row);
        }
        return table;
    }

    /**
     * @param resultset
     * @param columnNames
     * @return
     * @throws SQLException
     */
    private Row createRow(ResultSet resultset, Vector<String> columnNames) throws SQLException {
        Row row = new Row();
        row.setColumns(columnNames);
        for (int i = 1; i <= columnNames.size(); i++) {
            row.add(resultset.getString(i));
        }
        return row;
    }

    public Table query(String query) throws SQLException {
        Statement statement = connection.createStatement();
        ResultSet resultSet = null;
        Table table;
        try {
            resultSet = statement.executeQuery(query.toString());
            table = getRows(resultSet);
            resultSet.close();
        }
        finally {
            if (resultSet != null)
                resultSet.close();
            closeStatement(statement);
        }

        return table;

    }

    public void execute(String query) throws SQLException {
        Statement statement = connection.createStatement();
        try {
            statement.execute(query);
        }
        finally {
            closeStatement(statement);
        }
    }

    public void update(String query) throws SQLException {
        Statement statement = connection.createStatement();
        try {
            statement.executeUpdate(query);
        }
        finally {
            closeStatement(statement);
        }
    }

    /**
     * @param statement
     */
    private void closeStatement(Statement statement) {
        if (statement != null) {
            try {
                statement.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        QueryManager qm = new QueryManager();
        try {
            qm.startConnection();

            Table results = qm.query("Select * from participant");
            System.out.println(results.size());

        } catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            qm.closeConnection();
        }
    }

    public void closeConnection() {
        if (connection != null) {
            try {
                connection.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }
}
