package convertors;

import java.sql.Connection;

/**
 * Created by katakonst on 10/15/16.
 */
public class MysqlConvertor {


    private Connection mySqlConnection;

    public MysqlConvertor(Connection mySqlConnection) {
        this.mySqlConnection = mySqlConnection;
    }

    public Connection getMySqlConnection() {
        return mySqlConnection;
    }

    public void setMySqlConnection(Connection mySqlConnection) {
        this.mySqlConnection = mySqlConnection;
    }

    public void replicate()
    {

    }
}
