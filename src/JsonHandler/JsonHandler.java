package JsonHandler;

import User.Utente;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import utils.UtenteDeserializer;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.lang.reflect.Type;
import java.util.List;

public class JsonHandler {
    private final Gson gson;

    public JsonHandler() {

        GsonBuilder builder = new GsonBuilder()
                .setPrettyPrinting()
                .registerTypeAdapter(Utente.class, new UtenteDeserializer());

        this.gson = builder.create();
    }

    public <T> void writeToJson(String filePath, List<T> data) throws IOException {
        try (FileWriter writer = new FileWriter(filePath)) {
            gson.toJson(data, writer);
            writer.flush();
        }
    }
    public <T> List<T> readFromJson(String filePath, Type typeOfT) throws IOException {
        try (Reader reader = new FileReader(filePath)) {
            return gson.fromJson(reader, typeOfT);
        }
    }


}
