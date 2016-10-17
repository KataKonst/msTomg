package convertors;

import models.Table;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.net.UnknownHostException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Iterator;

/**
 * Created by katakonst on 10/15/16.
 */
public class ReplicateData {

    public void replicate(JSONObject obj, MysqlConvertor converter) throws JSONException, SQLException {

        ResultSet rs=TableUtils.queryTable(converter.getMySqlConnection(),new Table(obj.get("name").toString()));
        JSONObject fields=obj.getJSONObject("fields");
        JSONArray array=new JSONArray();

        while(rs.next())
        {
            JSONObject obj2=new JSONObject();

            Iterator<?> keys = fields.keys();

            while( keys.hasNext() ) {
                String key = (String)keys.next();
                obj2.put(key,rs.getInt(key));
            }
         array.put(obj2);

        }

        MongoDB db=new MongoDB();
        try {
            db.connect();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
        for(int i=0;i<array.length();i++)
        {
         db.insert(array.getJSONObject(i),obj.getString("name"));
        }



    }


}
