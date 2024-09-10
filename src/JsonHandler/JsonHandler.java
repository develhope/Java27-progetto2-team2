package JsonHandler;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.lang.reflect.Type;
import java.util.List;

public class JsonHandler {
    private final Gson gson;

    public JsonHandler() {
        this.gson = new GsonBuilder().setPrettyPrinting().create();
    }

    // Method to read a single object from JSON
    public <T> T readSingleFromJson(String filePath, Class<T> clazz) throws IOException {
        try (FileReader reader = new FileReader(filePath)) {
            return gson.fromJson(reader, clazz);
        }
    }

    // Method to write a single object to JSON
    public <T> void writeToJson(String filePath, T data) throws IOException {
        try (FileWriter writer = new FileWriter(filePath)) {
            gson.toJson(data, writer);
            writer.flush();
        }
    }
    // Method to read and write a single object to JSON
    public <T> List<T> readFromJson(String filePath, Type typeOfT) throws IOException {
        try (Reader reader = new FileReader(filePath)) {
            return gson.fromJson(reader, typeOfT);
        }
    }
}
