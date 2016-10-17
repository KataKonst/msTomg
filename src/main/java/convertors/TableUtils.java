package convertors;

import models.Table;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by katakonst on 10/15/16.
 */
public class TableUtils {

    public List<Table> getAllTables(Connection connection)
    {

        Statement getAllTablesStatement;
        List<Table> listOfTables=new ArrayList<Table>();

        try {
            getAllTablesStatement = connection.createStatement(
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_UPDATABLE);
            ResultSet resultSet = getAllTablesStatement.executeQuery("SELECT table_name FROM information_schema.tables where table_schema='test'");

            while (resultSet.next()) {
                listOfTables.add(new Table(resultSet.getString(0)));

            }
        } catch (SQLException e) {
            e.printStackTrace();

        }
        return listOfTables;

    }

    public static ResultSet queryTable(Connection connection,Table table)
    {
        Statement  tableRowsResultSet;
        List<Table> listOfTables=new ArrayList<Table>();

        try {
            tableRowsResultSet = connection.createStatement(
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_UPDATABLE);
          return tableRowsResultSet.executeQuery("SELECT * from "+table);


        } catch (SQLException e) {
            e.printStackTrace();

        }
        return null;

    }
}
