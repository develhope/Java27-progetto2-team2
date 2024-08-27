package JsonHandler;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.List;

public class JsonHandler{
    private final Gson gson;

    public JsonHandler(){
        this.gson = new GsonBuilder().setPrettyPrinting().create();
    }


    public List<Object> readFromJson(String filePath) throws IOException {
        try(FileReader reader = new FileReader(filePath)){
            Type objectListType = new TypeToken<List<Object>>() {}.getType();
            return gson.fromJson(reader,objectListType);
        }
    }

    public void writeToJson(String filePath, Object object) throws IOException {
        try(FileWriter writer = new FileWriter(filePath)){
            gson.toJson(object,writer);
            writer.flush();
        }
    }
}
