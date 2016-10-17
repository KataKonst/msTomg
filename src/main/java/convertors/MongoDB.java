package convertors;

import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import com.mongodb.util.JSON;
import org.json.JSONObject;

import java.net.UnknownHostException;

/**
 * Created by katakonst on 10/16/16.
 */
public class MongoDB {
    MongoClient mongo;


    public void connect() throws UnknownHostException {
        mongo = new MongoClient("localhost", 27017);
    }

    public void insert(JSONObject obj, String name) {
        DBObject objToSace = (DBObject) JSON.parse(obj.toString());
        DB db = mongo.getDB("test");
        DBCollection table = db.getCollection(name);
        table.insert(objToSace);
    }


}