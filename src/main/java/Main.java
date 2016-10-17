import convertors.MysqlConvertor;
import convertors.ReplicateData;
import convertors.SchemaReader;
import org.json.JSONException;
import org.json.JSONObject;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by katakonst on 10/15/16.
 */
public class Main {


    public static void main(String args[]) throws SQLException, JSONException, ClassNotFoundException {   final String DB_URL = "jdbc:mysql://localhost/MongoDB";
        Class.forName("com.mysql.jdbc.Driver");
        Connection conn= DriverManager.getConnection("jdbc:mysql://localhost:3306/mongoDB","root","");
        MysqlConvertor converter=new MysqlConvertor(conn);
        JSONObject OB =new SchemaReader().readFromFile("/home/katakonst/4fun/mysqlToMongo/src/main/resources/schem.json");
        new ReplicateData().replicate(OB,converter);
    }
}
