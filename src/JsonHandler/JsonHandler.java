package JsonHandler;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.List;

public class JsonHandler<T> {
    private final Gson gson;

    public JsonHandler(){
        this.gson = new GsonBuilder().setPrettyPrinting().create();
    }


    public List<T> readFromJson(String filePath) throws IOException {
        try(FileReader reader = new FileReader(filePath)){
            Type listType = new TypeToken<List<T>>() {}.getType();
            return gson.fromJson(reader,listType);
        }
    }

    public void writeToJson(String filePath, T type) throws IOException {
        try(FileWriter writer = new FileWriter(filePath)){
            gson.toJson(type,writer);
            writer.flush();
        }
    }
}
