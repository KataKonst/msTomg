package convertors;


import org.json.JSONException;
import org.json.JSONObject;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * Created by katakonst on 10/15/16.
 */
public class SchemaReader {



    public  JSONObject readFromFile(String file)
    {
        try {
         return new JSONObject(new String(Files.readAllBytes(Paths.get(file))));


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;


    }
}
