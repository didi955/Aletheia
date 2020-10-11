package fr.didi955.aletheia.utils;

import fr.didi955.aletheia.json.JSONReader;
import fr.didi955.aletheia.json.JSONWriter;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.File;
import java.io.IOException;

public class Configuration {

    private final JSONObject object;
    private final File file;

    public Configuration(String path) throws IOException {

        this.file = new File(path);

        if(file.exists())
            this.object = new JSONReader(file).toJSONObject();
        else
            object = new JSONObject();
    }

    public String getString(String key, String defaultValue) {

        try {

            if(!object.has(key))
                object.put(key, defaultValue);

            return object.getString(key);
        }
        catch (JSONException e){
            e.printStackTrace();
        }

        return null;
    }

    public int getInt(String key, int defaultValue){

        try {

            if(!object.has(key))
                object.put(key, defaultValue);

            return object.getInt(key);
        }
        catch (JSONException e){
            e.printStackTrace();
        }

        return 1;
    }

    public void save(){

        try (JSONWriter writer = new JSONWriter(file)) {
            writer.write(this.object);
            writer.flush();
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }
}
